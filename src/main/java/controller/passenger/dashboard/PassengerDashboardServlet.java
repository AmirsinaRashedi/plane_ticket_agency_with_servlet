package controller.passenger.dashboard;

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

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger/sort_flights_form\"> <button>Sort flights</button></a>");

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }
}
