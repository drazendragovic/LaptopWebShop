package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AppOrder;
import model.AppUser;
import model.Logins;
import service.BaseService;
import service.BaseServiceImpl;
import service.OrderService;
import service.OrderServiceImpl;

public class AdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        List<Logins> logins = new ArrayList<>();
        List<AppOrder> orders = new ArrayList<>();
        AppUser user = (AppUser) request.getSession().getAttribute("user");
        
        BaseService baseService = new BaseServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        
        logins = baseService.getRecords();
        orders = orderService.getOrders();
        
        request.setAttribute("logins", logins);
        session.setAttribute("allorders", orders);
        request.getRequestDispatcher("home_admin.jsp").include(request, response);

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
