package com.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisGeneratorApplication {

	public static void main(String[] args) {
		/**
		 * 禁用系统重启
		 */
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(MybatisGeneratorApplication.class, args);
	}

}

