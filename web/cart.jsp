<%@page import="model.Cart"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/cart.css" rel="stylesheet" type="text/css"/>
        <link href="css/cart_responsive.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="super_container">

            <!-- Header -->
            <jsp:include page="header.jsp"/>

            <%!  BigDecimal totalPrice;%>

            <%
                int index = 0;
                totalPrice = BigDecimal.valueOf(0);
                session = request.getSession();
                if (session.getAttribute("cart") != null) {
                    ArrayList<Cart> cartItems = (ArrayList<Cart>) session.getAttribute("cart");
                    for (int i = 0; i < cartItems.size(); i++) {
                        totalPrice = totalPrice.add(cartItems.get(i).getTotalPrice());
                    }
                }
            %>  

            <!-- Home -->

            <div class="home">
                <div class="home_container">
                    <div class="home_background" style="background-image:url(images/cart.jpg)"></div>
                    <div class="home_content_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_content">
                                        <div class="breadcrumbs">
                                            <ul>
                                                <li><a href="index.jsp">Home</a></li>
                                                <li><a href="categories.jsp">Categories</a></li>
                                                <li>Shopping Cart</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Cart Info -->

            <div class="cart_info">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <!-- Column Titles -->
                            <div class="cart_info_columns clearfix">
                                <div class="cart_info_col cart_info_col_product">Product</div>
                                <div class="cart_info_col cart_info_col_price">Price</div>
                                <div class="cart_info_col cart_info_col_quantity">Quantity</div>
                                <div class="cart_info_col cart_info_col_total">Total</div>
                            </div>
                        </div>
                    </div>


                    <div class="row cart_items_row">
                        <div class="col">

                            <!-- Cart Item -->
                            <c:forEach items="${cart}" var="item">
                                <div class="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
                                    <!-- Name -->

                                    <div class="cart_item_product d-flex flex-row align-items-center justify-content-start">
                                        <div class="cart_item_image">
                                            <div><img src="${item.getPicPath()}" alt=""></div>
                                        </div>
                                        <div class="cart_item_name_container">
                                            <div class="cart_item_name"><a href="#">${item.productName}</a></div>
                                            <div class="cart_item_edit"><a href="removecart.jsp?index=<%= index%>">Remove</a></div>
                                        </div>
                                    </div>
                                    <!-- Price -->
                                    <div class="cart_item_price">${item.productPrice}</div>
                                    <!-- Quantity -->
                                    <div class="cart_item_quantity">
                                        <div class="product_quantity_container">
                                            <div class="product_quantity clearfix">
                                                <span>Qty</span>
                                                <div class="quantity_buttons">
                                                    <input class="product_id" type="hidden" name="product_id" value="${item.productID}">
                                                    <input id="quantity_input" class="inValue" name="item" type="text" pattern="[0-9]*" value="${item.quantity}">
                                                    <div id="quantity_inc_button" class="quantity_inc quantity_control">+</div>
                                                    <div id="quantity_dec_button" class="quantity_dec quantity_control">-</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Total -->
                                    <div class="cart_item_total">${item.totalPrice}</div>
                                </div>
                                <% index++;%>
                            </c:forEach>

                        </div>
                    </div>
                    <div class="row row_cart_buttons">
                        <div class="col">
                            <div class="cart_buttons d-flex flex-lg-row flex-column align-items-start justify-content-start">
                                <div class="button continue_shopping_button"><a href="categories.jsp">Continue shopping</a></div>
                                <div class="cart_buttons_right ml-lg-auto">
                                    <div class="button clear_cart_button"><a href="clearcart.jsp">Clear cart</a></div>
                                    <div class="button update_cart_button"><a href="cart.jsp">Update cart</a></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <form method="POST" action="checkout">
                        <div class="row row_extra">
                            <div class="col-lg-4">

                                <!-- Delivery -->
                                <div class="delivery">
                                    <div class="section_title">Payement method</div>
                                    <div class="section_subtitle">Select the one you want</div>
                                    <div class="delivery_options">
                                        <label class="delivery_option clearfix">Cash on delivery
                                            <input type="radio" name="radio" checked="checked" value="Cash/Delivery">
                                            <span class="checkmark"></span>
                                        </label>
                                        <label class="delivery_option clearfix">PayPal payement
                                            <input type="radio" name="radio" value="PayPal">
                                            <span class="checkmark"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-6 offset-lg-2">
                                <div class="cart_total">
                                    <div class="section_title">Cart total</div>
                                    <div class="section_subtitle">Final info</div>
                                    <div class="cart_total_container">
                                        <ul>
                                            <li class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="cart_total_title">Subtotal</div>
                                                <div class="cart_total_value ml-auto"><%= totalPrice%></div>
                                            </li>
                                            <li class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="cart_total_title">Shipping</div>
                                                <div class="cart_total_value ml-auto">Free</div>
                                            </li>
                                            <li class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="cart_total_title">Total</div>
                                                <div class="cart_total_value ml-auto"><%= totalPrice%>
                                                    <input type="hidden" name="totalPrice" id="price" value="<%= totalPrice%>">
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <button class="button checkout_button" type="submit">Proceed to checkout</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>		
            </div>

            <jsp:include page="footer.jsp"/>
            <!--//footer-->
        </div>

        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js" type="text/javascript"></script>
        <script src="plugins/parallax-js-master/parallax.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
        <script src="js/cart.js" type="text/javascript"></script>
    </body>
</html>
