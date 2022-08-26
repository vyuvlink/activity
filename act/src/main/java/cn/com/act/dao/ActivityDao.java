package cn.com.act.dao;

import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.SaveActivityParams;
import cn.com.act.po.ActivityPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    ActivityPo saveActivity(SaveActivityParams saveActivityParams);

    ActivityPo queryActivity(Long id, String name, Integer state);

    List<ActivityPo> queryMultiActivity(Long id);

    List<ActivityPo> queryActivitys(Long id);
}
