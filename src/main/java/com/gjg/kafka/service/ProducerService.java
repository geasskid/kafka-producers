package com.gjg.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者业务
 *
 * @author gongjiguang
 * @date 2021/2/5
 */
@Slf4j
@Service
public class ProducerService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message){
        log.info(message);
        kafkaTemplate.send(topic,message);
    }
}
