package repository;

import base.repository.BaseRepository;
import domain.Airline;

public interface AirlineRepository extends BaseRepository<Airline, Long> {

    Airline findByName(String name);


}
