package pl.coderslab.webexamplejeew24.session.zad4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Zadanie 2 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Session2 dostępny pod adresem /session2.
//
//W metodzie doGet wyświetl formularz z możliwością wpisania oceny.
//Po zatwierdzeniu formularza dodaj ocenę do sesji. Oceny trzymaj w liście, którą będziesz wkładać do sesji.
//Wylicz średnią z ocen (pamiętaj o właśnie dodanej ocenie).
//Wszystkie zapamiętane oceny i ich średnia powinny być wyświetlane po zatwierdzeniu formularza.

@WebServlet("/session4.html")
public class Session4FormServlet extends HttpServlet {
    private static String FORM_HTML_TEMPLATE = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Session4</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div>%s</div>\n" +
            "<div></div>\n" +
            "    <form method=\"post\" action=\"cart\" >\n" +
            "        <div>\n" +
            "            <label for=\"productName\">productName\n" +
            "                <input type=\"text\" name=\"productName\" id=\"productName\">\n" +
            "            </label>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <label for=\"quantity\">quantity\n" +
            "                <input type=\"number\" step=\"0.01\" name=\"quantity\" id=\"quantity\">\n" +
            "            </label>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <label for=\"price\">price\n" +
            "                <input type=\"number\" step=\"0.01\" name=\"price\" id=\"price\">\n" +
            "            </label>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <input type=\"submit\">\n" +
            "        </div>\n" +
            "    </form>\n" +
            "</body>\n" +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("msg");
        response.getWriter().println(String.format(FORM_HTML_TEMPLATE, msg));
    }
}
