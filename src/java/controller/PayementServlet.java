package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AppOrder;
import model.AppUser;
import model.Cart;
import model.Item;
import model.OrderItem;
import model.OrderStatus;
import model.PayementType;
import service.OrderService;
import service.OrderServiceImpl;

public class PayementServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        
        String payement = String.valueOf(session.getAttribute("payement"));
        BigDecimal totalPrice = (BigDecimal)session.getAttribute("totalPrice");
        
        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");

        OrderService orderService = new OrderServiceImpl();
        AppUser user = (AppUser) session.getAttribute("user");

        createOrder(payement, totalPrice, user, orderService, cart);

        request.getRequestDispatcher("home").include(request, response);
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

      private void createOrder(String payement, BigDecimal totalPrice, AppUser user, OrderService orderService, ArrayList<Cart> cart) {
        PayementType payType = new PayementType();
        payType.setIDPayementType(payement.equals("PayPal") ? 2 : 1);
        OrderStatus status = new OrderStatus();
        status.setIDOrderStatus(1);

        AppOrder order = new AppOrder();
        order.setDate(Timestamp.valueOf(LocalDateTime.now()));
        order.setTotalprice(totalPrice);
        order.setPayementType(payType);
        order.setStatusID(status);
        order.setUserID(user);
        orderService.addOrder(order);

        insertItemList(cart, order, orderService);
    }

    private void insertItemList(ArrayList<Cart> cart, AppOrder order, OrderService orderService) {
        OrderItem item = new OrderItem();

        for (Cart cartItem : cart) {
            item.setIDOrderItem(null);
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(cartItem.getProductPrice());
            item.setOrderPrice(cartItem.getTotalPrice());
            Item prod = new Item();
            prod.setIDItem(Integer.valueOf(cartItem.getProductID()));
            item.setItemID(prod);
            item.setOrderID(order);
            orderService.addOrderItem(item);
        }
    }
}
