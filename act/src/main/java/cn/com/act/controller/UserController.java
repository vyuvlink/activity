package cn.com.act.controller;

import cn.com.act.common.result.CommonResult;
import cn.com.act.dto.UserDto;
import cn.com.act.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "get_user_info", method = RequestMethod.GET)
    public CommonResult<UserDto> getUserInfo(@RequestParam String id) {
        return CommonResult.success(userService.getUserInfo(id));
    }

    @RequestMapping(value = "/backend/login", method = RequestMethod.GET)
    public CommonResult<String> login() {
        return CommonResult.success("请先登录");
    }
}

