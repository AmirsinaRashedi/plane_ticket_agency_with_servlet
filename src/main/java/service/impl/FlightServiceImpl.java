package service.impl;

import base.service.impl.BaseServiceImpl;
import domain.Airline;
import domain.Flight;
import repository.FlightRepository;
import service.FlightService;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlightServiceImpl extends BaseServiceImpl<Flight, Long, FlightRepository>
        implements FlightService {


    public FlightServiceImpl(FlightRepository repository) {
        super(repository);
    }

    @Override
    public List<Flight> findWithOriginAndDestination(String origin, String destination) {

        if (origin != null && destination != null && !origin.isBlank() && !destination.isBlank()) {

            try {

                return repository.findWithOriginAndDestination(origin, destination);

            } catch (Exception e) {

                return null;

            }

        } else
            return null;

    }

    @Override
    public List<Flight> groupAllByOrigin(String order) {

        if (order != null && (order.equals("ASC") || order.equals("DESC"))) {

            try {

                return repository.groupAllByOrigin(order);

            } catch (Exception e) {

                return null;

            }

        } else
            return null;

    }

    @Override
    public List<Flight> groupAllByDestination(String order) {

        if (order != null && (order.equals("ASC") || order.equals("DESC"))) {

            try {

                return repository.groupAllByDestination(order);

            } catch (Exception e) {

                return null;

            }

        } else
            return null;

    }

    @Override
    public List<Flight> groupAllByAirline(String order) {

        if (order != null && (order.equals("ASC") || order.equals("DESC"))) {

            try {

                return repository.groupAllByAirline(order);

            } catch (Exception e) {

                return null;

            }

        } else
            return null;

    }

    @Override
    public List<Flight> groupAllByPrice(String order) {

        if (order != null && (order.equals("ASC") || order.equals("DESC"))) {

            try {

                return repository.groupAllByPrice(order);

            } catch (Exception e) {

                return null;

            }

        } else
            return null;

    }

    @Override
    public Boolean createFlight(Airline airline) {

        Flight newFlight = new Flight();

        newFlight.setAirline(airline);

        Scanner stringInput = new Scanner(System.in);

        Scanner intInput = new Scanner(System.in);

        try {


            System.out.print("enter origin: ");

            newFlight.setOrigin(stringInput.nextLine());

            System.out.print("enter destination: ");

            newFlight.setDestination(stringInput.nextLine());

            System.out.print("enter price: ");

            newFlight.setPrice(intInput.nextInt());

            System.out.print("enter number of available seats: ");

            newFlight.setAvailableSeats(intInput.nextInt());

            save(newFlight);

            return true;

        } catch (Exception e) {

            System.out.println("new flight not created!");

            return false;

        }


    }

    @Override
    public Boolean createFlight(Airline airline, String origin, String destination, Integer price, Integer availableSeats) {

        Flight newFlight = new Flight();

        newFlight.setAirline(airline);

        try {

            newFlight.setOrigin(origin);

            newFlight.setDestination(destination);

            newFlight.setPrice(price);

            newFlight.setAvailableSeats(availableSeats);

            if (save(newFlight) != null)
                return true;
            else
                return false;

        } catch (Exception e) {

            System.out.println("new flight not created!");

            return false;

        }

    }

    @Override
    public List<String> getAllOrigins() {

        List<String> originsWithDuplicates;

        try {

            originsWithDuplicates = repository.getAllOrigins();

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }


        return originsWithDuplicates.stream().distinct().collect(Collectors.toList());

    }

    @Override
    public List<String> getAllDestinations() {

        List<String> destinationsWithDuplicates;

        try {

            destinationsWithDuplicates = repository.getAllDestinations();

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

        return destinationsWithDuplicates.stream().distinct().collect(Collectors.toList());

    }

}
