<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chỉnh sửa sản phẩm</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">


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
<link href="<c:url value="/css/editProduct.css"/>" rel="stylesheet"
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
				<div class="row no-gutters">
					<div class="col l-12 lo-12 ">
						<div class="modal-dialog">
							<div class="modal-content">
								<form action="editP" method="post" enctype="multipart/form-data">
									<div class="modal-header">
										<h4 class="modal-title">Edit Product</h4>

									</div>
									<div class="modal-body">
										<h3 style="color: red;">${mess}</h3>
										<div class="form-group">
											<input value="${product.pId}" name="id" hidden="" />
										</div>
										
										<div class="form-group">
											<label>Tên sản phẩm</label> <input value="${product.pName}" name="name" type="text"
												class="form-control" required />
										</div>
										<div class="form-group form-group-col">
                                        <c:url value="/image?fname=${product.pImage}" var="imgUrl"></c:url>
                                        <c:if test="${fn:contains(product.pImage, 'https')}">
													<img src="${product.pImage}" alt=" ${product.pName}">
												</c:if>
												<c:if test="${fn:contains(product.pImage, 'product')}">
													<img src="${imgUrl}" alt=" ${product.pName}">
												</c:if>
                                            <label for="idImage">
                                                Chọn sửa hình ảnh
                                            </label>
                                            <select name="selectImage" id="idImage">
                                                
                                                  <option value="file">Thêm bằng file</option>
                                                  <option value="link">Thêm bằng url</option>
                                               
                                            </select>
                                            <!-- <label style="margin-top:10px">Ảnh đại diện</label> -->
                                            <input id="text" name="image1" type="text" class="form-control"/>
                                                
                                            <input type="file" id="file" name="image" /> 
                                    </div>

										<div class="form-group">
											<label>Giá sản phẩm</label> <input value="${product.pPrice}" name="price" type="text"
												class="form-control" required required />
										</div>
										<div class="form-group">
											<label>Mô tả sản phẩm</label>
											<textarea name="description" class="form-control">${product.pDescription}</textarea>
										</div>
										<div class="form-group">
											<label>Số lương nhập vào kho</label> <input value="${product.pQuantity}" name="quantity"
												type="text" class="form-control" required required />
										</div>
										<div class="form-group">
											<label>Danh mục sản phẩm</label> <select name="category"
												class="form-select" aria-label="Default select example">
												<c:forEach items="${listC}" var="o">
													<option ${product.category.cId==o.cId?"selected":""} value="${o.cId}">${o.cName}</option>
												</c:forEach>
											</select>
										</div>

									</div>
									<div class="modal-footer">
										<a href="/Shopee/admin/shop-manager" type="button"
											class="btn btn-default" data-dismiss="modal">Cancel</a> <input
											type="submit" class="btn btn-info" value="Save">
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	
	<script src="<c:url value="/js/managerProduct.js"/>"></script>
	<script src="<c:url value="/js/home.js"/>"></script>
</body>
</html>