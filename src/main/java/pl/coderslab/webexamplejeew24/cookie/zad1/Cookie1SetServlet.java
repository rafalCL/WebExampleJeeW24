package pl.coderslab.webexamplejeew24.cookie.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Zadanie 1 - rozwiązywane z wykładowcą
//        W projekcie stwórz trzy servlety Cookie1Set, Cookie1Get, Cookie1Del.
//        Servlet Cookie1Set ma być dostępny pod adresem /setCookie. Ma nastawiać ciasteczko o nazwie User na CodersLab, z ważnością 24h.
//        Servlet Cookie1Get ma być dostępny pod adresem /showCookie. Ma wyświetlać zawartość ciasteczka User.
//        Servlet Cookie1Del ma być dostępny pod adresem /deleteCookie ma kasować ciasteczko o nazwie User. Jeżeli nie ma takiego ciasteczka, to powinien wyświetlić się napis: BRAK.

@WebServlet(name = "Cookie1SetServlet", urlPatterns = "/setCookie")
public class Cookie1SetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        Servlet Cookie1Set ma być dostępny pod adresem /setCookie.
        //        Ma nastawiać ciasteczko o nazwie User na CodersLab, z ważnością 24h.
        Cookie cookie = new Cookie("User", "CodersLab");
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);

        resp.addCookie(cookie);
        resp.getWriter().println("ustawiono ciasteczko");
    }
}
