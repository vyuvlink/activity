package cn.com.act.controller;

import cn.com.act.common.result.CommonPage;
import cn.com.act.common.result.CommonResult;
import cn.com.act.dto.ActivityDto;
import cn.com.act.dto.ActivityQueryParams;
import cn.com.act.dto.ActivitySaveParams;
import cn.com.act.dto.ActivitySeckillParams;
import cn.com.act.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("act")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping(value = "/backend/scene_decode", method = RequestMethod.GET)
    public CommonResult<String> sceneEncode(@RequestParam String scene) {
        return CommonResult.success(activityService.sceneDecode(scene));
    }

    @RequestMapping(value = "/backend/save_activity", method = RequestMethod.POST)
    public CommonResult<ActivityDto> saveActivity(@RequestBody ActivitySaveParams activitySaveParams) {
        return CommonResult.success(activityService.saveActivity(activitySaveParams));
    }

    @Cacheable(cacheNames = "query_activity", key = "'query_activity_'+ #id")
    @RequestMapping(value = "/backend/query_activity", method = RequestMethod.GET)
    public CommonResult<ActivityDto> queryActivity(@RequestParam Long id) {
        return CommonResult.success(activityService.queryActivity(id));
    }

    @RequestMapping(value = "/backend/query_all_activity", method = RequestMethod.POST)
    public CommonResult<CommonPage> queryActivity(@RequestBody ActivityQueryParams activityQueryParams) {
        return CommonResult.success(activityService.queryAllActivity(activityQueryParams));
    }

    @RequestMapping(value = "/seckill", method = RequestMethod.POST)
    public CommonResult<String> seckill(@RequestBody ActivitySeckillParams activitySeckillParams) {
        return CommonResult.success(activityService.seckill(activitySeckillParams));
    }
}