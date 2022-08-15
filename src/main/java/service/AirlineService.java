package service;

import base.service.BaseService;
import domain.Airline;

public interface AirlineService extends BaseService<Airline, Long> {

    Airline findByName(String name);

    boolean createAirline();

}
