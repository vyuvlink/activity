package cn.com.act.service;

import cn.com.act.common.result.CommonPage;
import cn.com.act.dto.ActivityDto;
import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.ActivitySaveParams;
import cn.com.act.dto.ActivitySeckillParams;

import java.util.List;

public interface ActivityService {
    String sceneDecode(String scene);

    ActivityDto saveActivity(ActivitySaveParams activitySaveParams);

    ActivityDto  queryActivity(Long id);

    CommonPage<List<ActivityDto>> queryAllActivity(ActivityQueryParams activityQueryParams);

    String seckill(ActivitySeckillParams activitySeckillParams);
}
