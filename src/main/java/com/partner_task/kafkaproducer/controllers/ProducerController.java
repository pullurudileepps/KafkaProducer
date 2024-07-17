package com.partner_task.kafkaproducer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partner_task.kafkaproducer.configs.KafkaProducer;
import com.partner_task.kafkaproducer.dtos.CreateUserRequestDto;
import com.partner_task.kafkaproducer.dtos.WelcomeUserDto;
import com.partner_task.kafkaproducer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Email")
public class ProducerController {
    private final ProductService productService;

    @Autowired
    public ProducerController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/")
    public void sendEmail(@RequestBody CreateUserRequestDto requestDto) throws JsonProcessingException {
        this.productService.sendEmailMessage(requestDto.getFirstName(), requestDto.getLastName(), requestDto.getEmail());
    }
}
