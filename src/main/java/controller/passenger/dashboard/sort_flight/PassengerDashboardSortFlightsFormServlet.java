package controller.passenger.dashboard.sort_flight;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PassengerDashboardSortFlightsFormServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String sortParams = "<form name=\"sortParamsForm\" method=\"post\" action=\"sort_flights\">\n" +
                "    SortCriteria: <input type=\"radio\" name=\"criteria\" value=\"origin\" />Origin\n" +
                "<input type=\"radio\" name=\"criteria\" value=\"destination\" />Destination\n" +
                "<input type=\"radio\" name=\"criteria\" value=\"airline\" />Airline\n" +
                "<input type=\"radio\" name=\"criteria\" value=\"price\" />Price <br/>\n" +
                "    SortOrder: <input type=\"radio\" name=\"order\" value=\"ASC\" />ASC\n" +
                "<input type=\"radio\" name=\"order\" value=\"DESC\" />DESC <br/>\n" +
                "    <input type=\"submit\" value=\"search\" />\n" +
                "</form>";

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println(sortParams);

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
