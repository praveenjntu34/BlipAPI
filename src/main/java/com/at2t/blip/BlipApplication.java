package com.at2t.blip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.at2t.blip.repository")
public class BlipApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlipApplication.class, args);
	}

}
