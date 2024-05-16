package com.jads.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jads.service.GoogleAPIService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/bot")
@Tag(name = "AI Integration")
@OpenAPIDefinition(info = @Info(title = "AI Integration API", version = "v1.0", description = "Documentation AI Integration with Google Gemini"))
public class GoogleAPIController {
	
    private GoogleAPIService service;
    
    public GoogleAPIController(GoogleAPIService service) {
		this.service = service;
	}

	@GetMapping("/chat")
	public ResponseEntity<Object> chat(@RequestParam("prompt") String prompt) {
		Object response = service.chat(prompt);
		
	    Map<String, Object> responseMap = new HashMap<>();
	    responseMap.put("result:", response);

	    return ResponseEntity.ok().body(responseMap);
	}
}
