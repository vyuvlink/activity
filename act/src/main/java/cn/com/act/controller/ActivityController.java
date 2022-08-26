package cn.com.act.controller;

import cn.com.act.common.enums.ResultEnum;
import cn.com.act.common.result.CommonResult;
import cn.com.act.dto.ActivityDto;
import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.SaveActivityParams;
import cn.com.act.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("act")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/backend/save_activity", method = RequestMethod.POST)
    public CommonResult<ActivityDto> saveActivity(@RequestBody SaveActivityParams saveActivityParams) {
        return CommonResult.success(activityService.saveActivity(saveActivityParams));
    }

//    @Cacheable(cacheNames = "query_activity", key = "'query_activity_'+ #id")
    @RequestMapping(value = "/backend/query_activity", method = RequestMethod.GET)
    public CommonResult<ActivityDto> queryActivity(@RequestParam Long id, @RequestParam(required = false) String name, @RequestParam(required = false) Integer state) {
        return CommonResult.success(activityService.queryActivity(id, name, state));
    }

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