package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "------服务调用失败 paymentInfo_OK provider可能已宕机";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "------服务调用失败 paymentInfo_TimeOut provider可能已宕机";
    }
}
