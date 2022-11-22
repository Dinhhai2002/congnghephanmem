<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/signUp.css"/>" rel="stylesheet"
	type="text/css" />
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
<title>Đăng ký tài khoản</title>
</head>
<body>
	 <div class="modal">
        <div class="modal__overlay">

        </div>
        <div class="modal__body"> 
            <!-- register form -->
            
            <form action="register" method="post" class="authForm">
                <div class="authForm__body">
                    <div class="authForm__header">
                        <h3 class="authForm__heading">
                            Đăng Ký
                        </h3>
                        <a href="/Shopee/login" class="authForm__switch-btn">
                            Đăng Nhập
                        </a>
                    </div>
                    <div class="authForm__form">
                    	<h3 style="color:red;">${mess}</h3>
                        <div class="authForm__group">
                            <input id="username"name="user" type="text" class="authForm__input" placeholder="Nhập tên người dùng" pattern="[A-Za-z0-9]{5,}" title="không đúng" >
                            <small></small>
                        </div>
                        <div class="authForm__group">
                            <input id="fullName"name="fullname" type="text" class="authForm__input" placeholder="Nhập họ tên đầy đủ" >
                            <small></small>
                        </div>
                        
                        <div class="authForm__group">
                            <input id="pass"name="pass" type="password" class="authForm__input" placeholder="Nhập mật khẩu" pattern="[A-Za-z0-9]{5,}" title="không đúng"  >
                            <small></small>
                        </div>
                        <div class="authForm__group">
                            <input id="repass"name="re_pass" type="password" class="authForm__input" placeholder="Nhập lại mật khẩu" >
                            <small></small>
                        </div>
                        <div class="authForm__group">
                            <input id="email"name="email" type="text" class="authForm__input" placeholder="Nhập email của bạn" >
                            <small></small>
                        </div>
                        <div class="authForm__group">
                            <input id="phoneNumber"name="phoneNumber" type="text" class="authForm__input" placeholder="Nhập số điện thoại" >
                            <small></small>
                        </div>
                        <div class="authForm__group">
                            <input id="address" name="address" type="text" class="authForm__input" placeholder="Nhập địa chỉ tỉnh của bạn" >
                            <small></small>
                        </div>
                        <div class="authForm__group">
                            <input id="address" name="fullAddress" type="text" class="authForm__input" placeholder="Nhập địa chỉ đầy đủ của bạn" >
                            <small></small>
                        </div>
                        
                    </div>
                    <div class="authForm__policy">
                        <p class="authForm__policy-text">
                            Bằng việc đăng ký, bạn đã đồng ý với Shopee về
                            <a href="#" class="authForm__policy-link">Điều khoản dịch vụ</a> &
                            <a href="#" class="authForm__policy-link">Chính sách bảo mật</a>
                        </p>
                    </div>
                    <div class="authForm__controls">
                        <a href="/Shopee/home?index=1"class="btn btn-hover">TRỞ LẠI</a>
                        <button type="submit"class="btn btn--primary ml-8">ĐĂNG KÝ</button>
                    </div>
                </div>
                <div class="authForm__social">
                
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/Shopee/logingoogle&response_type=code
                        &client_id=965552027153-4qmaigfiko3ajcldouedsj1h9kts562i.apps.googleusercontent.com&approval_prompt=force" class="btn btn__social social__icon-gg">
                        <img src="<c:url value="/img/g-normal.png"/>" alt="" class="authForm__social-img">
                        <span>
                            Kết nối với Google
                        </span>
                    </a>
                </div>
            </form>  


        </div> 
    </div> 
                <script src="<c:url value="./js/signUp.js"/>"></script>
</body>
</html>