package com.example.demoOAuth2.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {
	private static final Logger LOG = LogManager.getLogger();

	@Override
	public void configure(HttpSecurity http) throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("OAuth2ResourceServer->configure(HttpSecurity http)");
		}
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/api/v1/**").authenticated();
	}
}
