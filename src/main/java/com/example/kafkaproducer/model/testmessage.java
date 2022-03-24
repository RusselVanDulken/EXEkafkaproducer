package com.example.kafkaproducer.model;

/**
 * @author 7w1st22
 * @date 2022/3/23	当前系统日期
 * @time 15:41	当前系统时间
 */
public class testmessage {
    private String id;
    private String con;

    public testmessage() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public testmessage(String id, String con) {
        this.id = id;
        this.con = con;
    }

    @Override
    public String toString() {
        return "testmessage{" +
                "id='" + id + '\'' +
                ", con='" + con + '\'' +
                '}';
    }
}
