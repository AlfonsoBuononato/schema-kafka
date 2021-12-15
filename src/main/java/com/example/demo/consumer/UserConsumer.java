package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class UserConsumer {
	@KafkaListener(topics = "user")
	public void processMessage(String content){
		String json = content;
		ObjectMapper objectMapper = new ObjectMapper();
		User user;
		try {
			user = objectMapper.readValue(json, User.class);
			System.out.println("Message received: " + user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
