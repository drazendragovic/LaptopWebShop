<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    try {
        session = request.getSession();
        ArrayList cart = (ArrayList) session.getAttribute("cart");
        cart.clear();

        session.setAttribute("cart", cart);

        response.sendRedirect("index.jsp");

    } catch (Exception e) {
        out.println(e);
    }
%>
