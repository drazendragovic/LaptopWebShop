/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.PictureGalery;
import service.ProductService;
import service.ProductServiceImpl;

/**
 *
 * @author DrazenDragovic
 */
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String productId = request.getParameter("productId");
        int productQty = Integer.parseInt(request.getParameter("qty"));
        List<PictureGalery> pictures = new ArrayList<>();
        PictureGalery picture;

        ProductService prodService = new ProductServiceImpl();
        Item product = prodService.getProductById(Integer.parseInt(productId));
        picture = prodService.getPicturesforProduct(Integer.valueOf(productId)).get(0);

        HttpSession session = request.getSession();
        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");
        
        BigDecimal totalPrice = BigDecimal.valueOf(productQty).multiply(product.getPrice());
        if (cart == null) {
            cart.add(new Cart(productId, product.getName(), product.getPrice(), productQty, totalPrice, picture.getPicPath()));
        } else {
            boolean checkID = false;
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).getProductID().equals(productId)) {
                    cart.get(i).setQuantity(cart.get(i).getQuantity() + productQty);
                    cart.get(i).setTotalPrice(cart.get(i).getTotalPrice().add(product.getPrice()));
                    checkID = true;
                    break;
                }
            }
            //if ID isn't exist
            if (checkID == false) {
                cart.add(new Cart(productId, product.getName(), product.getPrice(), productQty, totalPrice, picture.getPicPath()));
            }
        }

        session.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request, response);

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
