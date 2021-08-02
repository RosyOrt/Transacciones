package com.example.transactionsclientFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaServer
public class TransactionsclientFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TransactionsclientFeignApplication.class, args);
	}

}
