package com.learn.spring_rabbitmq_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitmqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqProducerApplication.class, args);
	}

}

// docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
// after this command image will be pulled and run
// this will be called. http://localhost:15672/#/
// default username and password: guest and guest

// even the docker stopped or restarted, the messages sent to rabbit will be there until deleted or consumed.

/**
 *
 * deleting messages after consuming is the default behavior of RabbitMQ. But if we still want to keep them persisted
 * even after the consumption we can use an approach as follows.
 *
 * Manual Acknowledgment: You can stop acknowledging messages to keep them in the queue,
 * but this might cause RabbitMQ to re-deliver them if the consumer crashes or disconnects.
 *
 * Requeue After Consumption: After processing a message, you can manually send it back to the queue.
 *
 * Persistent Storage: The most reliable approach is to persist messages in a database or other
 * storage system if you need to retain a history of consumed messages.
 *
 */