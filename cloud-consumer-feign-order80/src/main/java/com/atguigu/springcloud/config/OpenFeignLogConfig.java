package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignLogConfig {
    @Bean
    public Logger.Level getLevel(){return Logger.Level.FULL;}
}
