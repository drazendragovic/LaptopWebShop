<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!DOCTYPE html>
<html>
    <head>
        <title>LaptopShop categories</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
        <link href="plugins/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="css/categories.css" rel="stylesheet" type="text/css"/>
        <link href="css/categories_responsive.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="super_container">

            <!-- Header -->
            <jsp:include page="header.jsp"/>

            <!-- Home -->

            <div class="home">
                <div class="home_container">
                    <c:forEach items="${categories}" var="cat" >
                        <c:forEach items="${items}" var="item" >
                            <c:if test="${cat.getIDCategory() == item.getSubcategoryID().getCategoryID().getIDCategory()}">
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
                    </c:forEach>
                </div>
            </div>

            <!-- Products -->

            <div class="products">
                <div class="container">
                    <div class="row">
                        <div class="col">

                            <!-- Product Sorting -->
                            <div class="sorting_bar d-flex flex-md-row flex-column align-items-md-center justify-content-md-start">
                                <div class="results">Showing <span>12</span> results</div>
                                <div class="sorting_container ml-md-auto">
                                    <div class="sorting">
                                        <ul class="item_sorting">
                                            <li>
                                                <span class="sorting_text">Sort by</span>
                                                <i class="fa fa-chevron-down" aria-hidden="true"></i>
                                                <ul>
                                                    <li class="product_sorting_btn" data-isotope-option='{ "sortBy": "original-order" }'><span>Default</span></li>
                                                    <li class="product_sorting_btn" data-isotope-option='{ "sortBy": "price" }'><span>Price</span></li>
                                                    <li class="product_sorting_btn" data-isotope-option='{ "sortBy": "stars" }'><span>Name</span></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">

                            <div class="product_grid">


                                <!-- Product -->
                                <c:forEach items="${items}" var="item" >
                                    <c:forEach items="${pictures}" var="pic" >
                                        <c:if test="${(pic.getPictureItemID().getIDItem() == item.getIDItem()) && (fn:containsIgnoreCase(pic.getPicPath(), 'details_1'))}">
                                            <c:if test="${item.itemStatusID.name.equals('New')}">
                                                <div class="product">
                                                    <div class="product_image"><img src="${pic.getPicPath()}" alt=""></div>
                                                    <div class="product_extra product_new"><a href="categories.html">New</a></div>
                                                    <div class="product_content">
                                                        <div class="product_title"><a href='product?productId=${item.getIDItem()}'>${item.name}</a></div>
                                                        <div class="product_price">${item.price}</div>
                                                    </div>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.itemStatusID.name.equals('Hot')}">
                                                <div class="product">
                                                    <div class="product_image"><img src="${pic.getPicPath()}" alt=""></div>
                                                    <div class="product_extra product_hot"><a href="categories.html">Hot</a></div>
                                                    <div class="product_content">
                                                        <div class="product_title"><a href='product?productId=${item.getIDItem()}'>${item.name}</a></div>
                                                        <div class="product_price">${item.price}</div>
                                                    </div>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.itemStatusID.name.equals('Sale')}">
                                                <div class="product">
                                                    <div class="product_image"><img src="${pic.getPicPath()}" alt=""></div>
                                                    <div class="product_extra product_sale"><a href="categories.html">Sale</a></div>
                                                    <div class="product_content">
                                                        <div class="product_title"><a href='product?productId=${item.getIDItem()}'>${item.name}</a></div>
                                                        <div class="product_price">${item.price}</div>
                                                    </div>
                                                </div>
                                            </c:if>
                                            <c:if test="${item.itemStatusID == null}">
                                                <div class="product">
                                                    <div class="product_image"><img src="${pic.getPicPath()}" alt=""></div>
                                                    <div class="product_content">
                                                        <div class="product_title"><a href='product?productId=${item.getIDItem()}'>${item.name}</a></div>
                                                        <div class="product_price">${item.price}</div>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>
                            </div>

                            <div class="product_pagination">
                                <ul>
                                    <li class="active"><a href="#">01.</a></li>
                                        <c:if test="${items.size() < 4}">
                                        <li><a href="#">02.</a></li>
                                        </c:if>
                                </ul>
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
        <script src="plugins/Isotope/isotope.pkgd.min.js" type="text/javascript"></script>
        <script src="plugins/parallax-js-master/parallax.min.js" type="text/javascript"></script>
        <script src="js/custom.js" type="text/javascript"></script>
        <script src="js/categories.js" type="text/javascript"></script>
    </body>
</html>
