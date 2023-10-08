package pl.coderslab.webexamplejeew24.mvcexamples.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//   Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz jsp1.jsp.
//
//Dołącz do projektu bibliotekę jstl.
//W projekcie stwórz servlet Mvc11 dostępny pod adresem /mvc11.
//W servlecie w metodzie GET pobierz parametr o nazwie role a następnie zamień zawartość na wielkie litery oraz dodaj prefix ROLE_ (dla wartości manager otrzymamy ROLE_MANAGER).
//Ustaw atrybut o nazwie userRole ze zmienioną wartością.
//Ustaw plik jsp jako plik widoku dla tego servletu.
//W przypadku braku wartości ma się wyświetlić napis guest.

@WebServlet("/mvc11")
public class Mvc11Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String role = req.getParameter("role");
        if(role!=null) {
            req.setAttribute("userRole" , "ROLE_" + role.toUpperCase());
        }

        getServletContext().getRequestDispatcher("/jsp1.jsp").forward(req, resp);
    }
}
