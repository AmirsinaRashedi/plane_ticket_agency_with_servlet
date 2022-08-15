package controller.airline;

import util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlineSignupServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String newName = req.getParameter("name");

        String newPassword = req.getParameter("password");

        if (ApplicationContext.getAirlineService().createAirline(newName, newPassword)) {

            resp.setContentType("text/html");

            try {

                PrintWriter out = resp.getWriter();

                out.println("<h2>you can now login Using the given values</h2>");

                out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

            try {

                Thread.sleep(3000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/");


        } else

            resp.sendRedirect("http://localhost:8081/plane_ticket_agency_with_servlet_war_exploded/failed/signup");


    }


}
