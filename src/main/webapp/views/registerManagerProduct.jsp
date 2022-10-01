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
		<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/RegisterManagerProduct.css"/>" rel="stylesheet"
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
                    Thông tin đăng ký Người bán sản phẩm
                </span>
                <!-- <span class="content_header_description">Quản lý thông tin hồ sơ để bảo mật tài khoản</span> -->
            </div>
            <div class="content_content">
                <div class="content_content_form">
                    <p class="content_content_form_text">Tên Shop</p>
                    <input class="content_content_form_input"type="text" placeholder=""/>
                </div>
                <div class="content_content_form">
                    <p class="content_content_form_text">ảnh đại diện</p>
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
                
                <div class="dropdown">
                    <span class="dropdown_item">Chọn mặt hàng bán</span>
                  <div class="dropdown-select">
                    <span class="dropdown-value">VietNam</span>
                    <span>
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        style="width: 20px; height: 20px"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                      >
                        <path
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          stroke-width="2"
                          d="M19 9l-7 7-7-7"
                        />
                      </svg>
                    </span>
                  </div>
                  <div class="dropdown-list">
                    <div class="dropdown-item">American</div>
                    <div class="dropdown-item">Canada</div>
                    <div class="dropdown-item">Australia</div>
                  </div>
                </div>
                
                <div class="content_content_btn">
                    <button>Đăng kí</button>
                </div>
            </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        </div>
    
</body>
</html>