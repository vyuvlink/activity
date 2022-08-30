package cn.com.act.service.impl;

import cn.com.act.dao.HelloDao;
import cn.com.act.po.*;
import cn.com.act.service.HelloService;
import cn.com.act.util.RandomUtil;
import cn.com.act.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloDao helloDao;

    @Override
    public int generateActivitys(Integer qty) {
        List<ActivityPo> act_list = new ArrayList<>();
        List<SchemePo> scheme_list = new ArrayList<>();
        List<ScenePo> scene_list = new ArrayList<>();
        List<ContextPo> context_list = new ArrayList<>();
        List<ItemPo> item_list = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            ActivityPo ao = new ActivityPo();
            ContextPo co = new ContextPo();
            SchemePo so = new SchemePo();
            ScenePo sco = new ScenePo();
            ItemPo io = new ItemPo();

            long activity_id = SnowFlake.nextId();
            long scheme_id = SnowFlake.nextId();
            long item_id = SnowFlake.nextId();

            so.setScheme_id(scheme_id);
            so.setType(1);
            so.setRel_id(activity_id);
            so.setRel_type(1);
            scheme_list.add(so);

            io.setItem_id(item_id);
            io.setName("测试商品");
            io.setCreate_time(1661696711);
            io.setModify_time(1661696711);
            io.setType(1);
            io.setQty(0);
            io.setTotal(100);
            io.setRel_type(1);
            io.setRel_id(scheme_id);
            item_list.add(io);

            sco.setScene(DigestUtils.md5DigestAsHex(RandomUtil.randomString(16).getBytes()));
            sco.setParam("{\"activity_id\":\"" + activity_id + "\"}");
            scene_list.add(sco);

            co.setContext("{\"themeColor\":\"#1393FF\",\"buttonColor\":\"#FFA203\"}");
            context_list.add(co);

            ao.setId(activity_id);
            ao.setName("alex的测试活动" + activity_id);
            ao.setCover("http://127.0.0.1:3001/uploads/MOfN8C2I5QckpEsnRXEw3wEk.png");
            ao.setStart_time(1661696711);
            ao.setEnd_time(1664294400);
            ao.setState(1);
            act_list.add(ao);
        }

        int scheme_flag = helloDao.generateSchemes(scheme_list);
        int scene_flag = helloDao.generateScenes(scene_list);
        int context_flag = helloDao.generateContexts(context_list);
        int item_flag = helloDao.generateItems(item_list);

        for (int i = 0; i < qty; i++) {
            ActivityPo ao = act_list.get(i);
            ao.setContext_id(context_list.get(i).getId());
            ao.setScene_id(scene_list.get(i).getId());
        }

        int act_flag = helloDao.generateActivitys(act_list);
        System.out.printf("act_flag = %d, scheme_flag = %d, scene_flag = %d, context_flag = %d, item_flag = %d", act_flag, scheme_flag, scene_flag, context_flag, item_flag);
        return 1;
    }
}
