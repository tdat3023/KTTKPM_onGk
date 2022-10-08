package com.test.onGK.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.onGK.service.ProducerService;

@RestController
@RequestMapping("/producer")
public class MessageApi {
	@Autowired private ProducerService pService;
	
	@PostMapping("/")
	public String producer(@RequestBody String text) throws JsonProcessingException {
		pService.sendToTopic(text);
		
		return text;
	}
}
