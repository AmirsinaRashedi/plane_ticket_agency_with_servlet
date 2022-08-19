package service;

import base.service.BaseService;
import domain.Airline;
import domain.Flight;

import java.util.List;

public interface FlightService extends BaseService<Flight, Long> {

    List<Flight> findWithOriginAndDestination(String origin, String destination);

    List<Flight> groupAllByOrigin(String order);

    List<Flight> groupAllByDestination(String order);

    List<Flight> groupAllByAirline(String order);

    List<Flight> groupAllByPrice(String order);

    Boolean createFlight(Airline airline);

    Boolean createFlight(Airline airline, String origin, String destination, Integer price, Integer availableSeats);

    List<String> getAllOrigins();

    List<String> getAllDestinations();


}
