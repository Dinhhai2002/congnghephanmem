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
<link href="<c:url value="/css/login.css"/>" rel="stylesheet"
	type="text/css" />
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
<title>Đăng nhập tài khoản</title>
</head>
<body>
	<div class="modal">
        <div class="modal__overlay">

        </div>
        <div class="modal__body"> 
            <!-- register form -->
            
            <form action="register" method="get" class="authForm">
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
                        <div class="authForm__group">
                            <input name="user" type="text" class="authForm__input" placeholder="Nhập tên người dùng">
                        </div>
                        <div class="authForm__group">
                            <input name="fullname" type="text" class="authForm__input" placeholder="Nhập họ tên đầy đủ">
                        </div>
                        
                        <div class="authForm__group">
                            <input name="pass" type="password" class="authForm__input" placeholder="Nhập mật khẩu">
                        </div>
                        <div class="authForm__group">
                            <input name="re_pass" type="password" class="authForm__input" placeholder="Nhập lại mật khẩu">
                        </div>
                        <div class="authForm__group">
                            <input name="email" type="text" class="authForm__input" placeholder="Nhập email của bạn">
                        </div>
                        <div class="authForm__group">
                            <input name="phoneNumber" type="text" class="authForm__input" placeholder="Nhập số điện thoại">
                        </div>
                        <div class="authForm__group">
                            <input name="address" type="text" class="authForm__input" placeholder="Nhập địa chỉ của bạn">
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
                        <button class="btn btn-hover">TRỞ LẠI</button>
                        <button class="btn btn--primary ml-8">ĐĂNG KÝ</button>
                    </div>
                </div>
                <div class="authForm__social">
                    <a href="#" class="btn btn__social social__icon-fb">
                        <i class="authForm__social-icon fab fa-facebook-square"></i>
                        <span>
                            Kết nối với Facebook
                        </span>
                    </a>
                    <a href="#" class="btn btn__social social__icon-gg">
                        <i class="authForm__social-icon fab fa-google"></i>
                        <span>
                            Kết nối với Google
                        </span>
                    </a>
                </div>
            </form>  


        </div> 
    </div> 
</body>
</html>