<%-- 
    Document   : contact
    Created on : May 9, 2019, 9:12:15 PM
    Author     : DrazenDragovic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop contact</title>
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
                    <div class="home_background" style="background-image:url(images/contact.jpg)"></div>
                    <div class="home_content_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_content">
                                        <div class="breadcrumbs">
                                            <ul>
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>Contact</li>
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
                                <div class="section_title">Get in Touch</div>
                                <div class="section_subtitle">Say hello</div>
                                <div class="contact_form_container">
                                    <form action="#" id="contact_form" class="contact_form">
                                        <div class="row">
                                            <div class="col-xl-6">
                                                <!-- Name -->
                                                <label for="contact_name">First Name*</label>
                                                <input type="text" id="contact_name" class="contact_input" required="required">
                                            </div>
                                            <div class="col-xl-6 last_name_col">
                                                <!-- Last Name -->
                                                <label for="contact_last_name">Last Name*</label>
                                                <input type="text" id="contact_last_name" class="contact_input" required="required">
                                            </div>
                                        </div>
                                        <div>
                                            <!-- Subject -->
                                            <label for="contact_company">Subject</label>
                                            <input type="text" id="contact_company" class="contact_input">
                                        </div>
                                        <div>
                                            <label for="contact_textarea">Message*</label>
                                            <textarea id="contact_textarea" class="contact_input contact_textarea" required="required"></textarea>
                                        </div>
                                        <button class="button contact_button"><span>Send Message</span></button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <!-- Contact Info -->
                        <div class="col-lg-3 offset-xl-1 contact_col">
                            <div class="contact_info">
                                <div class="contact_info_section">
                                    <div class="contact_info_title">Marketing</div>
                                    <ul>
                                        <li>Phone: <span>+53 345 7953 3245</span></li>
                                        <li>Email: <span>yourmail@gmail.com</span></li>
                                    </ul>
                                </div>
                                <div class="contact_info_section">
                                    <div class="contact_info_title">Shippiing & Returns</div>
                                    <ul>
                                        <li>Phone: <span>+53 345 7953 3245</span></li>
                                        <li>Email: <span>yourmail@gmail.com</span></li>
                                    </ul>
                                </div>
                                <div class="contact_info_section">
                                    <div class="contact_info_title">Information</div>
                                    <ul>
                                        <li>Phone: <span>+53 345 7953 3245</span></li>
                                        <li>Email: <span>yourmail@gmail.com</span></li>
                                    </ul>
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
