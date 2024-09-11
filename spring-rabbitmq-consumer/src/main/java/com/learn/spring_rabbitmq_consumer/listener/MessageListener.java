package com.learn.spring_rabbitmq_consumer.listener;

import com.learn.spring_rabbitmq_consumer.config.MQConfig;
import com.learn.spring_rabbitmq_consumer.dto.CustomMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.MY_MESSAGE_QUEUE)
    public void listener(CustomMessage message){
        System.out.println(message);
    }
}
