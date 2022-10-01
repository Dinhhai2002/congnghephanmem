<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>

</head>
<style>
/* .bg-light{
            background-color:var(--primary-color)!important;
            color:#fff;
            margin-top:8px;
        } */
.header__cart {
	width: 140px;
	margin-right: 8px;
}

.header__cart-wrap {
	color: #fff;
	font-size: 20px !important;
	font-weight: 600;
}

.header__cart-wrap::before {
	content: "";
	display: block;
	position: absolute;
	width: 4px;
	height: 26px;
	background-color: #FB9086;
	top: 50%;
	left: -10px;
	transform: translateY(-50%);
}
</style>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="shopping-cart">
		<div class="px-4 px-lg-0">

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Xóa</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="o">
											<tr>
												<th scope="row">
													<div class="p-2">
														<img src="${o.image}" alt="" width="70"
															class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">
																<a href="#" class="text-dark d-inline-block">${o.name}</a>
															</h5>
															<span class="text-muted font-weight-normal font-italic"></span>
														</div>
													</div>
												</th>
												<td class="align-middle"><strong>${o.price}</strong></td>
												<td class="align-middle"><a href="#"><button
															class="btnSub">-</button></a> <strong>${o.amount}</strong> <a
													href="#"><button class="btnAdd">+</button></a></td>
												<td class="align-middle"><a href="#" class="text-dark">
														<button
															style="background-color: var(- -primary-color) !important; padding: 8px 12px"
															type="button" class="btn btn-danger">Delete</button>
												</a></td>
											</tr>
											<tr>
												<th scope="row">
													<div class="p-2">
														<img src="${o.image}" alt="" width="70"
															class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">
																<a href="#" class="text-dark d-inline-block">${o.name}</a>
															</h5>
															<span class="text-muted font-weight-normal font-italic"></span>
														</div>
													</div>
												</th>
												<td class="align-middle"><strong>${o.price}</strong></td>
												<td class="align-middle"><a href="#"><button
															class="btnSub">-</button></a> <strong>${o.amount}</strong> <a
													href="#"><button class="btnAdd">+</button></a></td>
												<td class="align-middle"><a href="#" class="text-dark">
														<button
															style="background-color: var(- -primary-color) !important; padding: 8px 12px"
															type="button" class="btn btn-danger">Delete</button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div style="display: flex; justify-content: center;"
						class="row py-5 p-4 bg-white rounded shadow-sm">
						<div class="col-lg-4">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Phương
								thức thanh toán</div>
							<div class="p-4">
								<select name="" id="">
									<option value="">Thanh toán khi nhận hàng</option>
									<option value="">Thanh toán online</option>
								</select>
							</div>
						</div>
						<div style="box-shadow: 0 3px 10px 0 rgb(0 0 0/ 14%);"
							class="col-lg-6">
							<div
								style="font-size: 16px; text-align: center; margin-top: 8px; background-color: var(- -primary-color) !important; color: #fff;"
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
								tiền</div>
							<div class="p-4">
								<ul class="list-unstyled mb-4">
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng tiền hàng</strong><strong>100
											$</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Phí vận chuyển</strong><strong>Free
											ship</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">VAT</strong><strong>10 $</strong></li>
									<li class="d-flex justify-content-between py-3 border-bottom"><strong
										class="text-muted">Tổng thanh toán</strong>
										<h5 class="font-weight-bold">110 $</h5></li>
								</ul>
								<a href="buy"
									style="font-size: 20px; background-color: var(- -primary-color);"
									class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>

</html>
</html>
