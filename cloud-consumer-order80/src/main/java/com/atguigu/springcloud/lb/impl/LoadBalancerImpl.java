package com.atguigu.springcloud.lb.impl;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class LoadBalancerImpl implements LoadBalancer {


    /**
     * 定义一个访问计数器
     */
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 更新访问计数器
     */
    private Integer getAndIncrement() {
        //定义当前次数
        int current;
        //定义下一次的次数
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        log.info("【自写轮询】 第{}次访问", current);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        Integer current = this.getAndIncrement();
        if (current == null || current == 0) {
            return null;
        }
        int index = current % serviceInstances.size();
        return serviceInstances.get(index);
    }


}
