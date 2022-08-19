package controller.passenger.dashboard.ticket;

import util.ApplicationContext;
import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PassengerDashboardBuyTicketServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        Long flightId = Long.parseLong(req.getParameter("flight"));

        if (ApplicationContext.getTicketService().buyTicket(SecurityContext.getPassenger(), ApplicationContext.getFlightService().findById(flightId))) {

            resp.setContentType("text/html");

            try {

                PrintWriter out = resp.getWriter();

                out.println("<h2>your ticket is now reserved</h2>");

                out.println("</a>\n" +
                        "<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger\">\n" +
                        "    <button>return</button>\n" +
                        "</a>");

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }


        } else {

            try {

                PrintWriter out = resp.getWriter();

                out.println("<h2>transaction not complete</h2>");

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
