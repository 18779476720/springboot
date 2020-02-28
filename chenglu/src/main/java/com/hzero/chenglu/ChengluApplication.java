package com.hzero.chenglu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;

@EnableEurekaClient
@SpringBootApplication
@Component
public class ChengluApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChengluApplication.class, args);
	}

}
