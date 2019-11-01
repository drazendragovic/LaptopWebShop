<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="avds_container col-lg-9">

    <div class="section_title">Detalji narudžbe br. ${order.IDOrder}</div>
    <div class="details">
        <span class="date"><b>Datum:&nbsp;&nbsp;</b>${order.date}</span>
        <span class="line_border"></span>
        <span class="date"><b>Placanje:&nbsp;</b>${order.payementType.name}</span>
        <span class="line_border"></span>
        <span class="date"><b>Ukupan iznos:&nbsp;</b>${order.totalprice}</span>
    </div>

    <!-- Cart Info -->
    <div class="cart_info">
        <div class="container">
            <div class="row">
                <div class="col">
                    <!-- Column Titles -->
                    <div class="cart_info_columns clearfix">
                        <div class="cart_info_col cart_info_col_product">Product</div>
                        <div class="cart_info_col cart_info_col_price">Price</div>
                        <div class="cart_info_col cart_info_col_quantity">Quantity</div>
                        <div class="cart_info_col cart_info_col_total">Total</div>
                    </div>
                </div>
            </div>
            <div class="row cart_items_row">
                <div class="col">

                    <c:forEach items="${orderItems}" var="item">
                        <!-- Cart Item -->
                        <div class="cart_item d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start">
                            <!-- Name -->
                            <div class="cart_item_product d-flex flex-row align-items-center justify-content-start">
                                <div class="cart_item_image">
                                    <c:forEach items="${pictures}" var="pic">
                                        <c:if test="${pic.getPictureItemID().getIDItem() == item.getItemID().getIDItem()}">
                                            <div><img src="${pic.getPicPath()}" alt=""></div>
                                            </c:if>
                                        </c:forEach>
                                </div>
                                <div class="cart_item_name_container">
                                    <div class="cart_item_name"><a href="#">${item.itemID.name}</a></div>
                                </div>
                            </div>
                            <!-- Price -->
                            <div class="cart_item_price">Kn${item.price}</div>
                            <!-- Quantity -->
                            <div class="cart_item_quantity">${item.quantity}</div>
                            <!-- Total -->
                            <div class="cart_item_total">Kn${item.orderPrice}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>		
    </div>
</div>
