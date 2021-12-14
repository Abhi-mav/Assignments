package com.restapi.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;



@RestController
public class WeatherController {

    @RequestMapping(method = RequestMethod.GET, value = "/weather")
    public @ResponseBody Object getWeatherByCity(@RequestParam String city) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," +
                                "&APPID=80730ceb55c51bebae397cfc46e03344"+"&units=metric",
                        Object.class);

        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/weather/forecast")
    public @ResponseBody Object getForecastByCity(@RequestParam String city) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/forecast?q=" + city + "," +
                                "&APPID=" + Configurations.API_KEY,
                        Object.class);

        return response;
    }

}
