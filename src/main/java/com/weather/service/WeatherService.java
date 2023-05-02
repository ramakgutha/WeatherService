package com.weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.domain.Weather;
import com.weather.repository.WeatherRepository;

@Service
public class WeatherService
{
    @Autowired
    private WeatherRepository repository;
    

    public Weather getWeather(long id)
    {
        Weather weather = repository.findById(id);
        return weather;
    }

    public Weather updateWeather(Weather weather)
    {
       Weather persistedWeather = repository.save(weather);
       return persistedWeather;
    }

    public List<Weather> listWeather()
    {
        List<Weather> weatherList = repository.findAll();
        return weatherList;
    }

    public Weather getHottestCity()
    {
        // TODO: implement your solution here.
        return null;
    }

}
