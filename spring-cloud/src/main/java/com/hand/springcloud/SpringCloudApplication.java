package com.hand.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author  :cheng-lu
 * @date    :2020/2/27 20:41
 * @description: SpringCloudApplication
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApplication.class, args);
	}

}
