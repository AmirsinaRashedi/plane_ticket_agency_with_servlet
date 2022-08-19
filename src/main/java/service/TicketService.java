package service;

import base.service.BaseService;
import domain.Flight;
import domain.Passenger;
import domain.Ticket;

import java.util.List;

public interface TicketService extends BaseService<Ticket, Long> {

    List<Ticket> getByPassenger(Passenger passenger);

    boolean buyTicket(Passenger passenger);

    boolean buyTicket(Passenger passenger, Flight flight);

}
