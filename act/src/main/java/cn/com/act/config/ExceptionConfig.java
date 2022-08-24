package cn.com.act.config;

import cn.com.act.common.result.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import static cn.com.act.common.enums.ResultEnum.UNKNOWN;

@ControllerAdvice
public class ExceptionConfig {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult<String> handleException(Exception e){
        return CommonResult.error(UNKNOWN, e.getMessage());
    }
}