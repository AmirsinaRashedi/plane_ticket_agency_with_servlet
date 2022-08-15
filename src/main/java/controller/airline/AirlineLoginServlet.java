package controller.airline;

import domain.Airline;
import util.ApplicationContext;
import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlineLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String loginForm = "<form name=\"loginForm\" method=\"post\" action=\"airline\">\n" +
                "    Name: <input type=\"text\" name=\"name\"/> <br/>\n" +
                "    Password: <input type=\"password\" name=\"password\"/> <br/>\n" +
                "    <input type=\"submit\" value=\"Login\" />\n" +
                "</form>";

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println(loginForm);

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


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
