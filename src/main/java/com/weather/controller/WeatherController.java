package com.weather.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.domain.Weather;
import com.weather.service.WeatherService;

@RestController
public class WeatherController
{
    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/getweather/{id}", method = RequestMethod.GET)
    public Weather getWeather(@PathVariable Long id)
    {
        Weather weather = weatherService.getWeather(id);
        return weather;
    }

    @RequestMapping(value = "/updateweather", method = RequestMethod.GET)
    public Weather updateWeather(@RequestParam("id") Long id, @RequestParam("name") String name,
            @RequestParam("temp") String temp, @RequestParam("pressure") String pressure,
            @RequestParam("humidity") String humidity, @RequestParam("tempmin") String tempMin,
            @RequestParam("tempmax") String tempMax, @RequestParam("windspeed") String windSpeed,@RequestParam("icon") String icon)
    {

        Weather weather = new Weather(id, name, temp, pressure, humidity, tempMin, tempMax, windSpeed,icon);
        weather = weatherService.updateWeather(weather);
        return  weather;
    }

    @RequestMapping(value = "/listweather", method = RequestMethod.GET)
    public List<Weather> listWeather()
    {
        List<Weather> weatherList = weatherService.listWeather();
        return weatherList;
    }

    @RequestMapping(value = "/gethottestcity", method = RequestMethod.GET)
    public Weather getHottestCity()
    {
        Weather hottestCity = weatherService.getHottestCity();
        return hottestCity;
    }
}
