package com.sample.library.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
	
	@Configuration
	public static class HttpSecurityConfiguration extends WebSecurityConfigurerAdapter
	{
		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			http
				//for h2 console blank screen issue
				.headers().frameOptions().disable()
				.and()
				.csrf()
				.disable()
				.authorizeRequests()
				.antMatchers("/api/**","/swagger-ui.html**").permitAll()
				.antMatchers("/swagger-ui.html","/swagger-resources/**","/webjars/**","/v2/api-docs").permitAll()
				.antMatchers("/h2-console/**").permitAll()
				.requestMatchers(EndpointRequest.to("health","info","mappings")).permitAll()
				.anyRequest().authenticated()
				.and()
				.httpBasic();
				
		}
		
		
	}

}
