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
	<link href="<c:url value="/css/MyAccount.css"/>" rel="stylesheet"
	type="text/css" />
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese" rel="stylesheet">
    <link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css' rel='stylesheet'>
    <title>Document</title>
</head>
<body>
    <div class="app">
       <jsp:include page="header.jsp"></jsp:include>
        <div class="content">
            <div class="content_fa">
            <div class="content_header">
                <span class="content_header_title">
                    Hồ Sơ Của Tôi
                </span>
                <span class="content_header_description">Quản lý thông tin hồ sơ để bảo mật tài khoản</span>
            </div>
            <div class="content_content">
                <div class="content_content_form">
                    <p class="content_content_form_text">Tên người dùng</p>
                    <input class="content_content_form_input"type="text" placeholder=""/>
                </div>
                <div class="content_content_form">
                    <p class="content_content_form_text">Số điện thoại</p>
                    <input class="content_content_form_input"type="text" placeholder=""/>
                </div>
                <div class="content_content_form">
                    <p class="content_content_form_text">Email</p>
                    <input class="content_content_form_input"type="text" placeholder=""/>
                </div>
                <div class="content_content_form">
                    <p class="content_content_form_text">Địa chỉ</p>
                    <input class="content_content_form_input"type="text" placeholder=""/>
                </div>
                <div class="content_content_form">
                    <p class="content_content_form_text">Giới tính</p>
                    <input type="radio" id="male" name="sex" value="male">
                    <label for="nam">Nam</label><br>
                    <input type="radio" id="female" name="sex" value="female">
                    <label for="female">Nữ</label><br>
                    <input type="radio" id="different" name="sex" value="different">
                    <label for="different">Khác</label>
                </div>
                <div class="content_content_btn">
                    <button>Lưu</button>
                </div>
            </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        </div>
    
</body>
</html>