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
<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/RegisterManagerProduct.css"/>"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<title>Đăng kí thành người bán</title>

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
		<div class="content">
			<div class="content_fa">
				<div class="content_header">
					<span class="content_header_title"> Thông tin đăng ký Người
						bán sản phẩm </span>
					<!-- <span class="content_header_description">Quản lý thông tin hồ sơ để bảo mật tài khoản</span> -->
				</div>
				<h3 style="color:red;font-size:30px;">${mess}</h3>
				<form action="addShop" method="post" class="content_content" enctype="multipart/form-data">
					<div class="content_content_form">
						<p class="content_content_form_text">Tên Shop</p>
	
                            <div class="content_content_form_mess">
                                <input id="name"name="shopName"class="content_content_form_input_pass"type="text" placeholder=""/>
                                <small></small>
                            </div>
					</div>
					<div class="content_content_form">
						<p class="content_content_form_text">Ảnh đại diện</p>
						<div class="content_content_form_img">
							
						
							
							<input type="file" name="image"  />

						</div>

					</div>
					
					<div class="content_content_form">
						<p class="content_content_form_text">Mô tả</p>
						
                            <div class="content_content_form_mess">
                                <input id="description"name="description"class="content_content_form_input_pass"type="text" placeholder=""/>
                                <small></small>
                            </div>
					</div>
					<div class="content_content_form">
						<p  class="content_content_form_text">Địa chỉ</p>
						
                            <div class="content_content_form_mess">
                                <input id="address"name="address"class="content_content_form_input_pass"type="text" placeholder=""/>
                                <small></small>
                            </div>
                            
					</div>

					<div class="content_content_form">
							<label class="content_content_form_text">Danh mục sản phẩm</label> 
							<select  name="category"
								class="content_content_form_input_pass" aria-label="Default select example">
								<c:forEach items="${listC}" var="o">
									<option value="${o.cId}">${o.cName}</option>
								</c:forEach>
							</select>
						</div>

					<div class="content_content_btn">
						<button type="submit">Đăng kí</button>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script src="<c:url value="/js/registerManager.js"/>"></script>

</body>
</html>