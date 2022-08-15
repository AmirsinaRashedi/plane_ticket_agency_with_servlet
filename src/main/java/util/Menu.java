package util;

public class Menu {


    public static void gap() {

        System.out.println();
        System.out.println();
        System.out.println();


    }


    public static void loginMenu() {

        gap();
        System.out.println("1- login as an airline");
        System.out.println("2- create a new airline");
        System.out.println("3- login as a passenger");
        System.out.println("4- create a new passenger");
        System.out.println("enter any other key to exit");
        System.out.print("choose: ");

    }


    public static void airlinePanel() {

        gap();
        System.out.println("logged in as:");
        System.out.println(SecurityContext.getAirline());
        System.out.println();
        System.out.println("options:");
        System.out.println("1- add flight");
        System.out.println("enter any other key to exit");
        System.out.print("choose: ");
    }

    public static void passengerPanel() {

        gap();
        System.out.println("logged in as:");
        System.out.println(SecurityContext.getPassenger());
        System.out.println();
        System.out.println("options:");
        System.out.println("1- filter using origin and destination");
        System.out.println("2- sort all flights");
        System.out.println("3- buy a ticket");
        System.out.println("4- view bought tickets");
        System.out.println("enter any other key to exit");
        System.out.print("choose: ");

    }


    public static void flightSortOptions() {

        gap();
        System.out.println("1- by Origin");
        System.out.println("2- by Destination");
        System.out.println("3- by Airline");
        System.out.println("4- by Price");
        System.out.print("choose: ");

    }

    public static void sortOrder() {

        System.out.println();
        System.out.println("1- ascending");
        System.out.println("2- descending");
        System.out.println("choose: ");


    }

}
