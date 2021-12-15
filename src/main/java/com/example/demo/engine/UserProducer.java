package com.example.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
	private static final String TOPIC = "user";

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendMessage(User user) {
	    this.kafkaTemplate.send(this.TOPIC, user.getName(), user); 
	    log.info(String.format("Produced user -> %s", user));
	  }
}
