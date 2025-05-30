package com.shop.freshcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "com.shop.freshcart")
@EnableCaching
public class FreshcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshcartApplication.class, args);
	}

}
