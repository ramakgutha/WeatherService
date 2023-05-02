package com.weather;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.domain.Weather;
import com.weather.repository.WeatherRepository;

@SpringBootApplication
public class WeatherApplication
{
    private static final Logger logger = LoggerFactory.getLogger(WeatherApplication.class);

    @Autowired
    private ResourceLoader resourceLoader;

    public static void main(String[] args)
    {
        SpringApplication.run(WeatherApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(WeatherRepository repository)
    {
        return (args) -> {
            try
            {
                final Resource fileResource = resourceLoader.getResource("classpath:weatherData.json");
                ObjectMapper objectMapper = new ObjectMapper();
                List<Weather> weatherArray = Arrays
                        .asList(objectMapper.readValue(fileResource.getFile(), Weather[].class));

                for (Weather weather : weatherArray)
                {
                    repository.save(weather);
                } 
                logger.info("*********************************");
                logger.info("***********Initial Data**********");
                logger.info("*********************************");
                for (Weather city : repository.findAll())
                {
                    logger.info(city.toString());
                }
                
                Weather weather = repository.findById(2643745);
                logger.info("found weather:"+weather);
                logger.info("*********************************");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        };
    }

}
