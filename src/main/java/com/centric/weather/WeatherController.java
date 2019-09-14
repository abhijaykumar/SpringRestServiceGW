package com.centric.weather;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    private final WeatherRepository repository;

    WeatherController(WeatherRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/weather")
    Weather weather(@RequestBody WeatherSearchCriteria searchCriteria) {
        Weather weatherResp = new Weather();
        boolean zipFound = false;
        if (searchCriteria.getZipCode() == null || searchCriteria.getZipCode().equals("")) {
            weatherResp.setStatusCode(520);
            weatherResp.setMessage("BAD REQUEST");
        } else {
            List<Weather> weatherList = repository.findAll();
            for (Weather weather : weatherList) {
                if (weather.getZipCode().equals(searchCriteria.getZipCode())) {
                    weatherResp = setWeatherHeadline(weather);
                    zipFound = true;
                    break;
                }
            }
            if (!zipFound) {
                weatherResp.setStatusCode(404);
                weatherResp.setMessage("Zip code weather data not found.");
            } else {
                weatherResp.setStatusCode(200);
                weatherResp.setMessage("SUCCESS");
            }
        }
        return weatherResp;
    }

    private Weather setWeatherHeadline(Weather weather) {
        String headline;
        float maxTemp = Float.parseFloat(weather.getTemperatureMax());
        if (maxTemp < 65) {
            headline = "Cold";
        } else if (maxTemp > 90) {
            headline = "Warm";
        } else {
            headline = "Moderate";
        }

        if (Float.parseFloat(weather.getRainfall()) > 0.2) {
            headline += ", Rainy";
        }

        if (Float.parseFloat(weather.getAvgWindSpeed()) > 10) {
            headline += ", Windy";
        }

        weather.setHeadline(headline);

        return weather;
    }
}
