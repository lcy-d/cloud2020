package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    public int create(Payment payment);

    public Payment findPaymentById(@Param("id") Long id);
}
