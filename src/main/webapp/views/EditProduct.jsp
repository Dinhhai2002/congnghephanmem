<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
											<img class="img-responsive" width="100px" src="${imgUrl}"
												alt=""> <label style="margin-top: 10px">Ảnh sản phẩm</label> <input type="file" name="image" />
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
										<a href="/Shopee/shop-manager" type="button"
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
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>