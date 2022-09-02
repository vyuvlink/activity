package cn.com.act.dao;

import cn.com.act.dto.*;
import cn.com.act.po.ActivityPo;
import cn.com.act.po.ScenePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    ScenePo sceneDecode(String scene);

    ActivityPo saveActivity(ActivitySaveParams activitySaveParams);

    ActivityDto queryActivity(Long id);

    List<ActivityDto> queryAllActivity(ActivityQueryParams activityQueryParams);

    List<SchemeDto> querySchemes(Long id);

    List<ItemDto> queryItems(List<String> ids);

    String seckill(ActivitySeckillParams activitySeckillParams);
}
