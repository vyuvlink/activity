package cn.com.act.dao;

import cn.com.act.po.ActivityPo;
import cn.com.act.po.ScenePo;
import cn.com.act.po.SchemePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HelloDao {
    int generateActivitys(List<ActivityPo> list);

    int generateSchemes(List<SchemePo> list);

    int generateScenes(List<ScenePo> list);
}
