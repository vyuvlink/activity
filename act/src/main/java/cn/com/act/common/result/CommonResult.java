package cn.com.act.common.result;

import cn.com.act.common.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {

    private Integer code;
    private T data;
    private String msg;

    public static <T> CommonResult<T> error(ResultEnum code, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.code = code.getCode();
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = ResultEnum.SUCCESS.getCode();
        result.msg = "";
        result.data = data;
        return result;
    }
}
