package com.partner_task.kafkaproducer.configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfiguration {
    @Bean
    public NewTopic publishNewTop(){
       return new NewTopic("email-publish2",5,(short) 1);
    }
}
