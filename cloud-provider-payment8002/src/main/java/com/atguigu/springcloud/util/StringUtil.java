package com.atguigu.springcloud.util;

import java.util.UUID;

public class StringUtil {
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
