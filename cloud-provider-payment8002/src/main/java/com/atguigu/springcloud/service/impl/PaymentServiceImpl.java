package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper mapper;

    @Override
    public int create(Payment payment) {
        return mapper.create(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return mapper.findPaymentById(id);
    }
}
