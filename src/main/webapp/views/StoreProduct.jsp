<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>trang đơn mua</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
    integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" /> 
	<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/storeProduct.css"/>" rel="stylesheet"
	type="text/css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="/fontawesome/css/all.min.css">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
rel='stylesheet'>
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
                
                <!-- Body -->
                <div class="row sm-gutter body-content">
                    <div class="col m-12 c-12 search-item-result-on-mb-tb hide-on-pc">
                        <ul class="row no-gutters search-item-result-on-mb-tb-list">
                            <li class="col m-3 c-3 search-item-result-on-mb-tb-item">
                                <!-- border-primary color-primary -->
                                <a href="#" class="search-item-result-on-mb-tb-link category-list__item-link-highlight ">
                                    <span class="search-item-result-on-mb-tb-text">
                                        Tất cả
                                    </span>
                                    <span class="separate"></span>
                                </a>
                            </li>
                            <li class="col m-3 c-3 search-item-result-on-mb-tb-item">
                                <a href="#" class="search-item-result-on-mb-tb-link ">
                                    <span class="search-item-result-on-mb-tb-text">
                                        chờ xác nhận
                                        <span class="separate"></span>
                                    </span>
                                </a>
                            </li>
                            <li class="col m-3 c-3 search-item-result-on-mb-tb-item">
                                <a href="#" class="search-item-result-on-mb-tb-link">
                                    <span class="search-item-result-on-mb-tb-text">
                                        Chờ lấy hàng
                                        <span class="separate"></span>
                                    </span>
                                </a>
                            </li>
                            <li class="col m-3 c-3 search-item-result-on-mb-tb-item">
                                <a href="#" class="search-item-result-on-mb-tb-link">
                                    <span class="search-item-result-on-mb-tb-text">
                                        Đã giao
                                        <span class="separate"></span>
                                    </span>
                                </a>
                            </li>
                            <li class="col m-3 c-3 search-item-result-on-mb-tb-item">
                                <a href="#" class="search-item-result-on-mb-tb-link">
                                    <span class="search-item-result-on-mb-tb-text">
                                        Đang giao
                                        <span class="separate"></span>
                                    </span>
                                </a>
                            </li>
                            <li class="col m-3 c-3 search-item-result-on-mb-tb-item">
                                <a href="#" class="search-item-result-on-mb-tb-link">
                                    <span class="search-item-result-on-mb-tb-text">
                                        Đã hủy
                                        <span class="separate"></span>
                                    </span>
                                </a>
                            </li>
                            
                        </ul>
                    </div>
                    <div class="col l-2 lo-2 hide-on-mb-tb">
                        <div class="category-list">
                            <h2 class="category-list__title">
                                <a href="#" class="category-list__title-link">
                                    <i class="category-list__title-icon fas fa-bars"></i>
                                    <span>Tất cả danh mục</span>
                                </a>
                            </h2>
                            <ul class="category-list__list">
                                
                                <li class="category-list__item ">
                                    <a href="#" class="category-list__item-link category-list__item-link-highlight">
                                        <i class="category-list__item-icon fas fa-caret-right"></i>
                                        Tất cả
                                    </a>
                                </li>
                                <li class="category-list__item ">
                                    <a href="#" class="category-list__item-link ">
                                        <i class="category-list__item-icon fas fa-caret-right"></i>
                                       Chờ xác nhận
                                    </a>
                                </li>
                                <li class="category-list__item ">
                                    <a href="#" class="category-list__item-link ">
                                        <i class="category-list__item-icon fas fa-caret-right"></i>
                                       chờ lấy hàng
                                    </a>
                                </li>
                                <li class="category-list__item ">
                                    <a href="#" class="category-list__item-link ">
                                        <i class="category-list__item-icon fas fa-caret-right"></i>
                                       Đã giao
                                    </a>
                                </li>
                                <li class="category-list__item ">
                                    <a href="#" class="category-list__item-link ">
                                        <i class="category-list__item-icon fas fa-caret-right"></i>
                                       Đang giao
                                    </a>
                                </li>
                                <li class="category-list__item ">
                                    <a href="#" class="category-list__item-link ">
                                        <i class="category-list__item-icon fas fa-caret-right"></i>
                                       Đã hủy
                                    </a>
                                </li>
                           
                               
                                

                               
                            </ul>
                        </div>




                      
                    </div>
                    <div class="col l-10 lo-10 m-12 c-12 active">
                       
                        <div class="table-wrapper">
                            <!-- <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h2>Manage <b>Product</b></h2>
                                    </div>
                                    
                                </div>
                            </div> -->
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                       
                                       
                                        <th>Tên sản phẩm</th>
                                        <th>hình ảnh</th>
                                        <th>Giá</th>
                                        <th>Tình trạng đơn hàng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="o">
                                        <tr style="margin:8px 0;">
                                            
                                            
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnAMhxybe3Dj4npaJLC5bmTXxLah9b-owEoQ&usqp=CAU">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                               Đã giao hàng
                                            </td>
                                        </tr>
                                        <tr>
                                            
                                           
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnAMhxybe3Dj4npaJLC5bmTXxLah9b-owEoQ&usqp=CAU">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                                Đang giao hàng
                                            </td>
                                        </tr>
                                        
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="clearfix">
                               
                                <ul class="pagination">
                                    <li class="page-item disabled"><a href="#">Previous</a></li>
                                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                                </ul>
                            </div>
                
                           
                       
                    </div>
                    <div style="text-align:center;" class="home-product-shipping">
                        <img src="../assets/img/null.png" alt="">
                        <p>Chưa có đơn hàng</p>
                    </div>
                        
                    </div>
                    <div class="col l-10 lo-10 m-12 c-12 ">
                       
                        <div class="table-wrapper">
                            <!-- <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h2>Manage <b>Product</b></h2>
                                    </div>
                                    
                                </div>
                            </div> -->
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                       
                                       
                                        <th>Tên sản phẩm</th>
                                        <th>hình ảnh</th>
                                        <th>Giá</th>
                                        <th>Tình trạng đơn hàng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="o">
                                        <tr style="margin:8px 0;">
                                            
                                            
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnAMhxybe3Dj4npaJLC5bmTXxLah9b-owEoQ&usqp=CAU">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                               Đã giao hàng
                                            </td>
                                        </tr>
                                        <tr>
                                            
                                           
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnAMhxybe3Dj4npaJLC5bmTXxLah9b-owEoQ&usqp=CAU">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                                Đang giao hàng
                                            </td>
                                        </tr>
                                        
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="clearfix">
                               
                                <ul class="pagination">
                                    <li class="page-item disabled"><a href="#">Previous</a></li>
                                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                                </ul>
                            </div>
                
                           
                       
                    </div>
                    <div style="text-align:center;" class="home-product-shipping">
                        <img src="../assets/img/null.png" alt="">
                        <p>Chưa có đơn hàng</p>
                    </div>
                        
                    </div>
                    <div class="col l-10 lo-10 m-12 c-12 ">
                       
                        <div class="table-wrapper">
                            <!-- <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h2>Manage <b>Product</b></h2>
                                    </div>
                                    
                                </div>
                            </div> -->
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                       
                                       
                                        <th>Tên sản phẩm</th>
                                        <th>hình ảnh</th>
                                        <th>Giá</th>
                                        <th>Tình trạng đơn hàng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="o">
                                        <tr style="margin:8px 0;">
                                            
                                            
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnAMhxybe3Dj4npaJLC5bmTXxLah9b-owEoQ&usqp=CAU">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                               Đã giao hàng
                                            </td>
                                        </tr>
                                        <tr>
                                            
                                           
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnAMhxybe3Dj4npaJLC5bmTXxLah9b-owEoQ&usqp=CAU">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                                Đang giao hàng
                                            </td>
                                        </tr>
                                        
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="clearfix">
                               
                                <ul class="pagination">
                                    <li class="page-item disabled"><a href="#">Previous</a></li>
                                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                                </ul>
                            </div>
                
                           
                       
                    </div>
                    <div style="text-align:center;" class="home-product-shipping">
                        <img src="../assets/img/null.png" alt="">
                        <p>Chưa có đơn hàng</p>
                    </div>
                        
                    </div>
                    <div class="col l-10 lo-10 m-12 c-12">
                       
                        
                        <div style="text-align:center;" class="home-product-shipping">
                            <img src="./assets/img/null.png" alt="">
                            <p>Chưa có đơn hàng</p>
                        </div>
                            
                        </div>
                        <div class="col l-10 lo-10 m-12 c-12">
                       
                        
                            <div style="text-align:center;" class="home-product-shipping">
                                <img src="./assets/img/null.png" alt="">
                                <p>Chưa có đơn hàng</p>
                            </div>
                                
                            </div>
                    <div class="col l-10 lo-10 m-12 c-12">
                
                
                        <div style="text-align:center;" class="home-product-shipping">
                            <img src="./assets/img/null.png" alt="">
                            <p>Chưa có đơn hàng</p>
                        </div>
                            
                        </div>
                </div>
            </div>
        </div>
    
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
 <script src="<c:url value="/js/home.js"/>"></script>
    <script src="<c:url value="/js/Shipper.js"/>"></script>
</body>
</html>