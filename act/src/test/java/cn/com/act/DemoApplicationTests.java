package cn.com.act;

import cn.com.act.dto.UserDto;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils; // MD5

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static String randomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer s = new StringBuffer();
        Random random = new Random();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            s.append(str.charAt(number));
        }
        s.append(":");
        s.append(System.currentTimeMillis());
        return s.toString();
    }

    @Test
    void testHash() {
        HashSet<String> set = new HashSet<String>();
        int count = 0;
        long stime = System.currentTimeMillis();
        for(int i = 0;i<50000000;i++) {
            String str = DigestUtils.md5DigestAsHex(randomString(16).getBytes());
            if (set.contains(str)) {
                count++;
            } else {
                set.add(str);
            }
        }
        long etime = System.currentTimeMillis();
        System.out.println("碰撞次数：" + count);
        System.out.println("执行时间：" + (etime - stime));
    }

    @Test
    void testRandom() {
        Random rand = new Random();
        int number = rand.nextInt(Integer.MAX_VALUE);
        System.out.println(number);
    }

    @Test
    void testMd5() {
        String pws = DigestUtils.md5DigestAsHex("abd".getBytes());
        System.out.println(pws);
    }

    @Test
    void testJson() throws JsonProcessingException {
        UserDto user = new UserDto();
        user.setId("123456");

        // FastJson 序列化
        String json1 = JSONObject.toJSONString(user);
        System.out.println("FastJson 解析结果: " + json1);

        // Gson 序列化
        Gson gson = new Gson();
        String json2 = gson.toJson(user);
        System.out.println("Gson 解析结果: " + json2);

        // JackJson 序列化
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        String json3 = objectMapper.writeValueAsString(user);
        System.out.println("JackJson 解析结果: " + json3);
    }

    @Test
    void testUnJson() throws JsonProcessingException {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("id", "123456");
        map.put("name", "alex");
        map.put("phone", "15000000000");
        String json = map.toString().replace("=", "\":\"").replace(",", "\",\"").replace("{", "{\"").replace("}", "\"}");
        System.out.println(json);
        System.out.println("{\"id\":1,\"name\":\"John同学\",\"removed\":false}");

        // FastJson 反序列化
        UserDto user1 = JSONObject.parseObject(json, UserDto.class);
        System.out.println("FastJson 解析结果: " + user1);

        // Gson 反序列化
        Gson gson = new Gson();
        UserDto user2 = gson.fromJson(json, UserDto.class);
        System.out.println("Gson 解析结果: " + user2);

        // JackJson 反序列化
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        UserDto user3 = objectMapper.readValue(json, UserDto.class);
        System.out.println("JackJson 解析结果: " + user3);
    }

}
