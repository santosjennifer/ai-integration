package com.jads.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(GoogleAPIService.class);
	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	@Value("${api.url}")
	private String apiUrl;

	@Value("${api.key}")
	private String apiKey;

	public GoogleAPIService(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
	}

	public Object chat(String prompt) {
		logger.info("Start Prompt");

		GoogleAPIRequest request = new GoogleAPIRequest(prompt);

		try {
			String jsonRequest = serializeObject(request);
			logger.info("Request: {}", jsonRequest);

			String url = buildUrl();
			GoogleAPIResponse response = sendRequest(url, request);

			String jsonResponse = serializeObject(response);
			logger.info("Response: {}", jsonResponse);

			return extractResponseText(response);
		} catch (JsonProcessingException e) {
			logger.error("Error processing JSON", e);
			throw new RuntimeException("Error processing JSON", e);
		} catch (Exception e) {
			logger.error("Error during API request", e);
			throw new RuntimeException("Error during API request", e);
		} finally {
			logger.info("Finish Prompt");
		}
	}

	private String serializeObject(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}

	private String buildUrl() {
		return UriComponentsBuilder.fromHttpUrl(apiUrl).queryParam("key", apiKey).build().toUriString();
	}

	private GoogleAPIResponse sendRequest(String url, GoogleAPIRequest request) {
		return restTemplate.postForObject(url, request, GoogleAPIResponse.class);
	}

	private String extractResponseText(GoogleAPIResponse response) {
		return response.getCandidates().get(0).getContent().getParts().get(0).getText();
	}

}
