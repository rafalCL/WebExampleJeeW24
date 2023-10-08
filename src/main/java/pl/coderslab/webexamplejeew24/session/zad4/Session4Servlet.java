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

@WebServlet("/cart")
public class Session4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // retrieve stuff from session
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if(cart == null) { // ... or create new list
            cart = new ArrayList<>();
        }

        final String lineTemplate = "%s - %s x %szł = %szł\r\n";
        String html = "Cart:\r\n";
        double cartTotal = 0.;

        for (CartItem ci : cart) {
            double ciTotal = ci.quantity * ci.price;
            cartTotal += ciTotal;
            html += String.format(lineTemplate, ci.productName, ci.quantity, ci.price, ciTotal);
        }
        html += "------------------------\r\n";
        html += "Cart total: " + cartTotal;
        response.getWriter().println(html);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // retrieve stuff from session
        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if(cart == null) { // ... or create new list
            cart = new ArrayList<>();
        }

        // handle data send by user
        try {
            final String productName = request.getParameter("productName");
            final double quantity = Double.parseDouble(request.getParameter("quantity"));
            final double price = Double.parseDouble(request.getParameter("price"));

            CartItem item = new CartItem(productName, quantity, price);
            cart.add(item); // add to item
            session.setAttribute("cart", cart);
            response.sendRedirect("session4.html?msg=dodano+do+koszyka;" + item.productName);
            return;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendRedirect("session4.html?msg=bledne+dane");
            return;
        }
    }
}
