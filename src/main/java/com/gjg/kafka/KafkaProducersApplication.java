package com.gjg.kafka;

import com.gjg.kafka.service.FileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaProducersApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaProducersApplication.class, args);
        String filePath = args[0];
        String topic = args[1];
        FileService fileService = context.getBean(FileService.class);
        fileService.read(filePath,topic);
    }

}
