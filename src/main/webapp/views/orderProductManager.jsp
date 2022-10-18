<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Trang người bán</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- <link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">      -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/ManagerProduct.css"/>" rel="stylesheet"
	type="text/css" />
	
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
                
                  
                    <div class="col l-12 lo-12 m-12 c-12">
                       
                        <div class="table-wrapper">
                             <div class="table-title">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h2 class="table-title-header" >
                                            Đơn Hàng của shop
                                        </h2>
                                    </div>
                                    <div class="col-sm-6 btn-add">
                                        <a href="#addEmployeeModal" class="btn btn-info"
                                            data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Quản lý sản phẩm</span></a>
                                                
                                                
                        
                                    </div>
                                    
                                </div>
                            </div> 
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                       
                                       
                                        <th>Tên sản phẩm</th>
                                        <th>hình ảnh</th>
                                        <th>Giá</th>
                                        <th>Tình trạng đơn hàng</th>
                                        <th>Xác nhận</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="o">
                                        <tr style="margin:8px 0;">
                                            
                                            
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="./assets/img/cart_item/item.jpeg">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                               Đã giao hàng
                                            </td>
                                            <td class="submit"><a href="">Nhận đơn</a></td>
                                        </tr>
                                        <tr>
                                            
                                           
                                            <td>Giày adidas</td>
                                            <td>
                                                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnAMhxybe3Dj4npaJLC5bmTXxLah9b-owEoQ&usqp=CAU">
                                            </td>
                                            <td>900 $</td>
                                            <td>
                                               Đã giao hàng
                                            </td>
                                            <td class="submit"><a href="">Nhận đơn</a></td>
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
                
                            <div style="text-align:center;" class="home-product-shipping">
                                <img src="../assets/img/null.png" alt="">
                                <p>Chưa có đơn hàng</p>
                            </div>  
                       
                    </div>
                    
                        
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
	
	</div>
	
	<script src="<c:url value="/js/home.js"/>"></script>
	
	<script>
		$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});
	</script>
</body>
</html>