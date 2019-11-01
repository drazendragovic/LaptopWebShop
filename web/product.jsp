<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop product</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/product.css" rel="stylesheet" type="text/css"/>
        <link href="css/product_responsive.css" rel="stylesheet" type="text/css"/>


    </head>
    <body>
        <div class="super_container">

            <!-- Header -->
            <jsp:include page="header.jsp"/>

            <!-- Home -->
            <div class="home">
                <div class="home_container">
                    <c:set var = "product" scope = "session" value = "${item}"/>
                    <c:forEach items="${categories}" var="cat" >
                        <c:if test="${cat.getIDCategory() == product.getSubcategoryID().getCategoryID().getIDCategory()}">
                            <div class="home_background" style="background-image:url(${cat.getCatPath()})"></div>
                            <div class="home_content_container">
                                <div class="container">
                                    <div class="row">
                                        <div class="col">
                                            <div class="home_content">
                                                <div class="home_title">${cat.getName()}<span>.</span></div>
                                                <div class="home_text"><p>${cat.getDescription()}</p></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </div>

            <!-- Product Details -->

            <div class="product_details">
                <div class="container">
                    <div class="row details_row">

                        <!-- Product Image -->
                        <div class="col-lg-6">
                            <div class="details_image">
                                <div class="details_image_large"><img src="${pictures[0].getPicPath()}" alt="">
                                    <c:if test="${item.itemStatusID.name.equals('New')}">
                                        <div class="product_extra product_new"><a href="categories.jsp">"${item.itemStatusID.name}"</a></div>
                                    </c:if>
                                    <c:if test="${item.itemStatusID.name.equals('Hot')}">
                                        <div class="product_extra product_hot"><a href="categories.jsp">"${item.itemStatusID.name}"</a></div>
                                    </c:if>
                                    <c:if test="${item.itemStatusID.name.equals('Sale')}">
                                        <div class="product_extra product_sale"><a href="categories.jsp">"${item.itemStatusID.name}"</a></div>
                                    </c:if>
                                </div>
                                <div class="details_image_thumbnails d-flex flex-row align-items-start justify-content-between">
                                    <c:forEach items="${pictures}" var="pic" >
                                        <div class="details_image_thumbnail" data-image="${pic.picPath}"><img src="${pic.picPath}" alt=""></div>
                                        </c:forEach>
                                </div>
                            </div>
                        </div>

                        <!-- Product Content -->
                        <div class="col-lg-6">
                            <div class="details_content">
                                <div class="details_name">${item.name}</div>
                                <div class="details_price">Price: ${item.price}</div>

                                <div class="details_text">
                                    <p>${item.desription}</p>
                                </div>

                                <!-- Product Quantity -->
                                <form action="cart?productId=${item.IDItem}" method="POST">
                                    <div class="product_quantity_container">
                                        <div class="product_quantity clearfix">
                                            <span>Qty</span>
                                            <input id="quantity_input" type="text" name="qty" pattern="[0-9]*" value="1">
                                            <div class="quantity_buttons">
                                                <div id="quantity_inc_button" class="quantity_inc quantity_control"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
                                                <div id="quantity_dec_button" class="quantity_dec quantity_control"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
                                            </div>
                                        </div>
                                        <button class="button cart_button" type="submit">Add to cart</button>
                                    </div>
                                </form>
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
            <script src="js/product.js" type="text/javascript"></script>
    </body>
</html>
