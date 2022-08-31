package cn.com.act.service;

import cn.com.act.common.result.CommonPage;
import cn.com.act.dto.ActivityDto;
import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.SaveActivityParams;

import java.util.List;

public interface ActivityService {
    String sceneDecode(String scene);

    ActivityDto saveActivity(SaveActivityParams saveActivityParams);

    ActivityDto  queryActivity(Long id);

    CommonPage<List<ActivityDto>> queryAllActivity(ActivityQueryParams activityQueryParams);
}
