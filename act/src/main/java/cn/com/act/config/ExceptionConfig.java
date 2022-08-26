package cn.com.act.config;

import cn.com.act.common.result.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static cn.com.act.common.enums.ResultEnum.UNKNOWN;

@ControllerAdvice
public class ExceptionConfig {
    Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @ExceptionHandler(value= RuntimeException.class)
    public CommonResult<String> RunTimeHandleException(RuntimeException e) {
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, "运行时异常");
    }

    @ResponseBody
    @ExceptionHandler(value= DataAccessException.class)
    public CommonResult<String> DataAccessHandleException(DataAccessException e) {
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, "数据库异常");
    }

    @ResponseBody
    @ExceptionHandler(value= SQLException.class)
    public CommonResult<String> SqlHandleException(SQLException e) {
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, "数据库操作异常");
    }

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<String> NotValidExceptionHandler(MethodArgumentNotValidException e) {
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, "参数异常");
    }

    @ResponseBody
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public CommonResult<String> NoHandlerFoundExceptionHandler(Exception e) {
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, "路由异常");
    }

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public CommonResult<String> NullPointerExceptionHandler(NullPointerException e){
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, "空指针异常");
    }

    @ResponseBody
    @ExceptionHandler(Throwable.class)
    public CommonResult<String> DefaultExceptionHandler(Exception e) {
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public CommonResult<String> Exception(Exception e) {
        logger.error(e.getMessage());
        return CommonResult.error(UNKNOWN, e.getMessage());
    }
}