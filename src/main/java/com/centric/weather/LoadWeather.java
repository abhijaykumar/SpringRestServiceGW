package com.centric.weather;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.util.List;

@Configuration
@Slf4j
class LoadWeather {
    private static Logger log = LoggerFactory.getLogger(LoadWeather.class);

    @Bean
    CommandLineRunner initWeather(WeatherRepository repository) {
        return args -> {
            try {
                // Create an object of file reader
                // class with CSV file as a parameter.
                FileReader filereader = new FileReader("C:\\Users\\abhijay.kumar\\Desktop\\weather.csv");

                // create csvReader object and skip first Line
                CSVReader csvReader = new CSVReaderBuilder(filereader)
                        .withSkipLines(1)
                        .build();
                List<String[]> allData = csvReader.readAll();

                // print Data
                for (String[] row : allData) {
                    Weather weatherObj =  new Weather(row[0], row[1],
                            row[2], row[3], row[4]);

                    log.info("Preloading " + repository.save(weatherObj));
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
