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
            
            <div class="auth-form">
                <div class="auth-form__container">
                    <div class="auth-form__header">
                        <h3 class="auth-form__heading">
                            Đăng kí
                        </h3>
                        <span class="auth-form__switch-btn">Đăng nhập</span>
    
                    </div>
                    <div class="auth-form__form">
                        <div class="auth-form__group">
                            <input type="text" class="auth-form__input " placeholder="Nhập UserName">
                        </div>
                        <div class="auth-form_group">
                            <input type="password" class="auth-form__input" placeholder="Mật khẩu của bạn" >
                        </div>
                        <div class="auth-form_group">
                            <input type="password" class="auth-form__input" placeholder="Nhập lại mật khẩu" >
                        </div>
                        <div class="auth-form__group">
                            <input type="text" class="auth-form__input " placeholder="Email của bạn">
                        </div>
                        <div class="auth-form__group">
                            <input type="text" class="auth-form__input " placeholder="Số điện thoại">
                        </div>
                        
                    </div>
                    <div class="auth-form__aside">
                        <p class="auth-form__policy-text">
                            Bằng việc đăng kí,bạn đã đồng ý với F8-shop về
                            <a href="" class="auth-form__text-link">Điều khoản dịch vụ</a> &
                            <a href="" class="auth-form__text-link">Chính sách bảo mật</a>
                        </p>
                    </div>
                    <div class="auth-form__controls">
                        <button class="btn auth-form__controls-backs btn-normal">TRỞ LẠI</button>
                        <button class="btn btn-primary">ĐĂNG KÝ</button>
                    </div>
                </div>
                <div class="auth-form__socials">
                    <a href="" class="auth-form__socials-facebook btn btn--size-s btn--with-icon">
                        <i class='auth-form__socials-icon bx bxl-facebook-circle'></i>
                        <span class="auth-form__socials-title">
                            Kết nối với Facebook
                        </span>
                    </a>
                    <a href="" class="auth-form__socials-google btn btn--with-icon">
                        <i class='auth-form__socials-icon fa-brands bx bxl-google'  ></i>
                        <span class="auth-form__socials-title">
                            Kết nối với Google
                        </span>
                        
                    </a>
                </div>
            </div> 


        </div> 
    </div> 
</body>
</html>