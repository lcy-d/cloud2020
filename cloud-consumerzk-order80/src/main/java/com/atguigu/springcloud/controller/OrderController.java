package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order/zk")
@Slf4j
public class OrderController {

    private static final String INVOKE_URL = "http://cloud-previder-payment";

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/get")
    public String getServerPort() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
