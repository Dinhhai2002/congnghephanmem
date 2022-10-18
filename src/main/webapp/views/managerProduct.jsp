<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp" %>
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
                               <h3 style="font-size: 30px; color: red;">${mess}</h3>
                                <div class="row">
                                    <div class="col-sm-6-shop">
                                        <a href="#"class="table-title-header-title" >
                                            Thông tin của shop
                                        </a>
                                        <div class="table-content">
                                            <div class="table-content-img">
                                                <img src="./assets/img/null.png" alt="">
                                            </div>
                                            <div class="table-content-container">
                                                <h3 class="table-content-container-name">
                                                    Shop niềm vui
                                                </h3>
                                                <p class="table-content-container-description">
                                                    Thật là tuyệt vời
                                                </p>
                                            </div>
                                        </div>
                                       
                                    </div>
                                   
                                    
                                </div>
                            </div> 
                           
                             <div class="table-title">
                               
                                <div class="row">
                                    <div class="col-sm-6">
                                        <a href="#"class="table-title-header" >
                                            Quản lý sản phẩm
                                        </a>
                                        <a href="#" class="table-title-header"
                                            data-toggle="modal"> 
                                            <span>Đơn hàng</span></a>
                                        <a href="#" class="table-title-header"
                                            data-toggle="modal"> 
                                            <span>Chỉnh sửa thông tin shop</span></a>
                                    </div>
                                    <div class="col-sm-6 btn-add">
                                        <a href="#addEmployeeModal" class="btn btn-info"
                                            data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Thêm sản phẩm mới</span></a>
                                                
                                                
                        
                                    </div>
                                    
                                </div>
                            </div> 
                            <table class="table table-striped table-hover">
                                <thead>
                                    <tr>
                                       
                                       
                                        <th>Tên sản phẩm</th>
                                        <th>hình ảnh</th>
                                        <th>Giá</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listP}" var="o">
                                        <tr style="margin:8px 0;">
                                            
                                            
                                            <td>${o.pName}</td>
                                            <c:url value="/image?fname=${o.pImage}" var="imgUrl"></c:url>
                                            <td>
                                            <c:if test="${fn:contains(o.pImage, 'https')}">
												<img src="${o.pImage}" alt=" ${o.pName}">
											</c:if>
											<c:if test="${fn:contains(o.pImage, 'product')}">
												<img src="${imgUrl}">
											</c:if>
                                                
                                            </td>
                                            <td>${o.pPrice} $</td>
                                            <td><a href="editP?id=${o.pId}" class="edit"
                                                data-toggle="modal"><i class='bx bxs-pencil'></i></a> 
                                                <a
                                                href="deleteP?id=${o.pId}" class="delete" data-toggle="modal"><i class='bx bx-trash'></i></a>
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
                
                            <div style="text-align:center;" class="home-product-shipping">
                                <img src="../assets/img/null.png" alt="">
                                <p>Chưa có đơn hàng</p>
                            </div>  
                       
                    </div>
                    
                    
                        
                    </div>
                </div>
            </div>
        </div>
	
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="addP" method="post" enctype="multipart/form-data">
					<div class="modal-header">
						<h4 class="modal-title">Thêm sản phẩm mới</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tên sản phẩm</label> <input name="name" type="text"
								class="form-control" required/>
						</div>
						<div class="form-group form-group-col">
                            
                            <img class="img-responsive" width="100px" src="./assets/img/avatar_user.jpeg"
                            alt="">
                            <label style="margin-top:10px">Ảnh sản phẩm</label> <input type="file" name="image" />
                            </div>
                           
						<div class="form-group">
							<label>Giá sản phẩm</label> <input name="price" type="text"
								class="form-control" required  required />
						</div>
						<div class="form-group">
							<label>Mô tả sản phẩm</label>
							<textarea name="description" class="form-control" ></textarea>
						</div>
						<div class="form-group">
							<label>Số lương nhập vào kho</label> <input name="quantity" type="text"
								class="form-control" required  required />
						</div>
						<div class="form-group">
							<label>Danh mục sản phẩm</label> <select name="category"
								class="form-select" aria-label="Default select example">
								<c:forEach items="${listC}" var="o">
									<option value="${o.cId}">${o.cName}</option>
								</c:forEach>
							</select>
						</div>

					</div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal"
                            value="Cancel"> <input type="submit" class="btn btn-info"
                            value="Save">
                    </div>
				</form>
			</div>
		</div>
	</div>
	
	
    <jsp:include page="footer.jsp"></jsp:include>
	</div>
	
	
	

	<script src="<c:url value="/js/managerProduct.js"/>"></script>
	<script src="<c:url value="/js/home.js"/>"></script>
	
</body>
</html>