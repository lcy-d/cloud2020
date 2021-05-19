package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.UUID;

@RequestMapping("/payment")
@RestController
public class PaymentController {



    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk")
    public String zk(){
        return "springCloud with zookeeper: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
