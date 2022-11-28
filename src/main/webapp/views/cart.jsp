<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ hàng</title>
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" /> 
	<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/cart.css"/>" rel="stylesheet"
	type="text/css" />

<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<style type="text/css">
  .footer-logo-background{
  /* background: url("<c:url value="/img/bg-icon.png"/>"); */
  background: url("${pageContext.request.contextPath}/img/bg-icon.png");
  }
  </style>
</head>

<body>
	<div class="app">
        
	<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
            <div class="grid wide">
            <div class="row sm-gutter body-content">
                
                    <div class="col l-10 lo-10 m-12 c-12">
                       
                        <div class="table-wrapper">
                            <!-- <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h2>Manage <b>Product</b></h2>
                                    </div>
                                    
                                </div>
                            </div> -->
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                       
                                       
                                        <th>sản phẩm</th>
                                        <th>hình ảnh</th>
                                        <th>Giá</th>
                                        <th>số lượng</th>
                                        <th>số tiền</th>
                                        <th>Xóa</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${sessionScope.cart}" var="map">
                                        <tr style="margin:8px 0;">
                                            
                                            
                                            <td>${map.value.product.pName}</td>
                                            <td>
                                                <img src="${map.value.product.pImage}">
                                            </td>
<td>${map.value.product.pPrice}</td>
                                            
                                                <td class="align-middle">
                                                    <a href="/Shopee/member/cart-quantityincdec?action=sub&pId=${map.value.product.pId}"><button
                                                    class="btnSub">-</button></a> <strong>${map.value.count}</strong> <a
                                            href="/Shopee/member/cart-quantityincdec?action=add&pId=${map.value.product.pId}"><button class="btnAdd">+</button></a></td>
                                           
                                            <td>
                                                ${map.value.product.pPrice * map.value.count}
                                             </td>
                                            <td class="submit"><a href="/Shopee/member/cart-remove?pId=${map.value.product.pId}">Xóa</a></td>
                                        </tr>
                                        
                                        
                                    </c:forEach>
                                </tbody>
                            </table>
                           
                
                           
                       
                    </div>
                  	<c:choose>
							<c:when test="${empty sessionScope.cart}">
								<div style="text-align: center;" class="home-product-shipping">
									<img
										src="https://icons.veryicon.com/png/o/miscellaneous/contribution/empty-box-1.png"
										alt="" style="width: 90px; height: 90px;">
									<p>Chưa có đơn hàng</p>
								</div>
							</c:when>
							<c:otherwise>
								<div style="text-align: center;" class="home-product-shipping">

								</div>
							</c:otherwise>
						</c:choose>
                        
                    </div>
                    </div>
                    
                    
                    
                    <c:choose>
							<c:when test="${empty sessionScope.cart}">
								
							</c:when>
							<c:otherwise>
								 <div class="row sm-gutter body-content">
                       
                        <div class="col l-10 lo-10 m-12 c-12">
                    <h3 class="title">Thành tiền</h3>
                    <div class="p-4">
                        <ul class="list-unstyled mb-4">
                            <li class="list-item"><strong
                                class="text-muted">Tổng tiền hàng</strong>
                                <c:set var="total" value="${0}"/>
                                <c:forEach 
                                    items="${sessionScope.cart}" var="map">
                                    <c:set var="total"
                                    value="${total + map.value.product.pPrice * map.value.count }"/>
                                    </c:forEach>
<strong> 
                                 ${total}vnđ</strong></li>
                           <!--  <li class="list-item"><strong
                                class="text-muted">Phí vận chuyển</strong><strong>10000 vnđ</strong></li> -->
                           <!--  <li class="list-item"><strong
                                class="text-muted">VAT</strong><strong>10 $</strong></li> -->
                           <%--  <li class="list-item list-item-total"><strong
                                class="text-muted">Tổng tiền hàng</strong>
                                <h5 class="font-weight-bold">${total}vnđ</h5></li> --%>
                        </ul>
                        <a href="/Shopee/member/checkout"
                           class="btn_buy">Mua hàng</a>
                    </div>
                </div>
            </div>
							</c:otherwise>
						</c:choose>
                    

                   <%--  <div class="row sm-gutter body-content">
                       
                        <div class="col l-10 lo-10 m-12 c-12">
                    <h3 class="title">Thành tiền</h3>
                    <div class="p-4">
                        <ul class="list-unstyled mb-4">
                            <li class="list-item"><strong
                                class="text-muted">Tổng tiền hàng</strong>
                                <c:set var="total" value="${0}"/>
                                <c:forEach 
                                    items="${sessionScope.cart}" var="map">
                                    <c:set var="total"
                                    value="${total + map.value.product.pPrice * map.value.count }"/>
                                    </c:forEach>
                                <strong> 
                                 ${total}vnđ</strong></li>
                           <!--  <li class="list-item"><strong
                                class="text-muted">Phí vận chuyển</strong><strong>10000 vnđ</strong></li> -->
                           <!--  <li class="list-item"><strong
                                class="text-muted">VAT</strong><strong>10 $</strong></li> -->
                            <li class="list-item list-item-total"><strong
                                class="text-muted">Tổng tiền hàng</strong>
                                <h5 class="font-weight-bold">${total}vnđ</h5></li>
                        </ul>
                        <a href="/Shopee/member/checkout"
                           class="btn_buy">Mua hàng</a>
                    </div>
                </div>
            </div> --%>

      
    
    </div>
    </div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
		<script src="<c:url value="/js/home.js"/>"></script>
</body>

</html>
