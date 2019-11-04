package com.at2t.blip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.at2t.blip.repository")
@EnableSwagger2
public class BlipApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlipApplication.class, args);
	}

}
