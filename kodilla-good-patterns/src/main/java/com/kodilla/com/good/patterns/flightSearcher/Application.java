package com.kodilla.com.good.patterns.flightSearcher;

public class Application {
    public static void main(String[] args) {
        FlightService flightService = new FlightService();

        flightService.addFlight(new Flight("GDANSK", "WROCLAW"));
        flightService.addFlight(new Flight("GDANSK", "KRAKOW"));
        flightService.addFlight(new Flight("KRAKOW", "WROCLAW"));
        flightService.addFlight(new Flight("WARSZAWA", "GDANSK"));

        System.out.println("Flights from GDANSK:");
        flightService.findFlightsFromCity("GDANSK").forEach(System.out::println);

        System.out.println("\nFlights to WROCLAW:");
        flightService.findFlightsToCity("WROCLAW").forEach(System.out::println);

        System.out.println("\nConnecting flights from GDANSK to WROCLAW through KRAKOW:");
        flightService.findConnectingFlights("GDANSK", "KRAKOW", "WROCLAW").forEach(System.out::println);
    }
}
