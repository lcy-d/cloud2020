package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import org.springframework.cloud.stream.messaging.Source;



import java.util.UUID;

@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements MessageProvider {
    @Resource
    private MessageChannel output;
    @Override
    public String sendMsg() {
        String uuid = UUID.randomUUID().toString();
        Message<String> message = MessageBuilder.withPayload(uuid).build();
        this.output.send(message);
        log.info("【message】{}", uuid);
        return uuid;
    }
}
