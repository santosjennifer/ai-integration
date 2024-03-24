package com.jads.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jads.vo.request.GoogleAPIRequest;
import com.jads.vo.response.GoogleAPIResponse;

@Service
public class GoogleAPIService {
	private Logger logger = Logger.getLogger(GoogleAPIService.class.getName());

	@Value("${api.url}")
	private String apiUrl;

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate template;

	public Object chat(String prompt) throws JsonProcessingException {
		logger.info("Starting Prompt");
		GoogleAPIRequest request = new GoogleAPIRequest(prompt);

		String jsonRequest = new ObjectMapper().writeValueAsString(request);
		logger.info(jsonRequest);

		logger.info("Processing Prompt");
		String url = UriComponentsBuilder
				.fromHttpUrl(apiUrl)
				.queryParam("key", apiKey)
				.build()
				.toUriString();
		GoogleAPIResponse response = template.postForObject(url, request, GoogleAPIResponse.class);

		logger.info("Finishing Prompt");
		String jsonResponse = new ObjectMapper().writeValueAsString(response);
		logger.info(jsonResponse);

		return response.getCandidates().get(0).getContent().getParts().get(0).getText();
	}
}
