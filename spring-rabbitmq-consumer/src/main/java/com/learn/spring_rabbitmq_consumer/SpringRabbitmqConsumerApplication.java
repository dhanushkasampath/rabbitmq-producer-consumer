package com.learn.spring_rabbitmq_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRabbitmqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqConsumerApplication.class, args);
	}

}


// docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
// after this command image will be pulled and run
// this will be called. http://localhost:15672/#/
// default username and password: guest and guest
