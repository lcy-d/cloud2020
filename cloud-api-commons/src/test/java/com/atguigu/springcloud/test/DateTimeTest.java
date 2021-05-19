package com.atguigu.springcloud.test;

import org.junit.Test;

import java.time.ZonedDateTime;

public class DateTimeTest {
    /*
       测试带时区的时间获取
    */
    @Test
    public void testDateTime(){
        System.out.println(ZonedDateTime.now());
    }
}
