package com.kafka.fullcyle.service.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
	
	 private final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

	    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.consumerGroupId}")
	    public void consume(String message) throws IOException {
	    	logger.info(String.format("#### -> Mensagem consumida -> %s", message));
	    }

}
