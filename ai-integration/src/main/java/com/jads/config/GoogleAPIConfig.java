package com.jads.config;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GoogleAPIConfig {
	private Logger logger = Logger.getLogger(GoogleAPIConfig.class.getName());

	@Bean
	RestTemplate template() {
		logger.info("Initializing RestTemplate");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {

			return execution.execute(request, body);
		});
		return restTemplate;
	}
}