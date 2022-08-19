package controller.passenger.dashboard.ticket;

import domain.Flight;
import util.ApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PassengerDashboardBuyTicketFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        List<String> origins = ApplicationContext.getFlightService().getAllOrigins();

        List<String> destinations = ApplicationContext.getFlightService().getAllDestinations();

        if (origins == null || destinations == null) {

            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/no_result");

            } catch (IOException e) {

                e.printStackTrace();

            }

        }


        StringBuilder filterForm = new StringBuilder();

        filterForm.append("<form name=\"filterForm\" method=\"post\" action=\"buy_ticket_form\">\n");
        filterForm.append("<select name=\"origin\">\n");

        for (String origin : origins) {

            filterForm.append("    <option value=").append(origin).append(">").append(origin).append("</option>\n");

        }

        filterForm.append("</select>\n");

        filterForm.append("<select name=\"destination\">\n");

        for (String destination : destinations) {

            filterForm.append("    <option value=").append(destination).append(">").append(destination).append("</option>\n");

        }

        filterForm.append("</select>\n");

        filterForm.append("    <input type=\"submit\" value=\"search\" />\n");

        filterForm.append("</form>");

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println(filterForm);

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String origin = req.getParameter("origin");

        String destination = req.getParameter("destination");

        List<Flight> availableFlights = ApplicationContext.getFlightService().findWithOriginAndDestination(origin, destination);

        if (availableFlights == null || availableFlights.size() == 0) {

            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/no_result");

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        StringBuilder flightForm = new StringBuilder();

        flightForm.append("<form name=\"flightForm\" method=\"post\" action=\"buy_ticket\">\n");

        flightForm.append("    Flight: ");

        for (Flight f : availableFlights) {

            flightForm.append("<input type=\"radio\" name=\"flight\" value=\"").append(f.getId()).append("\" />").append(f).append("</br>\n");

        }

        flightForm.append("    <input type=\"submit\" value=\"search\" />\n");

        flightForm.append("</form>");

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println(flightForm);

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }


}
