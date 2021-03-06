package com.example.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaSchemaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaSchemaApplication.class, args);
	}

}
