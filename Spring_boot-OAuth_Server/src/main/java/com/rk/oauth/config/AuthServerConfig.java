package com.rk.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) {
		endpointsConfigurer.authenticationManager(manager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
		configurer.inMemory().withClient("clientId").secret("clientSecret").authorizedGrantTypes("client_credentials")
		.scopes("resource-server-read","resource-server-write");
	}

}
