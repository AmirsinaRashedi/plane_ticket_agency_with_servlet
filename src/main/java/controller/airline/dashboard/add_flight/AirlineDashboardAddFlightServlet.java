package controller.airline.dashboard.add_flight;

import util.ApplicationContext;
import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlineDashboardAddFlightServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String origin = req.getParameter("origin");

        String destination = req.getParameter("destination");

        Integer price = Integer.parseInt(req.getParameter("price"));

        Integer availableSeats = Integer.parseInt(req.getParameter("available seats"));

        if (ApplicationContext.getFlightService().createFlight(SecurityContext.getAirline(), origin, destination, price, availableSeats)) {

            resp.setContentType("text/html");

            try {

                PrintWriter out = resp.getWriter();

                out.println("<h2>flight created</h2>");

                out.println("</a>\n" +
                        "<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/airline\">\n" +
                        "    <button>return</button>\n" +
                        "</a>");

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }


        } else {

            resp.setContentType("text/html");

            try {

                PrintWriter out = resp.getWriter();

                out.println("<h2>unable to create flight</h2>");

                out.println("</a>\n" +
                        "<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger\">\n" +
                        "    <button>return</button>\n" +
                        "</a>");

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }


        }


    }

}
