import domain.Airline;
import domain.Flight;
import domain.Passenger;
import domain.Ticket;
import util.ApplicationContext;
import util.Menu;
import util.SecurityContext;

import java.util.List;
import java.util.Scanner;

public class AgencyApplication {

    public static void main(String[] args) {

        runMain();


    }

    private static void runMain() {

        Scanner intInput = new Scanner(System.in);

        Scanner stringInput = new Scanner(System.in);


        while (true) {

            try {

                Menu.loginMenu();

                int choice = intInput.nextInt();

                switch (choice) {

                    case 1: {

                        System.out.print("enter airline name: ");

                        String airlineName = stringInput.nextLine();

                        Airline chosenAirline = ApplicationContext.getAirlineService().findByName(airlineName);

                        System.out.print("enter password: ");

                        String airlinePassword = stringInput.nextLine();

                        if (chosenAirline != null && chosenAirline.getPassword().equals(airlinePassword)) {

                            SecurityContext.logout();

                            SecurityContext.setAirline(chosenAirline);

                            runAirlinePanel();

                        } else
                            System.out.println("name or password is incorrect");

                        break;
                    }

                    case 2: {

                        if (ApplicationContext.getAirlineService().createAirline())
                            System.out.println("new airline created you can now log in with the account information");

                        break;

                    }

                    case 3: {

                        System.out.print("Enter username: ");

                        String username = stringInput.nextLine();

                        Passenger chosenPassenger = ApplicationContext.getPassengerService().findByUsername(username);

                        System.out.println("Enter password: ");

                        String password = stringInput.nextLine();

                        if (chosenPassenger != null && chosenPassenger.getPassword().equals(password)) {

                            SecurityContext.logout();

                            SecurityContext.setPassenger(chosenPassenger);

                            runPassengerPanel();

                        } else
                            System.out.println("username or password is incorrect");

                        break;

                    }

                    case 4: {

                        if (ApplicationContext.getPassengerService().createPassenger())
                            System.out.println("new passenger created you can now log in with the account information");

                        break;

                    }

                    default:
                        return;

                }

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

    }

    private static void runPassengerPanel() {

        Scanner intInput = new Scanner(System.in);

        Scanner stringInput = new Scanner(System.in);

        try {

            while (true) {

                Menu.passengerPanel();

                int choice = intInput.nextInt();

                switch (choice) {

                    case 1: {

                        String origin, destination;

                        System.out.print("enter Origin: ");

                        origin = stringInput.nextLine();

                        System.out.print("enter Destination: ");

                        destination = stringInput.nextLine();

                        List<Flight> withOriginAndDestination = ApplicationContext.getFlightService().findWithOriginAndDestination(origin, destination);

                        if (!withOriginAndDestination.isEmpty())
                            withOriginAndDestination.forEach(System.out::println);
                        else
                            System.out.println("no flight with this specification exists");

                        break;

                    }

                    case 2: {

                        Menu.flightSortOptions();

                        int groupByChoice = intInput.nextInt();

                        switch (groupByChoice) {

                            case 1: {

                                List<Flight> flights = ApplicationContext.getFlightService().groupAllByOrigin(sortOrder());

                                if (!flights.isEmpty())
                                    flights.forEach(System.out::println);

                                break;

                            }

                            case 2: {

                                List<Flight> flights = ApplicationContext.getFlightService().groupAllByDestination(sortOrder());

                                if (!flights.isEmpty())
                                    flights.forEach(System.out::println);

                                break;

                            }

                            case 3: {

                                List<Flight> flights = ApplicationContext.getFlightService().groupAllByAirline(sortOrder());

                                if (!flights.isEmpty())
                                    flights.forEach(System.out::println);

                                break;

                            }

                            case 4: {

                                List<Flight> flights = ApplicationContext.getFlightService().groupAllByPrice(sortOrder());

                                if (!flights.isEmpty())
                                    flights.forEach(System.out::println);

                                break;

                            }

                            default:
                                break;

                        }

                        break;

                    }

                    case 3: {

                        ApplicationContext.getTicketService().buyTicket(SecurityContext.getPassenger());

                        break;

                    }

                    case 4: {

                        List<Ticket> byPassenger = ApplicationContext.getTicketService().getByPassenger(SecurityContext.getPassenger());

                        if (!byPassenger.isEmpty())
                            byPassenger.forEach(System.out::println);
                        else
                            System.out.println("you have not purchased any tickets");


                    }

                    default:
                        return;

                }


            }


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private static String sortOrder() {

        Scanner intInput = new Scanner(System.in);

        Menu.sortOrder();

        int choice = intInput.nextInt();

        if (choice == 2)
            return "DESC";
        else
            return "ASC";


    }

    private static void runAirlinePanel() {

        Scanner intInput = new Scanner(System.in);

        Scanner stringInput = new Scanner(System.in);

        try {

            while (true) {

                Menu.airlinePanel();

                int choice = intInput.nextInt();

                switch (choice) {

                    case 1: {

                        if (ApplicationContext.getFlightService().createFlight(SecurityContext.getAirline()))
                            System.out.println("new flight created!");

                        break;

                    }

                    default:
                        return;

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}
