package com.kafka.fullcyle.service.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
	
    @Value("${kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;



	public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		logger.info(String.format("$$$$ => Producing message: %s", message));

		//Se não quisermos obter o resultado da mesangem enviada, deixamos o bloco de código abaixo
		this.kafkaTemplate.send(topic, message);
		
		//Se quiser obter o resultado da mesangem enviada, deixamos o bloco de código abaixo
//		ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC, message);
//		
//		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//			
//			@Override
//			public void onFailure(Throwable ex) {
//				logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
//			}
//
//			@Override
//			public void onSuccess(SendResult<String, String> result) {
//				logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
//			}
//			
//		});
	}

}
