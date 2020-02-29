package com.hzero.chenglutest2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author  :cheng-lu
 * @date    :2020/2/29 13:30
 * @description: 第二次考核第三题通过服务调用接口
 * @modified By：
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ChengluTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(ChengluTest2Application.class, args);
	}

}
