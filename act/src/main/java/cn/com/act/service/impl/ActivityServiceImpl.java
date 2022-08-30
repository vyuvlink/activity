package cn.com.act.service.impl;

import cn.com.act.dao.ActivityDao;
import cn.com.act.dto.*;
import cn.com.act.po.ActivityPo;
import cn.com.act.po.SchemePo;
import cn.com.act.service.ActivityService;
import cn.com.act.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    public ActivityDto saveActivity(SaveActivityParams saveActivityParams) {
        if (saveActivityParams.getId() == null) {
            saveActivityParams.setId(SnowFlake.nextId());
        }
        return new ActivityDto();
    }

    public ActivityDto queryActivity(Long id, String name, Integer state) {
        List<String> ids = new ArrayList<>();
        ActivityPo po = activityDao.queryActivity(id, name, state);
        List<SchemeDto> scheme_list = activityDao.querySchemes(po.getId());
        for(SchemeDto so: scheme_list) {
            ids.add(so.getStrScheme_id());
        }
        List<ItemDto> item_list = activityDao.queryItems(ids);
        ActivityDto dto = new ActivityDto();
        dto.setScheme_list(scheme_list);
        dto.setItem_list(item_list);
        dto.setScheme_id(scheme_list.size() == 1 ? scheme_list.get(0).getScheme_id().toString() : "0");
        return dto;
    }
}
