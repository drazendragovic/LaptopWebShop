<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="plugins/DataTables/datatables.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/DataTables/AutoFill-2.3.3/css/autoFill.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/DataTables/Buttons-1.5.6/css/buttons.bootstrap4.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/DataTables/Responsive-2.2.2/css/responsive.bootstrap4.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/DataTables/Select-1.3.0/css/select.bootstrap4.css" rel="stylesheet" type="text/css"/>
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

                            <div class="section_title">Pregled narudžbi</div>
                            <div class="section_subtitle">Pregled svih odrađenih narudžbi na web shopu</div>

                            <div class="myorders d-flex">
                                <table class="table" id="myTable">
                                    <thead class="thead-light">
                                        <tr>
                                            <th class="col-1">Datum</th>
                                            <th class="col-2">Broj narudžbe</th>
                                            <th class="col-1">Vrijednost</th>
                                            <th class="col-2">Placanje</th>
                                            <th class="col-1">Status</th>
                                            <th class="col-2">Kupac</th>
                                            <th class="col-1"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${allorders[0] != null}">
                                                <c:forEach items="${allorders}" var="item">
                                                    <tr>
                                                        <td class="col-1">${item.date}</td>
                                                        <td class="col-2">${item.IDOrder}</td>
                                                        <td class="col-1">${item.totalprice}</td>
                                                        <td class="col-2">${item.payementType.name}</td>
                                                        <td class="col-1">${item.statusID}</td>
                                                        <th class="col-2">${item.userID.toString()}</th>
                                                        <td class="col-1"><button class="button order_button"><a href="order?orderId=${item.IDOrder}"><span>Detalji</span></a></button></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <tr class="d-flex">
                                                    <td class="col-2">No Orders</td>
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
        <script src="plugins/DataTables/datatables.js" type="text/javascript"></script>
        <script src="plugins/DataTables/AutoFill-2.3.3/js/autoFill.bootstrap4.js" type="text/javascript"></script>
        <script src="plugins/DataTables/Buttons-1.5.6/js/buttons.bootstrap4.js" type="text/javascript"></script>
        <script src="plugins/DataTables/DataTables-1.10.18/js/dataTables.bootstrap4.js" type="text/javascript"></script>
        <script src="plugins/DataTables/Responsive-2.2.2/js/responsive.bootstrap4.js" type="text/javascript"></script>
        <script src="plugins/DataTables/Select-1.3.0/js/select.bootstrap4.js" type="text/javascript"></script>

        <script>
            $(document).ready(function () {
                $('#myTable').DataTable();
            });
        </script>
    </body>
</html>
