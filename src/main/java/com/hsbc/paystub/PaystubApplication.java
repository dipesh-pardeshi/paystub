package com.hsbc.paystub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PaystubApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaystubApplication.class, args);
	}
}
