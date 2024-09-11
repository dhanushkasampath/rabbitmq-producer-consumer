package com.learn.spring_rabbitmq_producer.controller;

import com.learn.spring_rabbitmq_producer.dto.CustomMessage;
import com.learn.spring_rabbitmq_producer.config.MQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage message){
        message.setMessageId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());

        rabbitTemplate.convertAndSend(MQConfig.MY_MESSAGE_EXCHANGE,
                MQConfig.MY_ROUTING_KEY, message);
        return "Message Published!";
    }
}
