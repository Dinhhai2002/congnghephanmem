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
<link href="<c:url value="/css/login.css"/>" rel="stylesheet"
	type="text/css" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap&subset=vietnamese"
	rel="stylesheet">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>
	<div class="app">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="app__container">
			<div class="grid">
				<div class="grid__row app__content">
					<div class="grid__column-2">
						<nav class="category">
							<h3 class="category__heading">
								<a class="category__heading-icon" href="#"><i
									class='bx bx-list-ul'></i></a> Danh mục
							</h3>
							<ul class="category-list">
								<!-- category-item-active -->
								<c:forEach items="${listCC}" var="o">
									<li class="category-item" ${tag==o.cateId?"active":""}><a
										href="category?cid=${o.cateId}" class="category-item_link">${o.cateName}</a></li>
								</c:forEach>

							</ul>
						</nav>
					</div>
					<div class="grid__column-10">
						<div class="home-filter">
							<span class="home-filter__label"> Sắp xếp theo </span>
							<button class="home-filter__btn btn">Phổ biến</button>
							<button class="home-filter__btn btn btn-primary">Mới
								nhất</button>
							<button class="home-filter__btn btn">Bán chạy</button>

							<div class="select-input">
								<span class="select-input__label">Giá</span> <a
									style="font-size: 2rem;" class="select-input__icon" href="#"><i
									class='bx bxs-chevron-down'></i></a>

								<!-- list option -->
								<ul class="select-input__list">
									<li class="select-input__item"><a href="#"
										class="select-input__link">Giá:Thấp đến cao</a></li>
									<li class="select-input__item"><a href="#"
										class="select-input__link">Giá:Cao đến thấp</a></li>
								</ul>
							</div>

							<div class="home-filter__page">
								<span class="home-filter__page-num"> <span
									class="home-filter__page-current">1</span> /14
								</span>

								<div class="home-filter__page-control">
									<a href="#"
										class="home-filter__page-btn home-filter__page-btn-disable">
										<i style="font-size: 2rem;"
										class='home-filter__page-icon bx bx-chevron-left'></i>

									</a> <a href="#" class="home-filter__page-btn"> <i
										style="font-size: 2rem;"
										class='home-filter__page-icon bx bx-chevron-right'></i>

									</a>
								</div>
							</div>
						</div>
						<div class="home-product">
							<div class="grid__row">
								<c:forEach items="${listP}" var="o">

									<div class="grid__column-2-4">
										<a class="home-product-item" href="#">
											<div class="home-product-item__img"
												style="background-image: url(${o.pImage});"></div>
											<h4 class="home-product-item__name">${o.pName}</h4>
											<div class="home-product-item__price">
												<span class="home-product-item__price-old">1.200.000đ</span>
												<span class="home-product-item__price-current">${o.pPrice}</span>
											</div>
											<div class="home-product-item__action">
												<!-- home-product-item__like--liked -->
												<span
													class="home-product-item__like home-product-item__like--liked ">
													<i class='home-product-item__like-icon-empty bx bxs-heart'></i>
													<i class='home-product-item__like-icon-fill bx bxs-heart'></i>


												</span>
												<div class="home-product-item__rating">
													<i class='home-product-item__star-gold bx bxs-star'></i> <i
														class='home-product-item__star-gold bx bxs-star'></i> <i
														class='home-product-item__star-gold bx bxs-star'></i> <i
														class='home-product-item__star-gold bx bxs-star'></i> <i
														class="bx bxs-star"></i>
												</div>
												<span class="home-product-item__sold">Đã bán 88</span>
											</div>
											<div class="home-product-item__origin">
												<span class="home-product-item__brand">Whoo</span> <span
													class="home-product-item__origin-name">Nhật Bản</span>
											</div>
											<div class="home-product-item__favourite">
												<i style="font-size: 1.8rem;" class='bx bx-check'></i> <span>Yêu
													thích</span>
											</div>
											<div class="home-product-item__sale-off">
												<span class="home-product-item__sale-off-percent">10%</span>
												<span class="home-product-item__sale-off-label">Giảm</span>
											</div>
										</a>
									</div>

								</c:forEach>


							</div>
						</div>
						<ul class="pagination home-product__pagination">
							<c:if test="${tag > 1}">
								<li class="pagination-item"><a
									href="home?index=${(tag - 1)}" class="pagination-item__link">
										<i style="font-size: 2.5rem;"
										class='pagination-item__icon bx bx-chevron-left'></i>
								</a></li>
							</c:if>

							<c:if test="${endPage < 10}">
								<c:forEach begin="1" end="${endPage}" var="i">
									<li class="pagination-item ${tag == i?"pagination-item--active":""}"><a
										href="home?index=${i}" class="pagination-item__link">${i}</a></li>
								</c:forEach>
							</c:if>
							<c:if test="${endPage >= 10}">
								<c:if test="${tag <= 3 || tag > endPage - 2}">
									<c:forEach begin="1" end="5" var="i">
										<li class="pagination-item ${tag == i?"pagination-item--active":""}"><a
											href="home?index=${i}" class="pagination-item__link">${i}</a></li>
									</c:forEach>
									<li class="pagination-item"><span
										class="pagination-item__link">...</span></li>
									<c:forEach begin="${endPage - 2}" end="${endPage}" var="i">
										<li class="pagination-item ${tag == i?"pagination-item--active":""}"><a
											href="home?index=${i}" class="pagination-item__link">${i}</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${tag > 3 && tag < endPage - 2}">
									<li class="pagination-item"><span
										class="pagination-item__link">...</span></li>
									<c:forEach begin="${tag - 2}" end="${tag + 2}" var="i">
										<li class="pagination-item ${tag == i?"pagination-item--active":""}"><a
											href="home?index=${i}" class="pagination-item__link">${i}</a></li>
									</c:forEach>
									<li class="pagination-item"><span
										class="pagination-item__link">...</span></li>
									<c:forEach begin="${endPage - 2}" end="${endPage}" var="i">
										<li class="pagination-item ${tag == i?"pagination-item--active":""}"><a
											href="home?index=${i}" class="pagination-item__link">${i}</a></li>
									</c:forEach>
								</c:if>
							</c:if>
							<!--  <li class="pagination-item"><a href="#"
								class="pagination-item__link">2</a></li>
							<li class="pagination-item"><a href="#"
								class="pagination-item__link">3</a></li>
							<li class="pagination-item"><a href="#"
								class="pagination-item__link">4</a></li>
							<li class="pagination-item"><a href="#"
								class="pagination-item__link">5</a></li>
							<li class="pagination-item"><a href="#"
								class="pagination-item__link">...</a></li>-->
							<c:if test="${tag < endPage}">
								<li class="pagination-item"><a
									href="home?index=${(tag + 1)}" class="pagination-item__link">
										<i style="font-size: 2.5rem;"
										class='pagination-item__icon bx bx-chevron-right'></i>
								</a></li>
							</c:if>
							<!--  <li class="pagination-item"><a href="#"
								class="pagination-item__link">14</a></li> -->

						</ul>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>

	</div>
	<!-- <div class="modal">
        <div class="modal__overlay">

        </div>
        <div class="modal__body"> -->
	<!-- register form -->
	<!-- <div class="auth-form">
                <div class="auth-form__container">
                    <div class="auth-form__header">
                        <h3 class="auth-form__heading">
                            Đăng kí
                        </h3>
                        <span class="auth-form__switch-btn">Đăng nhập</span>
    
                    </div>
                    <div class="auth-form__form">
                        <div class="auth-form__group">
                            <input type="text" class="auth-form__input " placeholder="Email của bạn">
                        </div>
                        <div class="auth-form_group">
                            <input type="password" class="auth-form__input" placeholder="Mật khẩu của bạn" >
                        </div>
                        <div class="auth-form_group">
                            <input type="password" class="auth-form__input" placeholder="Nhập lại mật khẩu" >
                        </div>
                    </div>
                    <div class="auth-form__aside">
                        <p class="auth-form__policy-text">
                            Bằng việc đăng kí,bạn đã đồng ý với F8-shop về
                            <a href="#" class="auth-form__text-link">Điều khoản dịch vụ</a> &
                            <a href="" class="auth-form__text-link">Chính sách bảo mật</a>
                        </p>
                    </div>
                    <div class="auth-form__controls">
                        <button class="btn auth-form__controls-backs btn-normal">TRỞ LẠI</button>
                        <button class="btn btn-primary">ĐĂNG KÝ</button>
                    </div>
                </div>
                <div class="auth-form__socials">
                    <a href="" class="auth-form__socials-facebook btn btn--size-s btn--with-icon">
                        <i class="auth-form__socials-icon fa-brands fa-facebook-square"></i>
                        <span class="auth-form__socials-title">
                            Kết nối với Facebook
                        </span>
                    </a>
                    <a href="" class="auth-form__socials-google btn btn--with-icon">
                        <i class="auth-form__socials-icon fa-brands fa-google"></i>
                        <span class="auth-form__socials-title">
                            Kết nối với Google
                        </span>
                        
                    </a>
                </div>
            </div> -->

	<!-- login form -->
	<!-- <div class="auth-form">
                <div class="auth-form__container">
                    <div class="auth-form__header">
                        <h3 class="auth-form__heading">
                            Đăng nhập
                        </h3>
                        <span class="auth-form__switch-btn">Đăng kí</span>
    
                    </div>
                    <div class="auth-form__form">
                        <div class="auth-form__group">
                            <input type="text" class="auth-form__input " placeholder="Email của bạn">
                        </div>
                        <div class="auth-form_group">
                            <input type="password" class="auth-form__input" placeholder="Mật khẩu của bạn" >
                        </div>
                       
                    </div>
                    <div class="auth-form__aside">
                        <div class="auth-form__help">
                            <a href="" class="auth-form__help-link auth-form__help-forgot">Quên mật khẩu</a>
                            <span class="auth-form__help-separate"></span>
                            <a href="" class="auth-form__help-link">Cần trợ giúp?</a>
                        </div>
                    </div>
                    <div class="auth-form__controls">
                        <button class="btn auth-form__controls-backs btn-normal">TRỞ LẠI</button>
                        <button class="btn btn-primary">ĐĂNG NHẬP</button>
                    </div>
                </div>
                <div class="auth-form__socials">
                    <a href="" class="auth-form__socials-facebook btn btn--size-s btn--with-icon">
                        <i class="auth-form__socials-icon fa-brands fa-facebook-square"></i>
                        <span class="auth-form__socials-title">
                            Kết nối với Facebook
                        </span>
                    </a>
                    <a href="" class="auth-form__socials-google btn btn--with-icon">
                        <i class="auth-form__socials-icon fa-brands fa-google"></i>
                        <span class="auth-form__socials-title">
                            Kết nối với Google
                        </span>
                        
                    </a>
                </div>
            </div>


        </div>
    </div> -->
</body>
</html>