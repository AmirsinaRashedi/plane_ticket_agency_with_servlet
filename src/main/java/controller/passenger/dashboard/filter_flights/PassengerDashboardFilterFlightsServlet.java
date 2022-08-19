package controller.passenger.dashboard.filter_flights;

import domain.Flight;
import util.ApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PassengerDashboardFilterFlightsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String origin = req.getParameter("origin");

        String destination = req.getParameter("destination");

        List<Flight> filteredFlights = ApplicationContext.getFlightService().findWithOriginAndDestination(origin, destination);

        if (filteredFlights == null || filteredFlights.size() == 0) {

            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/no_result");

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        try {

            PrintWriter out = resp.getWriter();

            filteredFlights.forEach(f -> out.println("<p>" + f + "</p>"));

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger\"> <button>return</button></a>");

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }


}
