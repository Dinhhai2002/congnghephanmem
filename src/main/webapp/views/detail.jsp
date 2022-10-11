<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<link href="<c:url value="/css/details.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
	




</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="margin-top: 20px;" class="container">
		<div class="row">
			<div class="col-sm-3">
				<nav class="category">
					<h3 class="category__heading">
						<a class="category__heading-icon" href=""><i
							class='bx bx-list-ul'></i></a> Danh mục
					</h3>
					<ul class="category-list">
						<!-- category-item-active -->
						<c:forEach items="${listCC}" var="o">
							<li class="category-item ${tag==o.cId?"active":""}"><a
								href="category?cid=${o.cId}" class="category-item_link">${o.cName}</a></li>
						</c:forEach>

					</ul>
				</nav>
				<!-- <div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">Last
						product</div>
					<div class="card-body">
						<img class="img-fluid"
							src="data:image/jpeg;base64,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" />
						<h5 class="card-title">Giày adidas</h5>
						<p class="card-text">vừa bền vừa đẹp</p>
						<p class="bloc_left_price">900 $</p>
					</div>
				</div> -->
			</div>
			<div class="col-sm-9">
				<div class="container">
					<div class="card">
						<div class="row">
							<aside class="col-sm-5 border-right">
								<article class="gallery-wrap">
									<img class="gallery-wrap-img" src="${p.pImage}"
										alt="${p.pName}">

								</article>
								<!-- gallery-wrap .end// -->
							</aside>
							<aside class="col-sm-7">
								<article style="font-size:20px"class="card-body p-5">
									<h3 class="title mb-3">${p.pName}</h3>

									<p class="price-detail-wrap">
										<span class="price h3 text-warning"> <span
											class="currency"></span><span class="num">${p.pPrice}</span>
										</span>
										<!--<span>/per kg</span>-->
									</p>
									<!-- price-detail-wrap .// -->
									<dl class="item-property">
										<dt>Description</dt>
										<dd>
											<p>${p.pDescription}</p>
										</dd>
									</dl>
									<!--                                        <dl class="param param-feature">
                                            <dt>Model#</dt>
                                            <dd>12345611</dd>
                                        </dl>   item-property-hor .// 
                                        <dl class="param param-feature">
                                            <dt>Color</dt>
                                            <dd>Black and white</dd>
                                        </dl>   item-property-hor .// 
                                        <dl class="param param-feature">
                                            <dt>Delivery</dt>
                                            <dd>Russia, USA, and Europe</dd>
                                        </dl>   item-property-hor .// -->

									<hr>
									<div class="row">
										<div class="col-sm-5">
											<dl class="param param-inline">
												<dt>Quantity:</dt>
												<div class="model_quantity_number">         									
												<a class="model_quantity_number_remove" 
												href="detail?pId=${p.pId}&quantity=${quantity}&action=sub"><i
														class='bx bx-minus'></i></a>
														
													<p class="model_quantity_number_quan">${quantity}</p>
													<a class="model_quantity_number_add" 
													href="detail?pId=${p.pId}&quantity=${quantity}&action=add"><i
														class='bx bx-plus'></i></a>
													
												</div>
											</dl>
											<!-- item-property .// -->
										</div>
										<!-- col.// -->

									</div>
									<!-- row.// -->
									<hr>
									<a style="padding-top: 8px;border: 1px solid red;"href="#" class="btn btn-lg btn-primary text-uppercase">
										Buy now </a> <a style="padding-top: 8px;border: 1px solid red;" 
										href="/Shopee/member/cart-add?pId=${p.pId}&quantity=${quantity}"
										class="btn btn-lg btn-outline-primary text-uppercase"> <i
										class="fas fa-shopping-cart"></i> Add to cart
									</a>
								</article>
								<!-- card-body.// -->
							</aside>
							<!-- col.// -->
						</div>
						<!-- row.// -->
					</div>
					<!-- card.// -->


				</div>
			</div>
		</div>
	</div>
	<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
	<%--  <script src="<c:url value="/js/detail.js"/>"></script> --%>
</body>
</html>
