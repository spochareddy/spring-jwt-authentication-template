package com.sindalah.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sindalah.util.JwtFilter;

@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

	@Bean
	FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> filter = new FilterRegistrationBean<JwtFilter>();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/api/v1/departments");
		return filter;
	}

}
