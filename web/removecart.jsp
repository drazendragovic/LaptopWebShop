<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        String str = request.getParameter("index");
        int index = Integer.parseInt(str);
        
        session = request.getSession();
        ArrayList cart = (ArrayList) session.getAttribute("cart");
        cart.remove(index);

        session.setAttribute("cart", cart);

        if(cart.size() > 0) {
            response.sendRedirect("cart.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
        
    } catch (Exception e) {
        out.println(e);
    }
%>