package com.weather.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Weather
{
    @Id
    private Long id;
    private String name;
    private String temp;
    private String pressure;
    private String humidity;
    @JsonProperty("temp_min")
    private String tempMin;
    @JsonProperty("temp_max")
    private String tempMax;
    @JsonProperty("wind_speed")
    private String windSpeed;
    private String icon;
    
    public Weather(Long  id,String name, String temp, String pressure, String humidity, String tempMin, String tempMax,
            String windSpeed, String icon)
    {
        this.id = id;
        this.name = name;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.windSpeed = windSpeed;
        this.icon = icon;
    }

    protected Weather() {}

    
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getTemp()
    {
        return temp;
    }
    public void setTemp(String temp)
    {
        this.temp = temp;
    }
    
    public String getPressure()
    {
        return pressure;
    }
    public void setPressure(String pressure)
    {
        this.pressure = pressure;
    }
    
    public String getHumidity()
    {
        return humidity;
    }
    public void setHumidity(String humidity)
    {
        this.humidity = humidity;
    }
    
    public String getTempMin()
    {
        return tempMin;
    }
    public void setTempMin(String tempMin)
    {
        this.tempMin = tempMin;
    }
    
    public String getTempMax()
    {
        return tempMax;
    }
    public void setTempMax(String tempMax)
    {
        this.tempMax = tempMax;
    }
    
    public String getWindSpeed()
    {
        return windSpeed;
    }
    public void setWindSpeed(String windSpeed)
    {
        this.windSpeed = windSpeed;
    }
    
    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Weather [id=").append(id).append(", name=").append(name).append(", temp=").append(temp)
                .append(", pressure=").append(pressure).append(", humidity=").append(humidity).append(", tempMin=")
                .append(tempMin).append(", tempMax=").append(tempMax).append(", windSpeed=").append(windSpeed)
                .append(", icon=").append(icon).append("]");
        return builder.toString();
    }
}
