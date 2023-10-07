package pl.coderslab.webexamplejeew24;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Dodaj do strony formularz, wysyłany metodą POST. Formularz powinien zawierać jedno pole tekstowe i jeden checkbox z opisem Jestem świadomy konsekwencji.
//Dopisz funkcjonalność, która po przesłaniu formularza sprawdzi,
// czy wpisany przez użytkownika tekst zawiera wulgaryzmy.
// Jeżeli tak, to nasz kod powinien zastąpić wulgarne słowo znakami: ****.
//Na przykład frazę cholera, znowu ta JAVA powinien zastąpić frazą *******, znów ta JAVA .
// Jeżeli użytkownik zaznaczy checkbox Jestem świadomy konsekwencji, to program nie sprawdzi wulgaryzmów i wyświetli wpisany tekst.
// Liczba gwiazdek ma odpowiadać liczbie znaków w cenzurowanym słowie.
//
//Hint: listę wulgaryzmów możesz stworzyć samodzielnie w postaci tablicy, lub poszukać gotowych tablic w internecie.

@WebServlet(name = "Form2Servlet", urlPatterns = "/post2")
public class Form2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userMessage = req.getParameter("userMessage");
        String userAcknowledge = req.getParameter("userAcknowledge");
        if(userAcknowledge==null) {
            final String censored = Censor.doCensor(userMessage);
            resp.getWriter().println(censored);
        } else {
            resp.getWriter().println(userMessage);
        }
    }
}
