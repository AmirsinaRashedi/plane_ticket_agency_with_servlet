package service.impl;

import base.service.impl.BaseServiceImpl;
import domain.Airline;
import repository.AirlineRepository;
import service.AirlineService;

import java.util.Scanner;

public class AirlineServiceImpl extends BaseServiceImpl<Airline, Long, AirlineRepository>
        implements AirlineService {

    public AirlineServiceImpl(AirlineRepository repository) {
        super(repository);
    }

    @Override
    public Airline findByName(String name) {

        if (name != null && !name.isBlank()) {

            try {

                return repository.findByName(name);

            } catch (Exception e) {

                return null;

            }


        } else
            return null;


    }

    @Override
    public boolean createAirline() {

        Scanner stringInput = new Scanner(System.in);

        System.out.print("enter new airline name: ");

        String newName = stringInput.nextLine();

        if (findByName(newName) == null) {

            try {

                Airline newAirline = new Airline();

                newAirline.setName(newName);

                System.out.print("enter password: ");

                newAirline.setPassword(stringInput.nextLine());

                save(newAirline);

            } catch (Exception e) {

                System.out.println("new airline not created!");

                return false;

            }

            return true;

        } else {

            System.out.println("this name is taken!");

            return false;


        }

    }

}
