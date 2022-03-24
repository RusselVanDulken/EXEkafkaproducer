package com.example.kafkaproducer.model;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author 7w1st22
 * @package_name PACKAGE_NAME    创建新文件的包的名称
 * @date 2022/3/14	当前系统日期
 * @time 10:09	当前系统时间
 */

public class Masscan_json {
    private String device_id;
    private String timestamp;
    private ArrayList<String> asset_segment;
    private Integer asset_total;
    private ArrayList<String> detail_msg;

    public Masscan_json() {
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<String> getAsset_segment() {
        return asset_segment;
    }

    public void setAsset_segment(ArrayList<String> asset_segment) {
        this.asset_segment = asset_segment;
    }

    public Integer getAsset_total() {
        return asset_total;
    }

    public void setAsset_total(Integer asset_total) {
        this.asset_total = asset_total;
    }

    public ArrayList<String> getDetail_msg() {
        return detail_msg;
    }

    public void setDetail_msg(ArrayList<String> detail_msg) {
        this.detail_msg = detail_msg;
    }

    public Masscan_json(String device_id, String timestamp, ArrayList<String> asset_segment, Integer asset_total, ArrayList<String> detail_msg) {
        this.device_id = device_id;
        this.timestamp = timestamp;
        this.asset_segment = asset_segment;
        this.asset_total = asset_total;
        this.detail_msg = detail_msg;
    }

    @Override
    public String toString() {
        return "Masscan_json{" +
                "device_id='" + device_id + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", asset_segment=" + asset_segment +
                ", asset_total=" + asset_total +
                ", detail_msg=" + detail_msg +
                '}';
    }
}
