package cn.com.act.dao;

import cn.com.act.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    UserDto getUserInfo(String id);
}