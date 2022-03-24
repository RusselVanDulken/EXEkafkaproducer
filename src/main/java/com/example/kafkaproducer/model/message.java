package com.example.kafkaproducer.model;

import lombok.Data;

/**
 * @author 7w1st22
 * @date 2022/3/24	当前系统日期
 * @time 13:29	当前系统时间
 */
@Data
public class message {
    private String id;
    private String masscan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasscan() {
        return masscan;
    }

    public void setMasscan(String masscan) {
        this.masscan = masscan;
    }
}
