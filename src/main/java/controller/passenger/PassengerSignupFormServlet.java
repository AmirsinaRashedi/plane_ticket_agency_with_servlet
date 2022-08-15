package controller.passenger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class PassengerSignupFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String signupForm = "<form name=\"signupForm\" method=\"post\" action=\"passenger\">\n" +
                "    Username: <input type=\"text\" name=\"username\"/> <br/>\n" +
                "    Password: <input type=\"password\" name=\"password\"/> <br/>\n" +
                "    Firstname: <input type=\"text\" name=\"firstname\"/> <br/>\n" +
                "    Lastname: <input type=\"text\" name=\"lastname\"/> <br/>\n" +
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
