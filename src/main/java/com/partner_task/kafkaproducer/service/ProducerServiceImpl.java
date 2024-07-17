package com.partner_task.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partner_task.kafkaproducer.dtos.CreateUserRequestDto;
import com.partner_task.kafkaproducer.dtos.WelcomeUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProductService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendEmailMessage(String firstName, String lastName, String email) throws JsonProcessingException {
        WelcomeUserDto welcomeUserDto = new WelcomeUserDto();
        welcomeUserDto.setFirstName(firstName);
        welcomeUserDto.setLastName(lastName);
        welcomeUserDto.setEmail(email);
        welcomeUserDto.setFrom("admin@yourdomain.com");
        welcomeUserDto.setSubject("Welcome to Our Platform!");
        welcomeUserDto.setBody("Dear " + firstName + ", welcome to our platform. We are excited to have you onboard!");

        String message = objectMapper.writeValueAsString(welcomeUserDto);
        kafkaTemplate.send("sendEmail", message);
    }
}
