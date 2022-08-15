package controller.passenger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PassengerLoginFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String loginForm = "<form name=\"loginForm\" method=\"post\" action=\"passenger\">\n" +
                "    Username: <input type=\"text\" name=\"username\"/> <br/>\n" +
                "    Password: <input type=\"password\" name=\"password\"/> <br/>\n" +
                "    <input type=\"submit\" value=\"Login\" />\n" +
                "</form>";

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println(loginForm);

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
