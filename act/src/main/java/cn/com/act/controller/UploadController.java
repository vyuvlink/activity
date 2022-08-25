package cn.com.act.controller;

import cn.com.act.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("upload")
public class UploadController {
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public CommonResult<String> postBodyId(@RequestPart("file") MultipartFile file) {
        String filename = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        // 设置存储对象名称
        String objectName = sdf.format(new Date()) + "/" + filename;
        return CommonResult.success(objectName);
    }
}
