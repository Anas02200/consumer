package com.test.Kadmin.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.stereotype.Service;

import com.test.Kadmin.entities.UserEntity;
import com.test.Kadmin.jpaRepos.UserRepo;


@Service		
public class KafkaConsumer {
	private final Logger logger=LoggerFactory.getLogger(KafkaConsumer.class);
	
	@Autowired
	UserRepo user;
	
	//@KafkaListener(topics="user_data",groupId="group_id")
	@KafkaListener(topics="user_treated",groupId="group_id")
	public void consume(ConsumerRecord<String, UserEntity> message) {
		user.save(message.value());
		logger.info(String.format("Consumed message++ %s %s",message.key(),message.value().toString()));
	}
}