package pl.coderslab.webexamplejeew24.mvcexamples.zad2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Zadanie 2 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Mvc12 dostępny pod adresem /mvc12 , który wczyta dwie zmienne GET : start i end . Następnie:
//
//W servlecie zwiększ obie wartości o wartość 10, przekaż zwiększone zmienne do widoku jsp2.jsp.
//W widoku wyświetl wszystkie liczby od start do end.

@WebServlet("/mvc12")
public class Mvc12Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int startVal = Integer.parseInt(req.getParameter("start")) + 10;
            int endVal = Integer.parseInt(req.getParameter("end")) + 10;
            req.setAttribute("start", startVal);
            req.setAttribute("end", endVal);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/jsp2.jsp").forward(req, resp);
    }
}
