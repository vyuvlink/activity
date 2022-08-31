package cn.com.act.service.impl;

import cn.com.act.common.result.CommonPage;
import cn.com.act.dao.ActivityDao;
import cn.com.act.dto.*;
import cn.com.act.po.ActivityPo;
import cn.com.act.service.ActivityService;
import cn.com.act.util.SnowFlake;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public String sceneDecode(String scene) {
        return activityDao.sceneDecode(scene).getScene();
    }

    @Override
    public ActivityDto saveActivity(SaveActivityParams saveActivityParams) {
        if (saveActivityParams.getId() == null) {
            saveActivityParams.setId(SnowFlake.nextId());
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
}
