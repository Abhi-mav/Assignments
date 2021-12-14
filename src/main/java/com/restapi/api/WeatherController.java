package com.restapi.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
public class WeatherController {

    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    public @ResponseBody Object getWeatherByCity(@RequestParam String city) throws Exception {

        RestTemplate restTemplate = new RestTemplate();

        if (city.isEmpty())
            throw new NullPointerException("City Name can not be null");
        ResponseEntity<Object> response;

        try{
             response = restTemplate.
                    getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," +
                                    "&APPID=80730ceb55c51bebae397cfc46e03344"+"&units=metric",
                            Object.class);

            return response;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/weather/forecast")
    public @ResponseBody Object getForecastByCity(@RequestParam String city) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response;

        if (city.isEmpty())
            throw new NullPointerException("City Name can not be null");

        try{
            response = restTemplate.
                    getForEntity("https://api.openweathermap.org/data/2.5/forecast?q=" + city + "," +
                                    "&APPID=" + Configurations.API_KEY,
                            Object.class);
            return response;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
