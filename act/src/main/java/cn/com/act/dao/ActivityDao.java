package cn.com.act.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActivityDao {
    String sceneDecode(String scene);

    String sceneEncode(String scene);
}
