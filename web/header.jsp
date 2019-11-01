<%@page import="java.util.ArrayList"%>
<%@page import="model.AppUser"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header class="header">
    <div class="header_container">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="header_content d-flex flex-row align-items-center justify-content-start">
                        <div class="logo"><a href="#">LaptopShop.</a></div>
                        <nav class="main_nav">
                            <ul>
                                <li>
                                    <a href="index.jsp">Home</a>
                                </li>
                                <li class="hassubs">
                                    <a href="">Categories</a>
                                    <ul>
                                        <c:forEach items="${categories}" var="cat" >
                                            <li>
                                                <a href='products?catId=${cat.getIDCategory()}'>${cat.name}</a>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </li>
                                <li><a href="#">Offers</a></li>
                                <li><a href="contact.jsp">Contact</a></li>
                            </ul>
                        </nav>

                        <%
                            ArrayList items = (ArrayList) session.getAttribute("cart");

                            if (items.size() == 0) {%>
                        <div class="header_extra ml-auto">
                            <div class="shopping_cart">
                                <a href=""><i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                    <div>Cart <span>(0)</span></div>
                                </a>
                            </div>
                            <div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
                        </div>
                        <%} else {%>
                        <div class="header_extra ml-auto">
                            <div class="shopping_cart">
                                <a href="cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                    <div>Cart <span>(<%= items.size()%>)</span></div>
                                </a>
                            </div>
                            <div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
                        </div>
                        <%}%>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Login -->
    <div class="header_login">
        <ul>
            <%
                AppUser user = (AppUser) session.getAttribute("user");
                if (user == null) {%>
            <li><a href="register.jsp"><i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;Register</a></li>
            <li><a href="login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>&nbsp;Login</a></li>
                <% } else {%>
            <li><i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;Pozdrav, <%= user.getName()%></li>
            <li class="hassubs">
                <a href="logout.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>&nbsp;Logout</a>
                <% if (user.getIDUser() == 1) {%>
                <ul>
                    <li><a href="buyer">My page</a></li>
                </ul>
                <% } else {%>
                <ul>
                    <li><a href="admin">My page</a></li>
                </ul>
                <% }
                %>
            </li>
            <% }
            %>
        </ul>
    </div>
</header>

<!-- Menu -->

<div class="menu menu_mm trans_300">
    <div class="menu_container menu_mm">
        <div class="page_menu_content">

            <ul class="page_menu_nav menu_mm">
                <li class="page_menu_item has-children menu_mm">
                    <a href="index.jsp">Home<i class="fa fa-angle-down"></i></a>
                    <ul class="page_menu_selection menu_mm">
                        <li class="page_menu_item menu_mm"><a href="categories.jsp">Categories<i class="fa fa-angle-down"></i></a></li>
                        <li class="page_menu_item menu_mm"><a href="product.jsp">Product<i class="fa fa-angle-down"></i></a></li>
                        <li class="page_menu_item menu_mm"><a href="cart.jsp">Cart<i class="fa fa-angle-down"></i></a></li>
                        <li class="page_menu_item menu_mm"><a href="checkout.jsp">Checkout<i class="fa fa-angle-down"></i></a></li>
                        <li class="page_menu_item menu_mm"><a href="contact.jsp">Contact<i class="fa fa-angle-down"></i></a></li>
                    </ul>
                </li>
                <li class="page_menu_item has-children menu_mm">
                    <a href="categories.html">Categories<i class="fa fa-angle-down"></i></a>
                    <ul class="page_menu_selection menu_mm">
                        <li class="page_menu_item menu_mm"><a href="categories.jsp">Category<i class="fa fa-angle-down"></i></a></li>
                        <li class="page_menu_item menu_mm"><a href="categories.jsp">Category<i class="fa fa-angle-down"></i></a></li>
                        <li class="page_menu_item menu_mm"><a href="categories.jsp">Category<i class="fa fa-angle-down"></i></a></li>
                        <li class="page_menu_item menu_mm"><a href="categories.jsp">Category<i class="fa fa-angle-down"></i></a></li>
                    </ul>
                </li>
                <li class="page_menu_item menu_mm"><a href="#">Offers<i class="fa fa-angle-down"></i></a></li>
                <li class="page_menu_item menu_mm"><a href="contact.jsp">Contact<i class="fa fa-angle-down"></i></a></li>
            </ul>
        </div>
    </div>

    <div class="menu_close"><i class="fa fa-times" aria-hidden="true"></i></div>

    <div class="menu_login">
        <ul>
            <%
                if (user == null) {%>
            <li><a href="register.jsp"><i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;Register</a></li>
            <li><a href="login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>&nbsp;Login</a></li>
                <% } else {%>
            <li><i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;Pozdrav, <%= user.getName()%></li>
            <li><a href="logout.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>&nbsp;Logout</a></li>
                <% }
                %>
        </ul>
    </div>
</div>