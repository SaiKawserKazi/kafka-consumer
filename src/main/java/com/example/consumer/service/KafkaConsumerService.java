package com.example.consumer.service;

import com.example.consumer.dto.UserCreate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        try {
            UserCreate userCreate = objectMapper.readValue(message, UserCreate.class);
            logger.info("Consumed and converted message: {}", userCreate);
        } catch (Exception e) {
            logger.error("Failed to convert message to UserCreate", e);
        }
    }
}
