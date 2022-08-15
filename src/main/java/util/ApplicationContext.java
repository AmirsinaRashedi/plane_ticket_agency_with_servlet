package util;

import repository.Impl.AirlineRepositoryImpl;
import repository.Impl.FlightRepositoryImpl;
import repository.Impl.PassengerRepositoryImpl;
import repository.Impl.TicketRepositoryImpl;
import service.AirlineService;
import service.FlightService;
import service.PassengerService;
import service.TicketService;
import service.impl.AirlineServiceImpl;
import service.impl.FlightServiceImpl;
import service.impl.PassengerServiceImpl;
import service.impl.TicketServiceImpl;

public class ApplicationContext {

    private static AirlineService airlineService;

    private static FlightService flightService;

    private static PassengerService passengerService;

    private static TicketService ticketService;

    private ApplicationContext() {

    }

    public static AirlineService getAirlineService() {

        if (airlineService == null)
            airlineService = new AirlineServiceImpl(new AirlineRepositoryImpl());

        return airlineService;

    }

    public static FlightService getFlightService() {

        if (flightService == null)
            flightService = new FlightServiceImpl(new FlightRepositoryImpl());

        return flightService;

    }

    public static PassengerService getPassengerService() {

        if (passengerService == null)
            passengerService = new PassengerServiceImpl(new PassengerRepositoryImpl());

        return passengerService;

    }

    public static TicketService getTicketService() {

        if (ticketService == null)
            ticketService = new TicketServiceImpl(new TicketRepositoryImpl());

        return ticketService;

    }

}
