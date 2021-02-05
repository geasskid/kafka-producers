package com.gjg.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 文件业务
 *
 * @author gongjiguang
 * @date 2021/2/5
 */
@Slf4j
@Service
public class FileService {

    private final ProducerService producerService;

    @Autowired
    public FileService(ProducerService producerService) {
        this.producerService = producerService;
    }

    public void read(String filePath,String topic) {
        FileInputStream inputStream = null;
        Scanner sc = null;
        String line;
        try {
            inputStream = new FileInputStream(filePath);
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                line = line.trim();
                producerService.send(topic,line);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}
