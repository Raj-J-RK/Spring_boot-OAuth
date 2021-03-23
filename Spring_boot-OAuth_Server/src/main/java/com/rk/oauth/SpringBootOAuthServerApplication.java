package com.rk.oauth;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
@SpringBootApplication
public class SpringBootOAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOAuthServerApplication.class, args);
	}
	
	@RequestMapping("/validateToken")
	public Principal user(Principal principal) {
		return principal;
	}

}
