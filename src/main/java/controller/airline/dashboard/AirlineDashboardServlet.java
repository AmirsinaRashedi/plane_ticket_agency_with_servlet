package controller.airline.dashboard;

import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlineDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println("<h3> " + SecurityContext.getAirline() + "  </h3> </br>");

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/airline/add_flight_form\"> <button>add flight</button></a>");

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded\"> <button>logout</button></a>");

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }

}
