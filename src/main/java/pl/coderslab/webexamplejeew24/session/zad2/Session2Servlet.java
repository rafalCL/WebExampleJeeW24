package pl.coderslab.webexamplejeew24.session.zad2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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

@WebServlet(name = "Session2Servlet", value = "/session2")
public class Session2Servlet extends HttpServlet {
    private static String FORM_HTML_TEMPLATE = "" +
            "<html lang=\"en\">\n" +
            "<body>\n" +
            "    <form method=\"post\">\n" +
            "        Grade: <input type=\"number\" name=\"grade\">\n" +
            "        <input type=\"submit\">\n" +
            "    </form>\n" +
            "    <div>grades=$ALL_GRADES</div>\n" +
            "    <div>avg=$AVG_VALUE</div>\n" +
            "</body>\n" +
            "</html>";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(FORM_HTML_TEMPLATE
                .replace("$ALL_GRADES", "[]")
                .replace("$AVG_VALUE", "undefined"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // retrieve all grades from session
        HttpSession session = request.getSession();
        List<Integer> allGrades = (List<Integer>) session.getAttribute("allGrades");
        if(allGrades == null) { // ... or create new list
            allGrades = new ArrayList<>();
        }

        // handle data send by user
        String gradeStr = request.getParameter("grade");
        try {
            int grade = Integer.valueOf(gradeStr); // convert
            allGrades.add(grade); // add to all grades
            session.setAttribute("allGrades", allGrades);
        } catch (NumberFormatException e) {
            System.out.println("log error on server: invalid data from client");
        }

        // try calculate avg
        int sum = 0;
        for (int grade : allGrades) {
            sum += grade;
        }

        // fill template to display form and calculated data to client
        String html = FORM_HTML_TEMPLATE.replace("$ALL_GRADES", allGrades.toString());
        if(sum == 0) {
            html = html.replace("$AVG_VALUE", "undefined");
        } else {
            html = html.replace("$AVG_VALUE", String.valueOf((double)sum / allGrades.size()));
        }
        // send response to client
        response.getWriter().println(html);
    }
}
