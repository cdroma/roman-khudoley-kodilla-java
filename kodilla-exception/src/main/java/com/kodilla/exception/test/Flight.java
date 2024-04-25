package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }
}

class FlightFinder {
    private Map<String, Boolean> availableAirports;

    public FlightFinder() {
        availableAirports = new HashMap<>();
        availableAirports.put("Dublin", true);
        availableAirports.put("Barcelona", true);
        availableAirports.put("Krakow", false);
        availableAirports.put("London", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {
        String departureAirport = flight.getDepartureAirport();
        String arrivalAirport = flight.getArrivalAirport();

        if (!availableAirports.containsKey(departureAirport) || !availableAirports.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("One or both airports not found");
        }

        if (!availableAirports.get(departureAirport) || !availableAirports.get(arrivalAirport)) {
            throw new RouteNotFoundException("No available flights for one or both airports");
        }

        System.out.println("Flight from " + departureAirport + " to " + arrivalAirport + " found.");
    }
}

class RouteNotFoundException extends Exception {
    public RouteNotFoundException(String message) {
        super(message);
    }
}

class Application {
    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Dublin", "Krakow");
        Flight flight2 = new Flight("Barcelona", "London");

        try {
            flightFinder.findFlight(flight1);
            flightFinder.findFlight(flight2);
        } catch (RouteNotFoundException exception) {
            System.out.println("Exception caught: " + exception.getMessage());
        }
    }
}
