package com.centric.weather;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Weather {
    private @Id @GeneratedValue Long id;
    private String zipCode;
    private String temperatureMin;
    private String temperatureMax;
    private String rainfall;
    private String avgWindSpeed;
    private String headline;

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(String temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public String getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(String temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getAvgWindSpeed() {
        return avgWindSpeed;
    }

    public void setAvgWindSpeed(String avgWindSpeed) {
        this.avgWindSpeed = avgWindSpeed;
    }

    public Weather(String zipCode, String temperatureMin, String temperatureMax, String rainfall, String avgWindSpeed) {
        this.zipCode = zipCode;
        this.temperatureMin = temperatureMin;
        this.temperatureMax = temperatureMax;
        this.rainfall = rainfall;
        this.avgWindSpeed = avgWindSpeed;
    }

    Weather() {
    }
}
