package com.kafka.fullcyle.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.fullcyle.service.producer.ProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	@Autowired
	private ProducerService producerService;


    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam String message) {
        producerService.sendMessage(message);
    }
    
}
