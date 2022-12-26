<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trang đơn mua</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
	integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/storeProduct.css"/>" rel="stylesheet"
	type="text/css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="/fontawesome/css/all.min.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<style type="text/css">
.footer-logo-background {
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

				<!-- Body -->
				<div class="row sm-gutter body-content">
					<div class="col m-12 c-12 search-item-result-on-mb-tb hide-on-pc">
						<ul onclick="myMobileFunction(event)" class="row no-gutters search-item-result-on-mb-tb-list">
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item">
								<!-- border-primary color-primary --> <a href="#" onclick="purchase(this)"
								class="search-item-result-on-mb-tb-link category-list__item-link-highlight">
									<span class="search-item-result-on-mb-tb-text"> Tất cả </span>
									<span class="separate"></span>
							</a>
							</li>
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="#" onclick="purchase(this)" class="search-item-result-on-mb-tb-link "> <span
									class="search-item-result-on-mb-tb-text"> Chờ xác nhận <span
										class="separate"></span>
								</span>
							</a></li>
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="#" onclick="purchase(this)" class="search-item-result-on-mb-tb-link"> <span
									class="search-item-result-on-mb-tb-text"> Chờ lấy hàng <span
										class="separate"></span>
								</span>
							</a></li>
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="#" onclick="purchase(this)" class="search-item-result-on-mb-tb-link"> <span
									class="search-item-result-on-mb-tb-text"> Đã giao <span
										class="separate"></span>
								</span>
							</a></li>
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="#" onclick="purchase(this)" class="search-item-result-on-mb-tb-link"> <span
									class="search-item-result-on-mb-tb-text"> Đang giao <span
										class="separate"></span>
								</span>
							</a></li>
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="#" onclick="purchase(this)" class="search-item-result-on-mb-tb-link"> <span
									class="search-item-result-on-mb-tb-text"> Đã hủy <span
										class="separate"></span>
								</span>
							</a></li>

						</ul>
					</div>


					<div class="col l-2 lo-2 hide-on-mb-tb">
						<div class="category-list">
							<h2 class="category-list__title">
								<a href="#" class="category-list__title-link"> <i
									class="category-list__title-icon fas fa-bars"></i> <span>Tất
										cả danh mục</span>
								</a>
							</h2>
							<ul onclick="myFunction(event)" class="category-list__list">

								<li class="category-list__item"><a href="#"
									onclick="purchase(this)"
									class="category-list__item-link category-list__item-link-highlight">
										<i class="category-list__item-icon fas fa-caret-right"></i>
										Tất cả
										 <!-- <span class="number">3</span> -->
								</a></li>
								<li class="category-list__item"><a href="#"
									onclick="purchase(this)" class="category-list__item-link">
										<i class="category-list__item-icon fas fa-caret-right"></i>Chờ
										xác nhận
										
									
										 
								</a><c:choose>
									<c:when test="${choxacnhan>'0'}">
										<span class="number">${choxacnhan}</span>
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
									</c:choose></li>
								<li class="category-list__item"><a href="#"
									onclick="purchase(this)" class="category-list__item-link">
										<i class="category-list__item-icon fas fa-caret-right"></i>Chờ
										lấy hàng
										 
								</a><c:choose>
									<c:when test="${cholayhang>'0'}">
										<span class="number">${cholayhang}</span>
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
									</c:choose></li>
								<li class="category-list__item"><a href="#"
									onclick="purchase(this)" class="category-list__item-link">
										<i class="category-list__item-icon fas fa-caret-right"></i>Đang
										giao
										 
								</a><c:choose>
									<c:when test="${danggiao>'0'}">
										<span class="number">${danggiao}</span>
									</c:when>
									<c:otherwise>
										
									</c:otherwise>
									</c:choose></li>
								<li class="category-list__item"><a href="#"
									onclick="purchase(this)" class="category-list__item-link">
										<i class="category-list__item-icon fas fa-caret-right"></i>Đã
										giao
										 	
								</a></li>
								<li class="category-list__item"><a href="#"
									onclick="purchase(this)" class="category-list__item-link">
										<i class="category-list__item-icon fas fa-caret-right"></i>Đã
										hủy
										<!--  <span class="number">3</span> -->
								</a></li>
							</ul>
						</div>
					</div>


					<div class="col l-10 lo-10 m-12 c-12 active">
						
						<div class="table-wrapper">
							<table id="myTable" class="table table-striped table-hover">
								<thead>
									<tr>
										<th>Tên sản phẩm</th>
										<th>Hình ảnh</th>
										<th>Giá</th>
										<th>Tình trạng đơn hàng</th>
										<th>Chi tiết đơn hàng</th>
									</tr>

								</thead>

								<tbody>
									<c:forEach items="${listO}" var="o">
										<tr style="margin: 8px 0;">
											<td>${o.product.pName}</td>
											<c:url value="/image?fname=${o.product.pImage}" var="imgUrl"></c:url>
											<td>
											<c:if test="${fn:contains(o.product.pImage, 'https')}">
													<img src="${o.product.pImage}" alt=" ${o.product.pName}" style="width: 90px; height: 90px;">
												</c:if>
												<c:if test="${fn:contains(o.product.pImage, 'product')}">
													<img src="${imgUrl}" alt=" ${o.product.pName}" style="width: 90px; height: 90px;">
												</c:if>
												</td>
											<td><fmt:formatNumber
														type="number" pattern="#,###"
														value="${o.totalPrice}"></fmt:formatNumber>₫</td>
											<c:set var = "s" value = "${o.status.idStatus}"/>
											<c:choose>
											<c:when test="${s!=1 and s!=7}">
												<td>${o.status.nameStatus}</td>
											</c:when>
												<c:when test="${s==1 or s==7}">
													<td>Chờ xác nhận</td>
													<td><button id="orderStatus" onclick="editStatus(this)" value="${o.id}">Hủy đơn</button></td>													
												</c:when>
												<c:when test="${s==4}">
													<td><button id="orderStatus" onclick="editStatus(this)" value="${o.id}">Đã nhận được hàng</button></td>													
												</c:when>
												<c:when test="${s==9 or s==5}">
													<td><button id="orderStatus" onclick="editStatus(this)" value="${o.product.pId}">Mua lại</button></td>																										
												</c:when>
											</c:choose>

											<td>
                                               <h3 class="detail">Xem
                                                <ul class="navbarItem__user-list-detail">
                                                    <li class="navbarItem__user-item">
                                                        <a href="#" class="navbarItem__user-link">
                                                            Tên shop: ${o.order.shop.shopName}
                                                        </a>
                                                    </li>
                                                    <li class="navbarItem__user-item">
                                                        <a href="#" class="navbarItem__user-link">
                                                            Địa chỉ shop: ${o.order.shop.shopAddress}
                                                        </a>
                                                    </li>
                                                    <li class="navbarItem__user-item">
                                                        <a href="#" class="navbarItem__user-link">
                                                            Địa chỉ nhận hàng: ${o.order.uAddress}
                                                        </a>
                                                    </li>
                                                </ul>
                                               </h3>
                                               
                                             </td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>



						<c:choose>
							<c:when test="${empty listO}">
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
			</div>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script src="<c:url value="/js/home.js"/>"></script>
	<script src="<c:url value="/js/Shipper.js"/>"></script>
	<script src="<c:url value="/js/orderpurchase.js"/>"></script>
</body>
</html>