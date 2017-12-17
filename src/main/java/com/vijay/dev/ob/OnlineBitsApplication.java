package com.vijay.dev.ob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class OnlineBitsApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlineBitsApplication.class, args);
	}
}
