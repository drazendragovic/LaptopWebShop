package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AppOrder;
import model.AppUser;
import model.OrderItem;
import model.PictureGalery;
import service.OrderService;
import service.OrderServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

public class OrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int orderId = Integer.valueOf(request.getParameter("orderId"));
        List<OrderItem> orderItems = new ArrayList<>();
        List<PictureGalery> pictures = new ArrayList<>();
        List<PictureGalery> itemsPictures = new ArrayList<>();
        
        AppUser user = (AppUser) request.getSession().getAttribute("user");

        OrderService orderService = new OrderServiceImpl();
        AppOrder order = orderService.getOrderById(orderId);
        orderItems = orderService.getItemsByOrderId(order);
        
        ProductService prodService = new ProductServiceImpl();
        pictures = prodService.getPictures();
        
        for(OrderItem item : orderItems) {
            for(PictureGalery picture : pictures) {
                if(picture.getPicPath().contains(item.getItemID().getCode())) {
                    if(picture.getPicPath().contains("details_1")) {
                        itemsPictures.add(picture);
                    }
                }
            }
        }

        ServletContext context = getServletContext();
        context.setAttribute("pictures", itemsPictures);

        if (user.getUserTypeID().getName().equals("Admin")) {
            request.setAttribute("order", order);
            request.setAttribute("orderItems", orderItems);
            request.getRequestDispatcher("orderdetails_admin.jsp").include(request, response);
        } else {
            request.setAttribute("order", order);
            request.setAttribute("orderItems", orderItems);
            request.getRequestDispatcher("orderdetails_user.jsp").include(request, response);
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
