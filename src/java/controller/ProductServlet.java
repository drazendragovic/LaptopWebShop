/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.Item;
import model.PictureGalery;
import service.ProductService;
import service.ProductServiceImpl;

/**
 *
 * @author DrazenDragovic
 */
public class ProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int productId = Integer.parseInt(request.getParameter("productId"));
        
        Item product = new Item();
        List<PictureGalery> pictures = new ArrayList<>();
        
        ProductService prodService = new ProductServiceImpl();
        product = prodService.getProductById(productId);
        pictures = prodService.getPicturesforProduct(productId);

        ServletContext context = getServletContext();
        context.setAttribute("item", product);
        context.setAttribute("pictures", pictures);
        
        request.getRequestDispatcher("product.jsp").forward(request, response);
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
