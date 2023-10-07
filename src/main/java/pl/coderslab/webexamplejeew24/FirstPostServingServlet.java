package pl.coderslab.webexamplejeew24;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FirstPostServingServlet", urlPatterns = "/handlePost")
public class FirstPostServingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        resp.getWriter().println("hello from post. good to see you, " + firstName + " " + lastName + "! :)");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("" +
                "<html lang=\"en\">\n" +
                "<body>\n" +
                "    <form method=\"post\">\n" +
                "        <input type=\"text\" name=\"firstName\">\n" +
                "        <input type=\"submit\">\n" +
                "    </form>\n" +
                "</body>\n" +
                "</html>");
    }
}
