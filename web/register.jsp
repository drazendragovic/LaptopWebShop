<%-- 
    Document   : register
    Created on : May 8, 2019, 6:25:13 PM
    Author     : DrazenDragovic
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop register</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/contact.css" rel="stylesheet" type="text/css"/>
        <link href="css/contact_responsive.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="super_container">

            <!-- Header -->
            <jsp:include page="header.jsp"/>

            <!-- Home -->

            <div class="home">
                <div class="home_container">
                    <div class="home_background" style="background-image:url(images/register.jpg)"></div>
                    <div class="home_content_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_content">
                                        <div class="breadcrumbs">
                                            <ul>
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>Register</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Contact -->

            <div class="contact">
                <div class="container">
                    <div class="row">

                        <!-- Get in touch -->
                        <div class="col-lg-8 contact_col">
                            <div class="get_in_touch">
                                <div class="section_title">Dobro došli na Laptop Shop</div>
                                <div class="section_subtitle">Podaci za prijavu</div>

                                <h2 align="center">
                                    <% if (request.getAttribute("msg2") != null) {%>
                                    <p style="color: red">
                                        <%= request.getAttribute("msg2")%>
                                    </p>
                                    <% }%>
                                </h2>

                                <div class="contact_form_container">
                                    <form action="Registration" method="post" id="contact_form" class="contact_form">
                                        <div class="row">
                                            <div class="col-xl-6">
                                                <!-- Name -->
                                                <label for="contact_name">First Name*</label>
                                                <input type="text" id="contact_name" name="name" class="contact_input" required="required">
                                            </div>
                                            <div class="col-xl-6 last_name_col">
                                                <!-- Last Name -->
                                                <label for="contact_email">Last Name*</label>
                                                <input type="text" id="contact_email" name="surname" class="contact_input" required="required">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-6 last_name_col">
                                                <!-- Last Name -->
                                                <label for="contact_email">E-mail*</label>
                                                <input type="email" id="contact_email" name="email" class="contact_input" required="required">
                                            </div>
                                            <div class="col-xl-6 last_name_col">
                                                <!-- Last Name -->
                                                <label for="contact_username">Username*</label>
                                                <input type="text" id="contact_username" name="username" class="contact_input" required="required">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xl-6 last_name_col">
                                                <!-- Last Name -->
                                                <label for="contact_pass">Password*</label>
                                                <input type="password" id="contact_pass" name="password" class="contact_input" required="required">
                                            </div>
                                            <div class="col-xl-6 last_name_col">
                                                <!-- Last Name -->
                                                <label for="contact_conf_pass">Conform Password*</label>
                                                <input type="password" id="contact_conf_pass" name="confPassword" class="contact_input" required="required">
                                            </div>
                                        </div>
                                        <button type="submit" class="button contact_button"><span>Register User</span></button>
                                        <button type="reset" class="button contact_button"><span>Reset form</span></button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <!-- Ads -->
                        <div class="avds_container col-lg-4">
                            <div class="avds_small">
                                <div class="avds_background" style="background-image:url(images/avds_small.jpg)"></div>
                                <div class="avds_small_inner">
                                    <div class="avds_discount_container">
                                        <img src="images/discount.png" alt="">
                                        <div>
                                            <div class="avds_discount">
                                                <div>20<span>%</span></div>
                                                <div>Discount</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="avds_small_content">
                                        <div class="avds_title">Acer Nitro 5</div>
                                        <div class="avds_link"><a href="products?catId=1">See More</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
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
        <script src="js/contact.js" type="text/javascript"></script>
    </body>
</html>
