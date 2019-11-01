package controller;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckoutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String payement = request.getParameter("radio");
        BigDecimal totalPrice = new BigDecimal(request.getParameter("totalPrice"));

        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            if (payement.equals("Cash/Delivery")) {
                session.setAttribute("payement", "Cash/Delivery");
                session.setAttribute("totalPrice", totalPrice);
                request.getRequestDispatcher("checkout.jsp").include(request, response);
            } else {
                session.setAttribute("payement", "PayPal");
                session.setAttribute("totalPrice", totalPrice);
                request.getRequestDispatcher("checkout.jsp").include(request, response);
            }
        } else {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
