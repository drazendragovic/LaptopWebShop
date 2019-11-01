<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop Admin page</title>
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
                    <div class="home_background" style="background-image:url(images/admin.jpg)"></div>
                    <div class="home_content_container">
                        <div class="container">
                            <div class="row">
                                <div class="col">
                                    <div class="home_content">
                                        <div class="breadcrumbs">
                                            <ul>
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>Admin page</li>
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
                        <jsp:include page="admin_nav.jsp"/>

                        <!-- Orders -->
                        <div class="avds_container col-lg-9">

                            <div class="section_title">Pregled prijava korisnika</div>
                            <div class="section_subtitle">Pridružite se tisućama naših kupaca koji već uživaju u svim prednostima on-line kupnje.</div>

                            <div class="myorders">
                                <table class="table">
                                    <thead class="thead-light">
                                        <tr class="d-flex">
                                            <th class="col-4">Datum</th>
                                            <th class="col-4">Korisnik</th>
                                            <th class="col-4">IP adresa</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:choose>
                                        <c:when test="${logins[0] != null}">
                                            <c:forEach items="${logins}" var="item">
                                                <tr class="d-flex">
                                                    <td class="col-4">${item.date}</td>
                                                    <td class="col-4">${item.userID.toString()}</td>
                                                    <td class="col-4">${item.ipAdress}</td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr class="d-flex">
                                                <td class="col-2">No Logins</td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                    </tbody>
                                </table>
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
