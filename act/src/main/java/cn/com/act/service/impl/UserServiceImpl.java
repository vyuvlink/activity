package cn.com.act.service.impl;

import cn.com.act.dao.UserDao;
import cn.com.act.dto.UserDto;
import cn.com.act.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDto getUserInfo(String id) {
        return userDao.getUserInfo(id);
    }

}
