<%-- 
    Document   : login
    Created on : May 8, 2019, 5:14:44 PM
    Author     : DrazenDragovic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="log" uri="/WEB-INF/tlds/LaptopWebShopLibrary" %>
<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop login</title>
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
                    <div class="home_background" style="background-image:url(images/login.jpg)"></div>
                    <div class="home_content_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_content">
                                        <div class="breadcrumbs">
                                            <ul>
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>Login</li>
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
                                <div class="section_title">Prijavite se!</div>
                                <div class="section_subtitle">Unesite svoje podatke za prijavu.</div>

                                <h2 align="center">
                                    <% if (request.getAttribute("msg") != null) {%>
                                    <p style="color: red">
                                        <%= request.getAttribute("msg")%>
                                    </p>
                                    <% } %>
                                    <% if (request.getAttribute("msg2") != null) {%>
                                    <p style="color: green;">
                                        <%= request.getAttribute("msg2")%>
                                    </p>
                                    <% }%>
                                </h2>

                                <div class="contact_form_container">
                                    
                                    <log:loginTag servlet="Login" />
                                    
                                </div>
                            </div>
                        </div>

                        <!-- Register -->
                        <div class="avds_container col-lg-4">

                            <div class="section_title">Niste registrirani?</div>
                            <div class="section_subtitle">Pridružite se tisućama naših kupaca koji već uživaju u svim prednostima on-line kupnje.</div>

                            <button class="button contact_button"><a href="register.jsp"><span>Register</span></a></button>

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
