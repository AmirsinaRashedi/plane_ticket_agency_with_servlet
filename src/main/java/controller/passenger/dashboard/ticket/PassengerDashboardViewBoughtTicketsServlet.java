package controller.passenger.dashboard.ticket;

import domain.Ticket;
import util.ApplicationContext;
import util.SecurityContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PassengerDashboardViewBoughtTicketsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        List<Ticket> boughtTickets = ApplicationContext.getTicketService().getByPassenger(SecurityContext.getPassenger());

        if (boughtTickets == null || boughtTickets.size() == 0) {

            try {

                resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/no_result");

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        try {

            PrintWriter out = resp.getWriter();

            boughtTickets.forEach(f -> out.println("<p>" + f + "</p>"));

            out.println("<a href=\"http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/dashboard/passenger\"> <button>return</button></a>");

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }
}
