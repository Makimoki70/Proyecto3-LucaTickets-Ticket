package com.proyecto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LucaTicketsTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LucaTicketsTicketsApplication.class, args);
	}

}
