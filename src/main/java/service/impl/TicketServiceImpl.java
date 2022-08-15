package service.impl;

import base.service.impl.BaseServiceImpl;
import domain.Flight;
import domain.Passenger;
import domain.Ticket;
import repository.TicketRepository;
import service.TicketService;
import util.ApplicationContext;

import java.util.List;
import java.util.Scanner;

public class TicketServiceImpl extends BaseServiceImpl<Ticket, Long, TicketRepository>
        implements TicketService {

    public TicketServiceImpl(TicketRepository repository) {
        super(repository);
    }

    @Override
    public List<Ticket> getByPassenger(Passenger passenger) {

        if (passenger != null) {

            try {

                return repository.getByPassenger(passenger);

            } catch (Exception e) {

                return null;

            }

        } else
            return null;

    }

    @Override
    public boolean buyTicket(Passenger passenger) {

        Scanner stringInput = new Scanner(System.in);

        Scanner intInput = new Scanner(System.in);

        String origin, destination;

        System.out.print("enter Origin: ");

        origin = stringInput.nextLine();

        System.out.print("enter Destination: ");

        destination = stringInput.nextLine();

        List<Flight> withOriginAndDestination = ApplicationContext.getFlightService().findWithOriginAndDestination(origin, destination);

        int flightCount = 0;

        if (!withOriginAndDestination.isEmpty()) {

            for (Flight f : withOriginAndDestination)
                System.out.println(++flightCount + "- " + f.toString());

        } else {

            System.out.println("no flight with this specification exists");

            return false;

        }

        System.out.print("choose: ");

        int choice = intInput.nextInt();

        if (choice > 0 && choice <= flightCount) {

            Flight boughtFlight = withOriginAndDestination.get(choice - 1);

            Ticket newTicket = new Ticket();

            newTicket.setPassenger(passenger);

            newTicket.setFlight(boughtFlight);

            save(newTicket);

            boughtFlight.fillOneSeat();

            ApplicationContext.getFlightService().save(boughtFlight);

            return true;

        } else {

            System.out.println("wrong input!");

            return false;

        }

    }


}
