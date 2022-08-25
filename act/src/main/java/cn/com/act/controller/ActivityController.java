package cn.com.act.controller;

import cn.com.act.common.result.CommonResult;
import cn.com.act.dto.ActivityDto;
import cn.com.act.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("act")
public class ActivityController {
//    @Autowired
//    private ActivityService activityService;
//
//    @RequestMapping(value = "/list", method = RequestMethod.POST)
//    public CommonResult<List<ActivityDto>> list(@RequestBody String id) {
//        return CommonResult.success(activityService.list(id));
//    }
//
//    @RequestMapping(value = "/scene/decode", method = RequestMethod.GET)
//    public CommonResult<String> sceneDecode(@RequestParam String scene) {
//        return CommonResult.success(activityService.sceneDecode(scene));
//    }
}