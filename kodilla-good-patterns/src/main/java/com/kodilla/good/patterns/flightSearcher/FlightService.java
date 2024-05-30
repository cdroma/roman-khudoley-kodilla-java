package com.kodilla.good.patterns.flightSearcher;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> findFlightsFromCity(String city) {
        return flights.stream()
                .filter(flight -> flight.getDepartureCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findFlightsToCity(String city) {
        return flights.stream()
                .filter(flight -> flight.getArrivalCity().equals(city))
                .collect(Collectors.toList());
    }

    public List<Flight> findConnectingFlights(String fromCity, String throughCity, String toCity) {
        List<Flight> toThroughCity = findFlightsFromCity(fromCity).stream()
                .filter(flight -> flight.getArrivalCity().equals(throughCity))
                .collect(Collectors.toList());

        List<Flight> fromThroughCity = findFlightsFromCity(throughCity).stream()
                .filter(flight -> flight.getArrivalCity().equals(toCity))
                .collect(Collectors.toList());

        List<Flight> connectingFlights = new ArrayList<>();
        for (Flight firstLeg : toThroughCity) {
            for (Flight secondLeg : fromThroughCity) {
                connectingFlights.add(firstLeg);
                connectingFlights.add(secondLeg);
            }
        }

        return connectingFlights;
    }
}
