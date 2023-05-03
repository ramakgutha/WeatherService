package com.weather;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weather.service.Bean1;
import com.weather.service.Bean2;
import com.weather.service.Bean3;

@Configuration
public class WeatherConfig
{
    @Bean
    public Bean2 dogSchool() {
        return new Bean2();
    }

    @Bean
    public Bean1 catSchool() {
        return new Bean1();
    }

    @Bean
    @ConditionalOnBean({ Bean1.class, Bean2.class})
    public Bean3 vetSchool() {
        return new Bean3();
    }
}
