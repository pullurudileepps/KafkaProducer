package com.partner_task.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.partner_task.kafkaproducer.dtos.CreateUserRequestDto;

public interface ProductService {
    void sendEmailMessage(String firstName, String lastName, String email) throws JsonProcessingException;
}
