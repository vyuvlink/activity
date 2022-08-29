package cn.com.act.util;

import java.util.Random;

public class RandomUtil {
    public static String randomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer s = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            s.append(str.charAt(number));
        }
        s.append(":");
        s.append(System.currentTimeMillis());
        return s.toString();
    }
}
