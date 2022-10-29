<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopee</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />

 
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
	<link rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
</head>
<body>
	<div class="app">
		<jsp:include page="header.jsp"></jsp:include>
		<div style="text-align:center; margin-bottom:10%; font-weight:bold" >
	<p style="text-transform: uppercase; text-align:center;font-size:35px; margin-bottom: 10px">"${Result}"</p><br>
	
	
	<a href="/Shopee/home?index=1" style=" background:#FE980F; padding: 10px 20px;color:white; font-weight:bold; border-radius:10px">Quay lại trang chủ</a>
	
	</div>
		
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
		<script src="<c:url value="/js/home.js"/>"></script>
	
</body>
</html>