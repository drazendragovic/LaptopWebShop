<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Laptop Web Shop</title>	
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/OwlCarousel2-2.2.1/owl.carousel.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/OwlCarousel2-2.2.1/animate.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="super_container">

            <!-- Header -->
            <jsp:include page="header.jsp"/>

            <!-- Home -->

            <div class="home">
                <div class="home_slider_container">

                    <!-- Home Slider -->
                    <div class="owl-carousel owl-theme home_slider">

                        <!-- Slider Item -->
                        <div class="owl-item home_slider_item">
                            <div class="home_slider_background" style="background-image:url(images/slider/home_slider_1.jpg)"></div>
                            <div class="home_slider_content_container">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                <div class="home_slider_title"></div>
                                                <div class="home_slider_subtitle"></div>
                                                <div class="button button_light home_button"><a href="#">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slider Item -->
                        <div class="owl-item home_slider_item">
                            <div class="home_slider_background" style="background-image:url(images/slider/home_slider_2.jpg)"></div>
                            <div class="home_slider_content_container">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                <div class="home_slider_title"></div>
                                                <div class="home_slider_subtitle"></div>
                                                <div class="button button_light home_button"><a href="#">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Slider Item -->
                        <div class="owl-item home_slider_item">
                            <div class="home_slider_background" style="background-image:url(images/slider/home_slider_3.jpg)"></div>
                            <div class="home_slider_content_container">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <div class="home_slider_content"  data-animation-in="fadeIn" data-animation-out="animate-out fadeOut">
                                                <div class="home_slider_title"></div>
                                                <div class="home_slider_subtitle"></div>
                                                <div class="button button_light home_button"><a href="#">Shop Now</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- Home Slider Dots -->

                    <div class="home_slider_dots_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_slider_dots">
                                        <ul id="home_slider_custom_dots" class="home_slider_custom_dots">
                                            <li class="home_slider_custom_dot active">01.</li>
                                            <li class="home_slider_custom_dot">02.</li>
                                            <li class="home_slider_custom_dot">03.</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>	
                    </div>
                </div>
            </div>

            <!--content-->
            
            

            <!-- Icon Boxes -->
            <div class="icon_boxes">
                <div class="container">
                    <div class="row icon_box_row">

                        <!-- Icon Box -->
                        <div class="col-lg-4 icon_box_col">
                            <div class="icon_box">
                                <div class="icon_box_image"><img src="images/icon_1.svg" alt=""></div>
                                <div class="icon_box_title">Free Shipping Worldwide</div>
                                <div class="icon_box_text">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
                                </div>
                            </div>
                        </div>

                        <!-- Icon Box -->
                        <div class="col-lg-4 icon_box_col">
                            <div class="icon_box">
                                <div class="icon_box_image"><img src="images/icon_2.svg" alt=""></div>
                                <div class="icon_box_title">Free Returns</div>
                                <div class="icon_box_text">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
                                </div>
                            </div>
                        </div>

                        <!-- Icon Box -->
                        <div class="col-lg-4 icon_box_col">
                            <div class="icon_box">
                                <div class="icon_box_image"><img src="images/icon_3.svg" alt=""></div>
                                <div class="icon_box_title">24h Fast Support</div>
                                <div class="icon_box_text">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam a ultricies metus. Sed nec molestie.</p>
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

    </body>
</html>

