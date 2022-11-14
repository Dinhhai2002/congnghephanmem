<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/MyAccount.css"/>" rel="stylesheet"
	type="text/css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<title>Tài khoản của tôi</title>

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


				<div class="shop-category-on-mb-tb hide-on-pc">
                    <h3 class="img-carousel__items-title">
                        Danh Mục
                    </h3>
                    <ul class="row no-gutters shop-category-on-mb-tb-list">
                        <li class="col m-3 c-4 shop-category-on-mb-tb-item">
                            <a href="/Shopee/myAccount" class="shop-category-on-mb-tb-item-link">
                               
                                <p class="shop-category-on-mb-tb-item-text">
                                    Tài khoản cá nhân
                                </p>
                            </a>
                           
                        </li>
                        <c:if test="${empty sessionScope.acc.uPassword}">
                        <li hidden class="col m-3 c-4 shop-category-on-mb-tb-item">
                            <a href="" class="shop-category-on-mb-tb-item-link">
                               
                                <p class="shop-category-on-mb-tb-item-text">
                                    Đổi mật khẩu
                                </p>
                            </a>
                           
                        </li>
                        </c:if>
                        <c:if test="${not empty sessionScope.acc.uPassword}">
                        <li  class="col m-3 c-4 shop-category-on-mb-tb-item">
                            <a href="/Shopee/changePassword" class="shop-category-on-mb-tb-item-link">
                               
                                <p class="shop-category-on-mb-tb-item-text">
                                    Đổi mật khẩu
                                </p>
                            </a>
                           
                        </li>
                        </c:if>
                        <li class="col m-3 c-4 shop-category-on-mb-tb-item">
                            <a href="/Shopee/member/purchase" class="shop-category-on-mb-tb-item-link">
                               
                                <p class="shop-category-on-mb-tb-item-text">
                                    Đơn mua
                                </p>
                            </a>
                           
                        </li>
                        
                    </ul>
                </div>

				<!-- Body -->
				<div class="row sm-gutter body-content">

					<div class="col l-2 lo-2 hide-on-mb-tb">
						<div class="category-list">
							<h2 class="category-list__title">
								<a href="" class="category-list__title-link"> <i
									class="category-list__title-icon fas fa-bars"></i> <span>Tất
										cả danh mục</span>
								</a>
							</h2>
							<ul class="category-list__list">

								<li class="category-list__item "><a href="/Shopee/myAccount"
									class="category-list__item-link category-list__item-link-highlight active">
										<i class="category-list__item-icon fas fa-caret-right"></i>
										Tài khoản cá nhân
								</a></li>
								<c:if test="${empty sessionScope.acc.uPassword}">
								<li hidden class="category-list__item "><a href="/Shopee/changePassword"
									class="category-list__item-link  ">
										<i class="category-list__item-icon fas fa-caret-right"></i>
										Đổi mật khẩu
								</a></li>
								</c:if>
								<c:if test="${not empty sessionScope.acc.uPassword}">
								<li class="category-list__item "><a href="/Shopee/changePassword"
									class="category-list__item-link  ">
										<i class="category-list__item-icon fas fa-caret-right"></i>
										Đổi mật khẩu
								</a></li>
								</c:if>
								<li class="category-list__item "><a href="/Shopee/member/purchase"
									class="category-list__item-link ">
										<i class="category-list__item-icon fas fa-caret-right"></i>
										Đơn mua
								</a></li>


								

							</ul>
						</div>


					</div>
					<div class="col l-10 lo-10 m-12 c-12">

						<div class="row sm-gutter search-item-result__items">
							<div class="col l-12 lo-12 ">
								<form action="myAccount" method="post" class="content_fa">
									<div class="content_header">
										<span class="content_header_title"> Hồ Sơ Của Tôi </span> <span
											class="content_header_description">Quản lý thông tin
											hồ sơ để bảo mật tài khoản</span>
									</div>
									<div class="content_content">
										<h3 style="color:red;">${mess}</h3>
										<div class="content_content_form">
											<p class="content_content_form_text">Tên Đăng nhập</p>
											<input name="id" value="${sessionScope.acc.uId}" type="text" hidden />
											<input name="usernameSession"value="${sessionScope.acc.uName}"
												class="content_content_form_input" type="text"
												placeholder="" hidden/>
												<input name="phoneNumberSession"value="${sessionScope.acc.uPhone}"
												class="content_content_form_input" type="text"
												placeholder="" hidden/>
											<input name="username"value="${sessionScope.acc.uName}"
												class="content_content_form_input" type="text"
												placeholder="" />
										</div>
										<div class="content_content_form">
											<p class="content_content_form_text">Tên</p>
											<input name="fullName" value="${sessionScope.acc.uFullName}"
												class="content_content_form_input" type="text"
												placeholder="" />
										</div>
										<div class="content_content_form">
											<p class="content_content_form_text">Số điện thoại</p>
											<input name="phoneNumber" value="${sessionScope.acc.uPhone}"class="content_content_form_input" type="text"
												placeholder="" />
										</div>
										<div class="content_content_form">
											<p class="content_content_form_text">Email</p>
											<input name="SessionEmail" value="${sessionScope.acc.uEmail}"class="content_content_form_input" type="text"
												placeholder="" hidden />
											<input name="email" value="${sessionScope.acc.uEmail}"class="content_content_form_input" type="text"
												placeholder="" />
											<!-- <a style="font-size:20px;color:red;"href="">Thêm</a> -->
										</div>
										
										<div class="content_content_form">
											<p class="content_content_form_text">Địa chỉ</p>
											<input name="address" value="${sessionScope.acc.uAddress}"class="content_content_form_input" type="text"
												placeholder="" />
										</div>
										
										<div class="content_content_btn">
											<button style="background-color:var(--primary);color:#fff;" type="submit">Lưu</button>
										</div>
									</div>
								</form>

							</div>

						</div>
					</div>
				</div>
			</div>
			</div>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
		<script src="<c:url value="/js/home.js"/>"></script>
</body>
</html>