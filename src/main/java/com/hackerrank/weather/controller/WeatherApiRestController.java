package com.hackerrank.weather.controller;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.payloads.CreateRequest;
import com.hackerrank.weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class WeatherApiRestController {
@Autowired
    WeatherRepository weatherRepository;

@PostMapping("/weather")
    public Weather createWeather(@Valid @RequestBody CreateRequest createRequest){
    Weather weather = new Weather(
            createRequest.getDate(),
            createRequest.getCity(),
            createRequest.getState(),
            createRequest.getLat(),
            createRequest.getLon(),
            createRequest.getTemperature()
    );
    weatherRepository.save(weather);
    return weather;
}

@GetMapping("/weather")
    public List<Weather> getAllWeather(){
    List<Weather> weather = weatherRepository.findAll();
    return weather;
}

@GetMapping("/weather/{id}")
public Weather getWeather(@PathVariable int id){
        Weather weather = weatherRepository.findById(id).get();
        return weather;
    }

    @DeleteMapping("/weather/{id}")
    public void delete(@PathVariable int id){
        Weather weather = weatherRepository.findById(id).get();
        if(weather.getId() == id){
            weatherRepository.delete(weather);
        }
}

}
