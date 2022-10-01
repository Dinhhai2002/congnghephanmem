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
            <div class="modal__overlay"></div>
            <div class="modal__body">
	<form action="login" method="get" class="authForm">
                    <div class="authForm__body">
                        <div class="authForm__header">
                            <h3 class="authForm__heading">
                                Đăng Nhập
                            </h3>
                            <a href="/Shopee/register" class="authForm__switch-btn">
                                Đăng Ký
                            </a>
                        </div>
                        <div class="authForm__form">
                            <div class="authForm__group">
                                <input name="username" type="text" class="authForm__input" placeholder="Nhập tên tài khoản">
                            </div>
                            <div class="authForm__group">
                                <input name="password" type="password" class="authForm__input" placeholder="Nhập mật khẩu">
                            </div>
                        </div>
                        <div class="authForm__policy">
                            <div class="authForm__help">
                                <a href="/Shopee/forgotPassword" class="authForm__help-link authForm__help-forgot">
                                    Quên Mật Khẩu
                                </a>
                                <span class="authForm__help-separate"></span>
                                <a href="" class="authForm__help-link">
                                    Cần Trợ Giúp?
                                </a>
                            </div>
                        </div>
                        <div class="authForm__controls">
                            <button class="btn btn-hover">TRỞ LẠI</button>
                            <button type="submit" class="btn btn--primary ml-8">ĐĂNG NHẬP</button>
                        </div>
                    </div>
                    <div class="authForm__social">
                        <a href="#" class="btn btn__social social__icon-fb">
                            
                            <i class='authForm__social-icon bx bxl-facebook-circle' ></i>
                            <span>
                                Đăng nhập Facebook
                            </span>
                        </a>
                        <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/Shopee/logingoogle&response_type=code
                        &client_id=965552027153-4qmaigfiko3ajcldouedsj1h9kts562i.apps.googleusercontent.com&approval_prompt=force" class="btn btn__social social__icon-gg">
                            <i class='authForm__social-icon bx bxl-google' ></i>
                            <span>
                                Đăng nhập Google
                            </span>
                        </a>
                    </div>
                </form>
                </div>
                </div>
</body>
</html>