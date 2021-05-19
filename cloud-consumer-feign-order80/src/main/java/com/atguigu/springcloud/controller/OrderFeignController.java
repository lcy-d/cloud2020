package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService service;

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut() {
        return service.paymentFeignTimeOut();
    }

    @GetMapping("/consumer/payment/lb")
    public String paymentLb() {
        return service.paymentLb();
    }
}
