<%@page import="model.Cart"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop checkout</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/checkout.css" rel="stylesheet" type="text/css"/>
        <link href="css/checkout_responsive.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="super_container">

            <!-- Header -->
            <jsp:include page="header.jsp"/>

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
                                                <li><a href="cart.jsp">Shopping Cart</a></li>
                                                <li>Checkout</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Checkout -->
            <form method="POST" action="payement" id="checkout_form" class="checkout_form">
                <div class="checkout">
                    <div class="container">
                        <div class="row">

                            <!-- Billing Info -->

                            <div class="col-lg-6">
                                <div class="billing checkout_section">
                                    <div class="section_title">Billing Address</div>
                                    <div class="section_subtitle">Enter your address info</div>
                                    <div class="checkout_form_container">

                                        <div class="row">
                                            <div class="col-xl-6">
                                                <!-- Name -->
                                                <label for="checkout_name">First Name*</label>
                                                <input type="text" id="checkout_name" class="checkout_input" value="${user.name}" required="required">
                                            </div>
                                            <div class="col-xl-6 last_name_col">
                                                <!-- Last Name -->
                                                <label for="checkout_last_name">Last Name*</label>
                                                <input type="text" id="checkout_last_name" class="checkout_input" value="${user.surname}" required="required">
                                            </div>
                                        </div>
                                        <div>
                                            <!-- Country -->
                                            <label for="checkout_country">Country*</label>
                                            <select name="checkout_country" id="checkout_country" class="custom-select checkout_input" require="required">
                                                <option></option>
                                                <option>Lithuania</option>
                                                <option>Sweden</option>
                                                <option>UK</option>
                                                <option>Italy</option>
                                            </select>
                                        </div>
                                        <div>
                                            <!-- Address -->
                                            <label for="checkout_address">Address*</label>
                                            <input type="text" id="checkout_address" class="checkout_input" required="required">
                                        </div>
                                        <div>
                                            <!-- Zipcode -->
                                            <label for="checkout_zipcode">Zipcode*</label>
                                            <input type="text" id="checkout_zipcode" class="checkout_input" required="required">
                                        </div>
                                        <div>
                                            <!-- City / Town -->
                                            <label for="checkout_city">City/Town*</label>
                                            <select name="checkout_city" id="checkout_city" class="custom-select checkout_input" require="required">
                                                <option></option>
                                                <option>Zagreb</option>
                                                <option>Osijek</option>
                                                <option>Split</option>
                                                <option>Dubrovnik</option>
                                            </select>
                                        </div>
                                        <div>
                                            <!-- Phone no -->
                                            <label for="checkout_phone">Phone no*</label>
                                            <input type="phone" id="checkout_phone" class="checkout_input" required="required">
                                        </div>
                                        <div>
                                            <!-- Email -->
                                            <label for="checkout_email">Email Address*</label>
                                            <input type="phone" id="checkout_email" class="checkout_input" value="${user.email}" required="required">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Order Info -->

                            <div class="col-lg-6">
                                <div class="order checkout_section">
                                    <div class="section_title">Your order</div>
                                    <div class="section_subtitle">Order details</div>

                                    <!-- Order details -->
                                    <div class="order_list_container">
                                        <div class="order_list_bar d-flex flex-row align-items-center justify-content-start">
                                            <div class="order_list_title">Product</div>
                                            <div class="order_list_value ml-auto">Total</div>
                                        </div>
                                        <div>

                                            <ul class="order_list">
                                                <c:forEach items="${cart}" var="item">
                                                    <li class="d-flex flex-row align-items-center justify-content-start">
                                                        <div class="order_list">${item.productName}</div>
                                                        <div class="order_list ml-auto">Kn${item.totalPrice}</div>
                                                    </li>
                                                </c:forEach>
                                            </ul>

                                        </div>
                                        <div class="order_list_bar">
                                            <div class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="order_list_title">Subtotal</div>
                                                <div class="order_list_value ml-auto">Kn${totalPrice}</div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="order_list_title">Shipping</div>
                                                <div class="order_list_value ml-auto">Free</div>
                                            </div>
                                            <div class="d-flex flex-row align-items-center justify-content-start">
                                                <div class="order_list_title">Total</div>
                                                <div class="order_list_value ml-auto" name="totalPrice">Kn${totalPrice}</div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Payment Options -->
                                    <div class="payment">
                                        <div class="payment_options">
                                            <c:choose>
                                                <c:when test="${ payement == 'PayPal' }">
                                                    <label class="payment_option clearfix">Paypal
                                                        <input type="radio" name="radio" value="PayPal" checked disabled>
                                                        <span class="checkmark"></span>
                                                    </label>
                                                    <label class="payment_option clearfix">Cach on delivery
                                                        <input type="radio" name="radio" value="Cash/Delivery" disabled>
                                                        <span class="checkmark"></span>
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label class="payment_option clearfix">Paypal
                                                        <input type="radio" name="radio" value="PayPal" disabled>
                                                        <span class="checkmark"></span>
                                                    </label>
                                                    <label class="payment_option clearfix">Cach on delivery
                                                        <input type="radio" name="radio" value="Cash/Delivery" checked disabled>
                                                        <span class="checkmark"></span>
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <c:choose>
                                        <c:when test="${ payement == 'PayPal' }">
                                            <div id="paypal-button-container" class="paypal"></div>
                                        </c:when>
                                        <c:otherwise>
                                            <button class="button order_button" type="submit">Place Order</button>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

            <jsp:include page="footer.jsp"/>
            <!--//footer-->
        </div>

        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js" type="text/javascript"></script>
        <script src="plugins/parallax-js-master/parallax.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
        <script src="js/checkout.js" type="text/javascript"></script>

        <script src="https://www.paypal.com/sdk/js?client-id=sb&currency=USD"></script>
        <script>
            // Render the PayPal button into #paypal-button-container
            paypal.Buttons({

                style: {
                    color: 'blue',
                    shape: 'pill',
                    label: 'pay',
                    height: 40
                }

            }).render('#paypal-button-container');
        </script>
    </body>
</html>
