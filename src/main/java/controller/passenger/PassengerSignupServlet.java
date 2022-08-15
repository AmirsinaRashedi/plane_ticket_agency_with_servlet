package controller.passenger;

import util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PassengerSignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newUsername = req.getParameter("username");

        String newPassword = req.getParameter("password");

        String newFirstname = req.getParameter("firstname");

        String newLastname = req.getParameter("lastname");

        if (ApplicationContext.getPassengerService().createPassenger(newUsername, newPassword, newFirstname, newLastname)) {

            resp.setContentType("text/html");

            try {

                PrintWriter out = resp.getWriter();

                out.println("<h2>you can now login Using the given values</h2>");

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

            resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded");


        } else

            resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/signup");


    }


}
