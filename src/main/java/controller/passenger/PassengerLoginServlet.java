package controller.passenger;

import domain.Passenger;
import util.ApplicationContext;
import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PassengerLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Passenger chosenPassenger = ApplicationContext.getPassengerService().findByUsername(username);

        if (chosenPassenger != null && chosenPassenger.getPassword().equals(password)) {

            SecurityContext.logout();

            SecurityContext.setPassenger(chosenPassenger);

            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger");

            } catch (IOException e) {

                e.printStackTrace();

            }

        } else {

            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/login");

            } catch (IOException e) {

                e.printStackTrace();

            }

        }


    }

}
