<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý sản phẩm</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<!-- ======= Styles ====== -->
<link rel="stylesheet" href="<c:url value="/css/categoryAdmin.css"/>">
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
</head>
<body>
	<!-- =============== Navigation ================ -->
	<div class="container">
		<div class="navigation">
			<ul>
				<li><a href="#"> <span class="icon"> <ion-icon
								name="logo-apple"></ion-icon>
					</span> <span class="title">Admin</span>
				</a></li>

				<li><a href="/Shopee/admin"> <span class="icon"> <ion-icon
								name="home-outline"></ion-icon>
					</span> <span class="title">Trang chủ</span>
				</a></li>

				<li><a href="/Shopee/admin/customer"> <span class="icon">
							<ion-icon name="people-outline"></ion-icon>
					</span> <span class="title">Quản lí người dùng</span>
				</a></li>

				<li><a href="/Shopee/admin/category"> <span class="icon">
							<ion-icon name="chatbubble-outline"></ion-icon>
					</span> <span class="title">Quản lí danh mục</span>
				</a></li>

				<li><a href="/Shopee/admin/product"> <span class="icon">
							<ion-icon name="chatbubble-outline"></ion-icon>
					</span> <span class="title">Quản lí sản phẩm</span>
				</a></li>

				<li><a href="/Shopee/login"> <span class="icon"> <ion-icon
								name="log-out-outline"></ion-icon>
					</span> <span class="title">Đăng xuất</span>
				</a></li>
			</ul>
		</div>

		<!-- ========================= Main ==================== -->
		<div class="main">
			<div class="topbar">
				<div class="toggle">
					<ion-icon name="menu-outline"></ion-icon>
				</div>

				<div class="search">
					<label> <input type="text" placeholder="Search here">
						<ion-icon name="search-outline"></ion-icon>
					</label>
				</div>

				<div class="user">
					<img src="assets/imgs/customer01.jpg" alt="">
				</div>
			</div>

			<!-- ======================= Cards ================== -->
			<div class="cardBox">
				<a href="#addProductModal" class="btn btn-info" data-toggle="modal"><i
					class="material-icons">&#xE147;</i> <span>Thêm sản phẩm mới</span></a>
			</div>
			<div class="clearfix">
                            
                                <ul class="pagination">
                                <c:if test="${tag > 1}">
								<li class="page-item disabled"><a href="product?index=${tag-1}">Previous</a></li>
							</c:if>
							<c:if test="${endPage < 10}">
								<c:forEach begin="1" end="${endPage}" var="i">
									<li class="page-item ${tag == i?"active":""}"><a href="product?index=${i}" class="page-link">${i}</a></li>
								</c:forEach>
							</c:if>

							<c:if test="${endPage >= 10}">
								<c:if test="${tag <= 4}">
									<c:forEach begin="1" end="5" var="i">
										<li class="page-item ${tag == i?"active":""}"><a href="product?index=${i}" class="page-link ${tag == i?"active":""}">${i}</a></li>
									</c:forEach>
									<li class="page-item"><span
										class="page-link">...</span></li>
									<c:forEach begin="${endPage}" end="${endPage}" var="i">
										<li class="page-item ${tag == i?"active":""}"><a href="product?index=${i}" class="page-link ${tag == i?"active":""}">${i}</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${tag > 4 && tag < endPage - 4}">

									<li class="page-item ${tag == i?"active":""}"><a href="product?index=1" class="page-link ${tag == i?"active":""}">1</a></li>

									<li class="page-item"><span
										class="page-link">...</span></li>
									<c:forEach begin="${tag - 1}" end="${tag + 2}" var="i">
										<li class="page-item ${tag == i?"active":""}"><a href="product?index=${i}" class="page-link ${tag == i?"active":""}">${i}</a></li>
									</c:forEach>
									<li class="page-item"><span
										class="page-link">...</span></li>
									<c:forEach begin="${endPage}" end="${endPage}" var="i">
										<li class="page-item ${tag == i?"active":""}"><a href="product?index=${i}" class="page-link ${tag == i?"active":""}">${i}</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${tag == endPage - 4}">
									<li class="page-item ${tag == i?"active":""}"><a href="product?index=1" class="page-link ${tag == i?"active":""}">1</a></li>
									<li class="page-item"><span
										class="page-link">...</span></li>
									<c:forEach begin="${tag - 2}" end="${endPage}" var="i">
										<li class="page-item"><a href="product?index=${i}" class="page-link ${tag == i?"active":""}">${i}</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${tag > endPage - 4}">
									<li class="page-item ${tag == i?"active":""}"><a href="product?index=1" class="page-link ${tag == i?"active":""}">1</a></li>
									<li class="page-item"><span
										class="page-link">...</span></li>
									<c:forEach begin="${endPage - 5}" end="${endPage}" var="i">
										<li class="page-item ${tag == i?"active":""}"><a href="product?index=${i}" class="page-link">${i}</a></li>
									</c:forEach>
								</c:if>
							</c:if>


							<c:if test="${tag < endPage}">
								<li class="page-item"><a href="product?index=${tag+1}" class="page-link">Next</a></li>
							</c:if>
                                    
                                </ul>
                            </div>
			<!-- ================ Order Details List ================= -->
			<div class="details">
				<div class="recentOrders">


					<table>
						<thead>
							<tr>
								<td>Tên sản phẩm</td>
								<td>Hình ảnh</td>
								<td>Giá bán</td>
								<td>Số lượng trong kho</td>
								<td>Hành động</td>
							</tr>
						</thead>

						<tbody>

							<c:forEach items="${listP}" var="o">
								<tr>
									<td>${o.pName}</td>
									<c:url value="/image?fname=${o.pImage}" var="imgUrl"></c:url>
									<td><c:if test="${fn:contains(o.pImage, 'https')}">
											<img
												style="width: 150px; height: 150px; object-fit: contain;"
												src="${o.pImage}" alt=" ${o.pName}">
										</c:if> <c:if test="${fn:contains(o.pImage, 'product')}">
											<img
												style="width: 150px; height: 150px; object-fit: contain;"
												src="${imgUrl}" alt=" ${o.pName}">
										</c:if></td>
									<td>${o.pPrice}</td>
									<td>${o.pQuantity}</td>
									<td class="customerEdit"><a href=""
										onclick="editProductModal(${o.pId})" class="edit"
										data-toggle="modal"><i class="material-icons"
											data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a href=""
										onclick="deleteProductModal(${o.pId})" class="delete"
										data-toggle="modal"><i class="material-icons"
											data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>

				<!-- ================= New Customers ================ -->

			</div>
		</div>
	</div>
	<div id="addProductModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="#" method="post"
					enctype="multipart/form-data">
					<div class="modal-header">
						<h4 class="modal-title">Thêm sản phẩm</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Tên sản phẩm</label> <input name="name" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label for="idImage"> Chọn thêm hình ảnh </label> <select
								name="selectImage" id="idImage">

								<option value="file">Thêm bằng file</option>
								<option value="link">Thêm bằng url</option>

							</select>
							<!-- <label style="margin-top:10px">Ảnh đại diện</label> -->
							<input id="text" name="image1" type="text" class="form-control" />

							<input type="file" id="file" name="image" />
						</div>
						<div class="form-group">
							<label>Giá bán</label> <input name="price" type="text"
								class="form-control" required>
						</div>
						<div class="form-group">
							<label>Số lượng trong kho</label> <input name="quantity"
								type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Mô tả</label>
							<textarea name="description" class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Chọn danh mục</label> <select name="category"
								class="form-select" aria-label="Default select example">
								<c:forEach items="${listC}" var="o">
									<option value="${o.cId}">${o.cName}</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" formaction="<c:url value="/admin/product/add"/>" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editProductModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="product/edit" method="post"
					enctype="multipart/form-data">
					<div class="modal-header">
						<h4 class="modal-title">Chỉnh sửa sản phẩm</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<input id="editpId" name="id" hidden="" />
						</div>
						<div class="form-group">
							<label>Tên sản phẩm</label> <input id="editpName" name="name"
								type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<img id="editpImage" class="img-responsive" width="100px"
								src="/image?fname=image" alt=""> <label for="idImage">
								Chọn sửa hình ảnh </label> <select name="selectImage" id="idImage">

								<option value="file">Thêm bằng file</option>
								<option value="link">Thêm bằng url</option>

							</select>
							<!-- <label style="margin-top:10px">Ảnh đại diện</label> -->
							<input id="text" name="image1" type="text" class="form-control" />

							<input type="file" id="file" name="image" />
						</div>
						<div class="form-group">
							<label>Giá bán</label> <input id="editpPrice" name="price"
								type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Số lượng trong kho</label> <input id="editpQuantity"
								name="quantity" type="text" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Mô tả</label>
							<textarea id="editpDescription" name="description"
								class="form-control" required></textarea>
						</div>
						<div class="form-group">
							<label>Chọn danh mục</label> <select id="editpCategory"
								name="category" class="form-select"
								aria-label="Default select example">
								<c:forEach items="${listC}" var="o">
									<option value="${o.cId}">${o.cName}</option>
								</c:forEach>
							</select>
						</div>

					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-success" value="Edit">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteProductModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="product/delete" method="post">

					<div class="modal-header">
						<h4 class="modal-title">Xóa sản phẩm</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<input id="deletepId" name="id" value="0" hidden="">
					<div class="modal-body">
						<p>Bạn có chắc muốn xóa?</p>
						<p class="text-warning">
							<small>Hành động này không thể hoàn tác</small>
						</p>
					</div>
					<div class="modal-footer">
						<input onclick="returnProductIdValue()" type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- =========== Scripts =========  -->
	<script src="<c:url value="/js/admin.js"/>"></script>

	<!-- ====== ionicons ======= -->
	<script type="module"
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
	<script nomodule
		src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>