package cn.com.act.controller;

import cn.com.act.common.enums.ResultEnum;
import cn.com.act.common.rabbitmq.RabbitmqUtil;
import cn.com.act.common.redis.RedisUtil;
import cn.com.act.common.result.CommonResult;
import cn.com.act.config.RabbitMqConfig;
import cn.com.act.dto.UserDto;
import cn.com.act.service.HelloService;
import cn.com.act.util.RandomUtil;
import cn.com.act.util.SnowFlake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static cn.com.act.common.enums.ResultEnum.UNKNOWN;

@RestController
@RequestMapping("hello")
public class HelloWorldController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloService helloService;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("test")
    public CommonResult sayHello(@RequestHeader HttpHeaders headers) {
        String orgcode = headers.get("orgcode") != null ? headers.get("orgcode").get(0) : "未知错误";
        return CommonResult.error(UNKNOWN, orgcode);
    }

    @GetMapping("snow")
    public CommonResult SnowFlake() {
        return CommonResult.success(SnowFlake.nextId());
    }

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public String id(@PathVariable String id) {
        return id;
    }

    @RequestMapping(value = "/get_id", method = RequestMethod.GET)
    public String getId(@RequestParam String id) {
        return id;
    }

    @RequestMapping(value = "/post_body_id", method = RequestMethod.POST)
    public String postBodyId(@RequestBody UserDto user) {
        System.out.printf(user.toString());
        return "";
    }

    @RequestMapping(value = "/post_str_id", method = RequestMethod.POST)
    public String postStrId(@RequestParam Map<String, String> map) {
        return map.get("id");
    }

    @RequestMapping(value = "/redis/set")
    public CommonResult<Object> set(@RequestParam("key") String key,
                                    @RequestParam("value") String value,
                                    @RequestParam("time") long time) {
        if (time > 0) {
            return CommonResult.success(redisUtil.set(key, value, time));
        } else {
            return CommonResult.error(UNKNOWN, "时间设置有误");
        }
    }

    @RequestMapping("/redis/get")
    public CommonResult<Object> get(@RequestParam("key") String key) {
        return CommonResult.success(redisUtil.get(key));
    }

    @RequestMapping("/logger")
    public CommonResult<String> logger() {
        //日志级别 由低到高
        logger.trace("trace 级别日志");
        logger.debug("debug 级别日志");
        logger.info("info 级别日志");
        logger.warn("warn 级别日志");
        logger.error("error 级别日志");
        return CommonResult.success("");
    }

    @RequestMapping("/hash")
    public CommonResult<String> hash(@RequestParam Integer qty) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < qty; i++) {
            String str = DigestUtils.md5DigestAsHex(RandomUtil.randomString(16).getBytes());
            list.add("\"" + str + "\"");
        }
        String newName = UUID.randomUUID().toString() + System.currentTimeMillis() + ".txt";
        File file = new File("D:/developer/project/uploads", newName);
//        System.out.printf("dir:" + System.getProperty("user.dir"));
        try {
            FileOutputStream fs = new FileOutputStream(file);
            fs.write(list.toString().getBytes(StandardCharsets.UTF_8));
            fs.flush();
            fs.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return CommonResult.error(ResultEnum.LOCKED, "fail");
        }

        return CommonResult.success("done");
    }

    @RequestMapping("/generate_activitys")
    public CommonResult<Integer> generateActivitys(@RequestParam Integer qty) {
        return CommonResult.success(helloService.generateActivitys(qty));
    }

    @RequestMapping("/rabbitmq")
    public CommonResult<Integer> rabbitmqIn(@RequestParam String msg) {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, RabbitMqConfig.ROUTINGKEY, msg);
        return CommonResult.success(0);
    }
}

