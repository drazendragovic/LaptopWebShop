<%@page import="java.math.BigDecimal"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        String product_id = request.getParameter("product_id");
        int qty = Integer.parseInt(request.getParameter("qty"));
        
        session = request.getSession();
        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");
            for (int i = 0; i < cart.size(); i++) {
                if(cart.get(i).getProductID().equals(product_id))
                    cart.get(i).setQuantity(qty);
                    cart.get(i).setTotalPrice(BigDecimal.valueOf(qty).multiply(cart.get(i).getProductPrice()));
            }

        session.setAttribute("cart", cart);

    } catch (Exception e) {
        out.println(e);
    }
%>