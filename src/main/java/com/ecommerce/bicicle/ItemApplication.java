package com.ecommerce.bicicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableCaching
public class ItemApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ItemApplication.class);
		application.setAdditionalProfiles("ssl");
		application.run(args);
	}

}
