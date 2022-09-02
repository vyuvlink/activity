package cn.com.act.service.impl;

import cn.com.act.common.redis.RedisUtil;
import cn.com.act.common.result.CommonPage;
import cn.com.act.config.RabbitMqConfig;
import cn.com.act.dao.ActivityDao;
import cn.com.act.dto.*;
import cn.com.act.service.ActivityService;
import cn.com.act.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String sceneDecode(String scene) {
        return activityDao.sceneDecode(scene).getScene();
    }

    @Override
    public ActivityDto saveActivity(ActivitySaveParams activitySaveParams) {
        if (activitySaveParams.getId() == null) {
            activitySaveParams.setId(SnowFlake.nextId());
        }
        return new ActivityDto();
    }

    @Override
    public ActivityDto queryActivity(Long id) {
        ActivityDto dto = activityDao.queryActivity(id);
        if (dto != null) {
            List<String> ids = new ArrayList<>();
            List<SchemeDto> scheme_list = activityDao.querySchemes(id);
            for (SchemeDto so : scheme_list) {
                ids.add(so.getScheme_id());
            }
            List<ItemDto> item_list = activityDao.queryItems(ids);
            dto.setScheme_list(scheme_list);
            dto.setItem_list(item_list);
            dto.setScheme_id(scheme_list.size() == 1 ? scheme_list.get(0).getScheme_id().toString() : "0");
        }
        return dto;
    }

    @Override
    public CommonPage queryAllActivity(ActivityQueryParams activityQueryParams) {
        PageHelper.startPage(activityQueryParams.getPage(), activityQueryParams.getPage_size());
        List<ActivityDto> list = activityDao.queryAllActivity(activityQueryParams);
        return CommonPage.restPage(list);
    }

    @Override
    public String seckill(ActivitySeckillParams activitySeckillParams) {
        String cacheKey = "seckill:" + activitySeckillParams.getUser_id() + ":" + activitySeckillParams.getItem_id();
        Object stock = redisUtil.get("seckill_stock:" + activitySeckillParams.getItem_id());
        int currentQty = 0;
        if (stock == null) {
            ItemDto io = activityDao.queryItem(activitySeckillParams.getItem_id());
            int qty = io.getTotal() - io.getQty();
            currentQty = qty > 1 ? qty - 1 : qty;
            redisUtil.set("seckill_stock:" + io.getItem_id(), currentQty, 86400);
        } else if ((int) stock > 0) {
            currentQty = (int) stock;
        }
        if (currentQty == 0) {
            return "已售罄";
        }
        if (redisUtil.get(cacheKey) == null) {
            redisUtil.set(cacheKey, activitySeckillParams.toString(), 86400);
            if (currentQty > 0) {
                activitySeckillParams.setOrder_id(SnowFlake.nextId());
                activitySeckillParams.setRel_id(activitySeckillParams.getItem_id());
                activityDao.seckill(activitySeckillParams);
                rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY, activitySeckillParams.toString());
            }

            return "秒杀成功";
        }
        return "已参与秒杀";
    }
}
