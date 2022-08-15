package controller.message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FailedSignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        resp.setContentType("text/html");

        try {

            PrintWriter out = resp.getWriter();

            out.println("<h1>FAILED TO SIGNUP</h1>");

            out.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }

}
