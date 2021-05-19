package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional
    public void create(Order order) {

        // 1. 创建订单
        log.info("【创建订单】---> 开始创建订单");
        orderDao.create(order);

        // 2. 扣库存
        log.info("【创建订单】---> 扣减库存 starting");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("【创建订单】---> 扣减库存 end");

        // 3. 减金额
        log.info("【创建订单】---> 扣减金额 starting");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("【创建订单】---> 扣减金额 end");

        // 4. 改状态
        log.info("【创建订单】---> 修改状态 starting");
        orderDao.update(order.getUserId(), 0);
        log.info("【创建订单】---> 修改状态 end");

        // 完成订单
    }
}
