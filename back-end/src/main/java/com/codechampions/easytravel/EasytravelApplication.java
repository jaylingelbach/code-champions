package com.codechampions.easytravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EasytravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasytravelApplication.class, args);
	}

}
