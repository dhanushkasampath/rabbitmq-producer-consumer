package com.learn.spring_rabbitmq_producer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * we need to create a queue, exchange and bind those together
 */
@Configuration
public class MQConfig {

    public static final String MY_MESSAGE_QUEUE = "my_message_queue";
    public static final String MY_MESSAGE_EXCHANGE = "my_message_exchange";
    public static final String MY_ROUTING_KEY = "my_routing_key";

    // creating the queue
    @Bean
    public Queue queue(){
        // durable queue step-1
//        return new Queue(MY_MESSAGE_QUEUE, true);// passing true means the queue does not remove data once consumed
        return new Queue(MY_MESSAGE_QUEUE);// passing true means the queue does not remove data once consumed
    }

    // creating the exchange
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(MY_MESSAGE_EXCHANGE);
    }

    // now we need to bind above together
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder
            .bind(queue)
            .to(exchange)
            .with(MY_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConversionException(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConversionException());
//        template.setMandatory(true); // durable queue step-2
        return template;
    }
}
