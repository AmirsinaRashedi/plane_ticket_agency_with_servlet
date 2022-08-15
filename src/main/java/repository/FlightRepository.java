package repository;

import base.repository.BaseRepository;
import domain.Flight;

import java.util.List;

public interface FlightRepository extends BaseRepository<Flight, Long> {

    List<Flight> findWithOriginAndDestination(String origin, String destination);

    List<Flight> groupAllByOrigin(String order);

    List<Flight> groupAllByDestination(String order);

    List<Flight> groupAllByAirline(String order);

    List<Flight> groupAllByPrice(String order);

}
