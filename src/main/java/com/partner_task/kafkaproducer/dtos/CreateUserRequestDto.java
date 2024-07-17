package com.partner_task.kafkaproducer.dtos;

import lombok.Data;

@Data
public class CreateUserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
}
