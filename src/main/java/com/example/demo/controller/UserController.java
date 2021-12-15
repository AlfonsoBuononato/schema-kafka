package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.engine.UserProducer;
import com.example.demo.model.User;
import com.google.gson.Gson;

@RestController
public class UserController {
	
	@Autowired
	private UserProducer producer;
	@PostMapping("/user")
	public void messageKafka(@RequestParam("name") String name, @RequestParam("age") Integer age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		String json = new Gson().toJson(user);
		producer.sendMessage(user);
	}
}
