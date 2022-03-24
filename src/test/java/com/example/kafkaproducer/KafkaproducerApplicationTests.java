package com.example.kafkaproducer;

import com.alibaba.fastjson.JSONObject;
import com.example.kafkaproducer.model.Masscan_json;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;


public class KafkaproducerApplicationTests {

    public static void main(String[] args) throws IOException {
        sendtest();
    }
    public static void sendtest() throws IOException {
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
        masscan_json = JSONObject.parseObject(json,Masscan_json.class);
        System.out.println(masscan_json);
    }
}
