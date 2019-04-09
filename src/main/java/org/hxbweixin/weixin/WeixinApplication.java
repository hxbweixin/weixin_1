package org.hxbweixin.weixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WeixinApplication {
	public static void main(String[] args) {
		SpringApplication.run(WeixinApplication.class, args);
	}
}

