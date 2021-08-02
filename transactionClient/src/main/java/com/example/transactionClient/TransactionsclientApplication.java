package com.example.transactionClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TransactionsclientApplication {

	public static void main(String[] args) {
//		DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//		 LocalDateTime dateTimeS = LocalDateTime.parse("08-12-1994 13:30", formater);
//		 System.out.println(dateTimeS.toString());
		SpringApplication.run(TransactionsclientApplication.class, args);
	}

}
