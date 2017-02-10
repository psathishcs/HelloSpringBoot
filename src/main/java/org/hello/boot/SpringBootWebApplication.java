package org.hello.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootWebApplication {
	public static void main(String args[]) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
	
}
