package controller.passenger.dashboard.sort_flight;

import domain.Flight;
import util.ApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PassengerDashboardSortFlightsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String criteria = req.getParameter("criteria");

        String order = req.getParameter("order");

        List<Flight> sortedList = null;

        switch (criteria) {
            case "origin":
                sortedList = ApplicationContext.getFlightService().groupAllByOrigin(order);
                break;
            case "destination":
                sortedList = ApplicationContext.getFlightService().groupAllByDestination(order);
                break;
            case "airline":
                sortedList = ApplicationContext.getFlightService().groupAllByAirline(order);
                break;
            case "price":
                sortedList = ApplicationContext.getFlightService().groupAllByPrice(order);
                break;
        }

        if (sortedList != null) {

            try {

                PrintWriter out = resp.getWriter();

                sortedList.forEach(f -> out.println("<p>" + f + "</p>"));

                out.println("</br> <a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger\"> <button>return</button></a>");

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        } else {
            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/no_result");

            } catch (IOException e) {

                e.printStackTrace();

            }

        }


    }

}
