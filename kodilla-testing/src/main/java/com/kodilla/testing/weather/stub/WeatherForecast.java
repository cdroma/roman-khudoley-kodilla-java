package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        Map<String, Double> temperatureMap = temperatures.getTemperatures();

        for (Map.Entry<String, Double> temperature : temperatureMap.entrySet()) {
            double newTemperature = temperature.getValue() + 1.0;
            resultMap.put(temperature.getKey(), newTemperature);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        Map<String, Double> temperatureMap = temperatures.getTemperatures();
        double sum = 0.0;

        for (double temperature : temperatureMap.values()) {
            sum += temperature;
        }
        return sum / temperatureMap.size();
    }

    public double calculateMedianTemperature() {
        Map<String, Double> temperatureMap = temperatures.getTemperatures();
        int size = temperatureMap.size();
        double[] temperatureArray = new double[size];
        int index = 0;

        for (double temperature : temperatureMap.values()) {
            temperatureArray[index++] = temperature;
        }

        if (size % 2 == 0) {
            int middleIndex = size / 2;
            return (temperatureArray[middleIndex] + temperatureArray[middleIndex - 1]) / 2;
        } else {
            return temperatureArray[size / 2];
        }
    }
}

