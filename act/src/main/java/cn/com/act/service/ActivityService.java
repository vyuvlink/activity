package cn.com.act.service;

import cn.com.act.dto.ActivityDto;
import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.SaveActivityParams;

public interface ActivityService {
//    String sceneEncode(String scene);
//
//    String saveScheme();

    ActivityDto saveActivity(SaveActivityParams saveActivityParams);

    ActivityDto  queryActivity(Long id, String name, Integer state);
}
