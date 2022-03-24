package com.example.kafkaproducer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class KafkaproducerApplication {

    public static void main(String[] args){
        SpringApplication.run(KafkaproducerApplication.class, args);
    }
}
