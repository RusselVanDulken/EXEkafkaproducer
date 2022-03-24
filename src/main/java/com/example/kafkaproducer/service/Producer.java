package com.example.kafkaproducer.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kafkaproducer.model.message;
import com.example.kafkaproducer.model.testmessage;

import com.example.kafkaproducer.model.Masscan_json;
import com.example.kafkaproducer.service.MasscanService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author 7w1st22
 * @date 2022/3/23	当前系统日期
 * @time 16:17	当前系统时间
 */
@Component
public class Producer implements ApplicationRunner {

    @Autowired
    private MasscanService masscanService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendTestMessage(testmessage msg) throws IOException {
        send("topic_test",msg);
    }

//    public void sendTestMessage(String msg) throws IOException {
//        send("topic_test",msg);
//    }
//
//    public void sendMasscanMessage(String msg) throws IOException {
//        send("topic_test",msg);
//    }

    public void sendMasscanMessage(Masscan_json msg) throws IOException {
        send("topic_test",msg);
    }

    protected void send(String topic, Object msg) throws IOException {
        ProducerRecord<String, String> pr = new ProducerRecord<>(topic, objectMapper.writeValueAsString(msg));
        pr.headers().add("type", msg.getClass().getName().getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(pr);
    }

    public void sendtest() throws IOException {
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//        Calendar calendar = Calendar.getInstance();
//        String dateName = df.format(calendar.getTime());
//
//        testmessage test = new testmessage();
//        test.setId(dateName);
//        test.setCon("----"+test);
//        if (test!=null){
//            messagingService.sendTestMessage(test);
//        }
        Masscan_json masscan_json = new Masscan_json();
        String json = "";
        File f = new File("src/Masscan_kibo_19.20.json");
        if(f.isFile()&&f.exists())
        {
            InputStreamReader read = new InputStreamReader(new FileInputStream(f),"utf-8");
            BufferedReader reader=new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null)
            {
                json += line;
            }
            read.close();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Calendar calendar = Calendar.getInstance();
        String dateName = df.format(calendar.getTime());

        masscan_json = JSONObject.parseObject(json,Masscan_json.class);
        masscan_json.setTimestamp(dateName);

        sendMasscanMessage(masscan_json);
        message masscan1 = new message();
        masscan1.setId(dateName);
        masscan1.setMasscan(JSON.toJSONString(masscan_json));
        masscanService.insert(masscan1);
        System.out.println(masscan1.getMasscan());
        //masscanService.insert(masscan1);


    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0 ;i < 10 ; i++){
            Thread.sleep(1000);
            sendtest();
        }
    }
}
