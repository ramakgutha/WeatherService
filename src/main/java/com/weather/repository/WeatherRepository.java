package com.weather.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weather.domain.Weather;

@Repository
public interface WeatherRepository extends CrudRepository<Weather,Long>
{
    Weather findById(long id);
    List<Weather> findAll();
    Weather save(Weather weather);

}
