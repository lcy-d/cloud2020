package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);
}
