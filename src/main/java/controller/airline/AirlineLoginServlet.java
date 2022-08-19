package controller.airline;

import domain.Airline;
import util.ApplicationContext;
import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AirlineLoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String airlineName = req.getParameter("name");
        String airlinePassword = req.getParameter("password");

        Airline chosenAirline = ApplicationContext.getAirlineService().findByName(airlineName);

        if (chosenAirline != null && chosenAirline.getPassword().equals(airlinePassword)) {

            SecurityContext.logout();

            SecurityContext.setAirline(chosenAirline);

            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/airline");

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
