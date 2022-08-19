package controller.passenger.dashboard;

import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PassengerDashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println("<h3> " + SecurityContext.getPassenger() + "  </h3> </br>");

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger/filter_flights_form\"> <button>filter flights with destination and origin</button></a>");

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger/sort_flights_form\"> <button>Sort flights</button></a>");

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger/buy_ticket_form\"> <button>buy ticket</button></a>");

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger/view_tickets\"> <button>view bought tickets</button></a>");

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded\"> <button>logout</button></a>");


            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }
}
