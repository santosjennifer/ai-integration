package com.jads.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jads.service.GoogleAPIService;

@RestController
@RequestMapping("/bot")
public class GoogleAPIController {
	
    @Autowired
    private GoogleAPIService service;

//    http://localhost:6001/bot/chat?prompt={pesquisa}
	@GetMapping("/chat")
	public Object chat(@RequestParam("prompt") String prompt) throws JsonProcessingException {
		Object response = service.chat(prompt);
		
	    Map<String, Object> responseMap = new HashMap<>();
	    responseMap.put("resultado:", response);

	    return ResponseEntity.ok().body(responseMap);
	}
}
