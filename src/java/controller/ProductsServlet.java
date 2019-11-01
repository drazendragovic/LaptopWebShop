package controller;

import java.io.IOException;
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


public class ProductsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int catId = Integer.parseInt(request.getParameter("catId"));
        
        List<Item> items = new ArrayList<>();
        List<PictureGalery> pictures = new ArrayList<>();
        
        ProductService prodService = new ProductServiceImpl();
        items = prodService.getProductsByCategory(catId);
        pictures = prodService.getPictures();
        
        ServletContext context = getServletContext();
        context.setAttribute("items", items);
        context.setAttribute("pictures", pictures);
        
        request.getRequestDispatcher("categories.jsp").forward(request, response);
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
