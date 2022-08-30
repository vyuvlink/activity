package cn.com.act.dao;

import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.ItemDto;
import cn.com.act.dto.SaveActivityParams;
import cn.com.act.dto.SchemeDto;
import cn.com.act.po.ActivityPo;
import cn.com.act.po.SchemePo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityDao {
    ActivityPo saveActivity(SaveActivityParams saveActivityParams);

    ActivityPo queryActivity(Long id, String name, Integer state);

    List<SchemeDto> querySchemes(Long id);

    List<ItemDto> queryItems(List<String> ids);
}
