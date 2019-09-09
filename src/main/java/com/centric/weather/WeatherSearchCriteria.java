package com.centric.weather;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class WeatherSearchCriteria {
    private String zipCode;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
