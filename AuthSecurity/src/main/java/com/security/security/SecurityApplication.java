package com.security.security;

import com.security.security.security.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.security.security.controller",
		"com.security.security.service",
		"com.security.security.jwt",
		"com.security.security.exception",
		"com.security.security.config"})
@EntityScan("com.security.security.entity")
@EnableJpaRepositories("com.security.security.repository")
@Import(WebSecurityConfig.class)
public class SecurityApplication {

	public static void main(String[] args) {

		SpringApplication.run(SecurityApplication.class, args);
	}

}
