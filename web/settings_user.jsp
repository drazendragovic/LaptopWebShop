<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop My page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/user_page.css" rel="stylesheet" type="text/css"/>
        <link href="css/userpage_responsive.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>


        <div class="super_container">

            <!-- Header -->
            <jsp:include page="header.jsp"/>

            <!-- Home -->

            <div class="home">
                <div class="home_container">
                    <div class="home_background" style="background-image:url(images/user.jpg)"></div>
                    <div class="home_content_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_content">
                                        <div class="breadcrumbs">
                                            <ul>
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>My page</li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- User navigation -->
            <div class="contact">
                <div class="container">
                    <div class="row">

                        <!-- User navigation -->
                        <jsp:include page="user_nav.jsp"/>

                        <!-- Settings -->
                        <div class="avds_container col-lg-9">

                            <div class="section_title">Vaše postavke</div>
                            <div class="section_subtitle">Pridružite se tisućama naših kupaca koji već uživaju u svim prednostima on-line kupnje.</div>

                            <div class="contact_form_container">
                                <form action="Registration" method="POST" id="contact_form" class="contact_form">
                                    <div class="row">
                                        <div class="col-xl-6">
                                            <!-- Name -->
                                            <label for="contact_name">First Name*</label>
                                            <input type="text" id="contact_name" name="name" class="contact_input" value="${user.name}" required="required">
                                        </div>
                                        <div class="col-xl-6 last_name_col">
                                            <!-- Last Name -->
                                            <label for="contact_email">Last Name*</label>
                                            <input type="text" id="contact_email" name="surname" class="contact_input" value="${user.surname}" required="required">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xl-6 last_name_col">
                                            <!-- Last Name -->
                                            <label for="contact_email">E-mail*</label>
                                            <input type="email" id="contact_email" name="email" class="contact_input" value="${user.email}"required="required">
                                        </div>
                                        <div class="col-xl-6 last_name_col">
                                            <!-- Last Name -->
                                            <label for="contact_username">Username*</label>
                                            <input type="text" id="contact_username" name="username" class="contact_input" value="${user.username}" required="required">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-xl-6 last_name_col">
                                            <!-- Last Name -->
                                            <label for="contact_pass">Password*</label>
                                            <input type="password" id="contact_pass" name="password" class="contact_input" value="${user.password}" required="required">
                                        </div>
                                        <div class="col-xl-6 last_name_col">
                                            <!-- Last Name -->
                                            <label for="contact_conf_pass">Conform Password*</label>
                                            <input type="password" id="contact_conf_pass" name="confPassword" class="contact_input" required="required">
                                        </div>
                                    </div>
                                    <button type="submit" class="button contact_button"><span>Update</span></button>
                                </form>
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
