package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.result.CommonResult;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = service.create(payment);
        log.info("【插入操作】payment={}", payment);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功,serverPort=" + serverPort, result);
        } else {
            return new CommonResult<>(444, "插入失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult findPaymentById(@PathVariable("id") Long id) {
        Payment payment = service.findPaymentById(id);
        log.info("【查询操作】查询id={}", id);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查找成功,serverPort=" + serverPort, payment);
        } else {
            return new CommonResult<>(444, "查找失败,查找id：" + id, null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for (ServiceInstance instance : instances) {
                log.info("【discoveryClient】instanceID：" + instance.getInstanceId());
                log.info("【discoveryClient】host + port + uri：" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
                log.info("------------------");
            }
        }
        return services;
    }

    @GetMapping("/lb")
    public String paymentLb() {
        return serverPort;
    }

    @GetMapping("/feign/timeout")
    public String paymentFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
