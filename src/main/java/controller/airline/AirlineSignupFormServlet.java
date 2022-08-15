package controller.airline;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AirlineSignupFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String signupForm = "<form name=\"signupForm\" method=\"post\" action=\"airline\">\n" +
                "    Name: <input type=\"text\" name=\"name\"/> <br/>\n" +
                "    Password: <input type=\"password\" name=\"password\"/> <br/>\n" +
                "    <input type=\"submit\" value=\"Signup\" />\n" +
                "</form>";

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println(signupForm);

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
