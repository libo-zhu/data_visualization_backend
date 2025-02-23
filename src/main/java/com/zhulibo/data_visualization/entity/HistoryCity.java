package com.zhulibo.data_visualization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "history_city")
public class HistoryCity {

    @Id
    private String cityName; // 对应 city_name 字段

    private String url;

    // Getters and Setters

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}