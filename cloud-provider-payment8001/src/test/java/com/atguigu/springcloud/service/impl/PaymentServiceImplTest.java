package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.util.StringUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceImplTest {

    @Resource
    private PaymentService service;

    @Test
    void create() {
        Payment payment = new Payment();
        payment.setSerial(StringUtil.getUUID());
        int i = service.create(payment);
        Assert.assertEquals(1, i);
    }

    @Test
    void findPaymentById() {
        Payment paymentById = service.findPaymentById((long) 1);
        Assert.assertNotNull(paymentById);
    }

    /*
       测试获取时间 Java8 新特性
    */
    @Test
    public void testTime() {
        ZonedDateTime dateTime = ZonedDateTime.now(); //默认时区
        System.out.println(dateTime);
        //2021-05-13T20:53:19.381+08:00[GMT+08:00]
    }
}