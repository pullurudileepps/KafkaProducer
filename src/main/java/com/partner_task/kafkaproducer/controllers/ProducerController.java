package com.partner_task.kafkaproducer.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.partner_task.kafkaproducer.configs.KafkaProducer;
import com.partner_task.kafkaproducer.dtos.CreateUserRequestDto;
import com.partner_task.kafkaproducer.dtos.WelcomeUserDto;
import com.partner_task.kafkaproducer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private final ProductService productService;

    @Autowired
    public ProducerController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/publish")
    public ResponseEntity<?> sendEmail(@RequestBody CreateUserRequestDto requestDto) throws JsonProcessingException {
        try {
            this.productService.sendEmailMessage(requestDto.getFirstName(), requestDto.getLastName(), requestDto.getEmail());
            return ResponseEntity.ok("message has been published");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
