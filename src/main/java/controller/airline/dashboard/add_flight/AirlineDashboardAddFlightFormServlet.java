package controller.airline.dashboard.add_flight;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlineDashboardAddFlightFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String createFlightForm = "<form name=\"createFlightForm\" method=\"post\" action=\"add_flight\">\n" +
                "    Origin: <input type=\"text\" name=\"origin\"/> <br/>\n" +
                "    Destination: <input type=\"text\" name=\"destination\"/> <br/>\n" +
                "    price: <input type=\"text\" name=\"price\"/> <br/>\n" +
                "    number of available seats: <input type=\"text\" name=\"available seats\"/> <br/>\n" +
                "    <input type=\"submit\" value=\"create\" />\n" +
                "</form>";

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println(createFlightForm);

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
