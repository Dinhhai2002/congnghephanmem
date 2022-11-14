<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link href="<c:url value="/css/changePassword.css"/>" rel="stylesheet"
	type="text/css" />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <title>Đổi mật khẩu</title>
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
                                <a href="" class="category-list__title-link">
                                    <i class="category-list__title-icon fas fa-bars"></i>
                                    <span>Tất cả danh mục</span>
                                </a>
                            </h2>
                            <ul class="category-list__list">
                                
                               <li class="category-list__item "><a href="/Shopee/myAccount"
									class="category-list__item-link  ">
										<i class="category-list__item-icon fas fa-caret-right"></i>
										Tài khoản cá nhân
								</a></li>
								<c:if test="${empty sessionScope.acc.uPassword}">
								<li hidden class="category-list__item "><a href="/Shopee/changePassword"
									class="category-list__item-link category-list__item-link-highlight ">
										<i class="category-list__item-icon fas fa-caret-right"></i>
										Đổi mật khẩu
								</a></li>
								</c:if>
								<c:if test="${not empty sessionScope.acc.uPassword}">
								<li class="category-list__item "><a href="/Shopee/changePassword"
									class="category-list__item-link category-list__item-link-highlight ">
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
                             <form action="changePassword" method="post" class="content_fa">
                                    <div class="content_header">
                                        <span class="content_header_title">
                                            Đổi Mật Khẩu
                                        </span>
                                        <span class="content_header_description">Để bảo mật tài khoản, vui lòng không chia sẻ mật khẩu cho người khác</span>
                                    </div>
                                    <div class="content_content">
                                    <h3 style="color:red;">${sessionScope.mess}</h3>
                                        <div class="content_content_form">
                                            <p class="content_content_form_text">Mật khẩu hiện tại</p>
                                            <input name="id" value="${sessionScope.acc.uId}" type="text" hidden />
                                            <div class="content_content_form_mess">
                                            
                                                <input id="oldPass" name="oldPass" class="content_content_form_input_pass" type="password" placeholder=""/>
                                                <small></small>
                                            </div>
                                        </div>
                                        <div class="content_content_form">
                                            <p class="content_content_form_text">mật khẩu mới</p>
                                            <div class="content_content_form_mess">
                                                <input id="pass" name="pass" class="content_content_form_input_pass" type="password" placeholder="" pattern="[A-Za-z0-9]{5,}" title="không đúng"/>
                                                <small></small>
                                            </div>
                                            
                                        </div>
                                        <div class="content_content_form">
                                            <p class="content_content_form_text">Xác nhận mật khẩu</p>
                                            <div class="content_content_form_mess">
                                                <input id="repass" name="repass" class="content_content_form_input_pass" type="password" placeholder=""/>
                                                <small></small>
                                            </div>
                                            
                                        </div>
                                        
                                       
                                        
                                       
                                       
                                        <div class="content_content_btn">
                                            <button type="submit">Xác nhận</button>
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
         <script src="<c:url value="./js/changePasswordAccount.js"/>"></script>
</body>
</html>