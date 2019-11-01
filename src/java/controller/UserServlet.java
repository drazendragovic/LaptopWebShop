package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AppOrder;
import model.AppUser;
import model.OrderItem;
import service.OrderService;
import service.OrderServiceImpl;

public class UserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<AppOrder> orders = new ArrayList<>();
        AppUser user = (AppUser) request.getSession().getAttribute("user");
        
        OrderService orderService = new OrderServiceImpl();
        
        orders = orderService.getOrdersByUserId(user);
        
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("home_user.jsp").include(request, response);
        
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
