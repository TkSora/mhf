package com.neunzwei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyEurekaClient {

	public static void main(String[] args) {
		SpringApplication.run(MyEurekaClient.class, args);
	}

}
