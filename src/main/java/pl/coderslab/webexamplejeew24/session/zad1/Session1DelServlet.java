package pl.coderslab.webexamplejeew24.session.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

// Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz trzy servlety:
//
//Session1Set dostępny pod adresem /session1Set,
//Session1Get dostępny pod adresem /session1Get ,
//Session1Del dostępny pod adresem /session1Del.
//Pierwszy ma ustawiać atrybut sesji pod kluczem counter na 0.
//Drugi ma wyświetlać zawartość sesji pod kluczem counter i zwiększać go o 1. Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić informację: EMPTY.
//Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem counter).

@WebServlet(name = "Session1DelServlet", urlPatterns = "/session1Del")
public class Session1DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("counter");

        resp.getWriter().println("usunięto counter z sesji");
    }
}
