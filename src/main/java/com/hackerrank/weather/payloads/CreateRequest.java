package com.hackerrank.weather.payloads;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

public class CreateRequest {
    @NotBlank
    private Date date;

    @NotBlank
    private Float lat;

    @NotBlank
    private Float lon;

    @NotBlank
    private String  city;

    @NotBlank
    private String  state;

    @NotBlank
    private Double temperature;

    public  Date getDate(){
        return date;
    }

    public void setDate(){
        LocalDateTime.now();
    }

    public  Float getLat(){
        return lat;
    }

    public void setLat(Float lat){
        this.lat = lat;
    }

    public  Float getLon(){
        return lon;
    }

    public void setLon(Float lon){
        this.lon = lon;
    }

    public  String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public  String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public  Double getTemperature(){
        return temperature;
    }

    public void setTemperature(Double temperature){
        this.temperature = temperature;
    }


}
