package pl.coderslab.webexamplejeew24.cookie.zad2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie2Servlet", urlPatterns = "/addToCookies")
public class Cookie2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        String value = req.getParameter("value");


        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);

        resp.addCookie(cookie);
        resp.getWriter().printf("ustawiono ciasteczko %s=%s\r\n", key, value);
    }
}
