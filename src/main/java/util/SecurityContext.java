package util;

import domain.Airline;
import domain.Passenger;

public class SecurityContext {

    private static Airline airline;

    private static Passenger passenger;

    private SecurityContext() {
    }

    public static Airline getAirline() {

        return airline;

    }

    public static void setAirline(Airline airline) {

        SecurityContext.airline = airline;

    }

    public static Passenger getPassenger() {

        return passenger;

    }

    public static void setPassenger(Passenger passenger) {

        SecurityContext.passenger = passenger;

    }

    public static void logout() {

        airline = null;

        passenger = null;

    }

}
