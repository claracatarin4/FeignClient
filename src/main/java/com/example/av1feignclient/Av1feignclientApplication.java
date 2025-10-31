package com.example.av1feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Av1feignclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Av1feignclientApplication.class, args);
	}

}
