package com.example.kafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class KafkaproducerApplication {

    public static void main(String[] args){
        SpringApplication.run(KafkaproducerApplication.class, args);
    }
}
