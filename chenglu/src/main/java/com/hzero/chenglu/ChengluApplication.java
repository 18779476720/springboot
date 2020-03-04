package com.hzero.chenglu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author  :cheng-lu
 * @date    :2020/3/1 13:56
 * @description: ChengluApplication
 * @modified By：
 * @version: 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@Component
public class ChengluApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChengluApplication.class, args);
	}

}
