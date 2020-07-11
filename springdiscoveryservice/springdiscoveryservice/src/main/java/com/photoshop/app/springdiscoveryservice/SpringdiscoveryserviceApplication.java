package com.photoshop.app.springdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringdiscoveryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdiscoveryserviceApplication.class, args);
	}

}
