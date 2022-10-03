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
		<div class="container">
			<div class="grid wide">
				<div class="row no-gutters">
					<div class="gridswipper col l-12 m-12 c-12">
						<div class="swiper mySwiper">
                            <div class="swiper-wrapper">
                              <div class="swiper-slide"><img src="./assets/img/banner/banner1.jpeg" alt=""></div>
                              <div class="swiper-slide"><img src="./assets/img/banner/m-banner10.jpeg" alt=""></div>
                              <div class="swiper-slide"><img src="./assets/img/banner/m-banner11.jpeg" alt=""></div>
                              <div class="swiper-slide"><img src="./assets/img/banner/banner1.jpeg" alt=""></div>
                              <div class="swiper-slide"><img src="./assets/img/banner/banner1.jpeg" alt=""></div>
                              <div class="swiper-slide"><img src="./assets/img/banner/banner1.jpeg" alt=""></div>
                              <div class="swiper-slide"><img src="./assets/img/banner/banner1.jpeg" alt=""></div>
                              <div class="swiper-slide"><img src="./assets/img/banner/banner1.jpeg" alt=""></div>
                              <div class="swiper-slide">Slide 9</div>
                            </div>
                            <div class="swiper-button-next"></div>
                            <div class="swiper-button-prev"></div>
                            <div class="swiper-pagination"></div>
                          </div>
					</div>
				</div>





				<div class="shop-category-on-mb-tb hide-on-pc">
					<h3 class="img-carousel__items-title">Danh Mục</h3>
					<ul class="row no-gutters shop-category-on-mb-tb-list">
						<li class="col m-3 c-4 shop-category-on-mb-tb-item"><a
							href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img1"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Máy Tính Bàn</p>
						</a> <a href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img6"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Màn Hình</p>
						</a></li>
						<li class="col m-3 c-4 shop-category-on-mb-tb-item"><a
							href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img2"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Linh Kiện Máy
									Tính</p>
						</a> <a href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img7"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Thiết Bị Lưu Trữ
								</p>
						</a></li>
						<li class="col m-3 c-4 shop-category-on-mb-tb-item"><a
							href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img3"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Thiết Bị Mạng</p>
						</a> <a href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img8"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Máy In & Máy
									Scan</p>
						</a></li>
						<li class="col m-3 c-4 shop-category-on-mb-tb-item"><a
							href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img4"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Phụ Kiện Máy
									Tính</p>
						</a> <a href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img9"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Laptop</p>
						</a></li>
						<li class="col m-3 c-4 shop-category-on-mb-tb-item"><a
							href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img5"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Khác</p>
						</a> <a href="" class="shop-category-on-mb-tb-item-link">
								<div class="shop-category-on-mb-tb-item-wrap">
									<div class="shop-category-on-mb-tb-item-img10"></div>
								</div>
								<p class="shop-category-on-mb-tb-item-text">Gaming</p>
						</a></li>
					</ul>
				</div>

				<!-- Body -->
				<div class="row sm-gutter body-content">
					<div class="col m-12 c-12 search-item-result-on-mb-tb hide-on-pc">
						<ul class="row no-gutters search-item-result-on-mb-tb-list">
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href=""
								class="search-item-result-on-mb-tb-link border-primary color-primary">
									<span class="search-item-result-on-mb-tb-text"> Phổ Biến
								</span> <span class="separate"></span>
							</a></li>
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="" class="search-item-result-on-mb-tb-link"> <span
									class="search-item-result-on-mb-tb-text"> Mới Nhất <span
										class="separate"></span>
								</span>
							</a></li>
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="" class="search-item-result-on-mb-tb-link"> <span
									class="search-item-result-on-mb-tb-text"> Bán Chạy <span
										class="separate"></span>
								</span>
							</a></li>
							<li class="col c-3 m-3 search-item-result-on-mb-tb-item"><a
								href="" class="search-item-result-on-mb-tb-link"> <span
									class="search-item-result-on-mb-tb-text"> Giá </span>
									<div class="search-item-result-on-mb-tb-icon">
										<i class="fas fa-chevron-up"></i> <i
											class="fas fa-chevron-down"></i>
									</div>
							</a></li>
						</ul>
					</div>
					<div class="col l-2 lo-2 hide-on-mb-tb">
						<div class="category-list">
							<h2 class="category-list__title">
								<a href="" class="category-list__title-link"> <i
									class="category-list__title-icon fas fa-bars"></i> <span>Tất
										cả danh mục</span>
								</a>
							</h2>
							<ul class="category-list__list">
								<c:forEach items="${listCC}" var="o">
									<li class="category-list__item ${tag==o.cId?"active":""}">
										<a href="category?cid=${o.cId}"
										class="category-list__item-link  ">
											
											<i class='category-list__item-icon bx bx-chevron-right' ></i>
											${o.cName}
									</a>
									</li>
								</c:forEach>

								<!-- <li class="category-list__item">
                                    <a href="" class="category-list__item-link">
                                        Máy In, Máy Scan & Máy Chiếu
                                    </a>
                                </li>
                                <li class="category-list__item">
                                    <a href="" class="category-list__item-link">
                                        Phụ Kiện Máy Tính
                                    </a>
                                </li>
                                <li class="category-list__item">
                                    <a href="" class="category-list__item-link">
                                        Laptop
                                    </a>
                                </li>
                                <li class="category-list__item">
                                    <a href="" class="category-list__item-link">
                                        Khác
                                    </a>
                                </li>
                                <li class="category-list__item">
                                    <a href="" class="category-list__item-link">
                                        Gaming
                                    </a>
                                </li> -->

								<div class="btn-add">
									Thêm <span>&#8744;</span>
								</div>
							</ul>
						</div>



						<div class="filter-group price-range">
							<h3 class="price-range__title">Khoảng Giá</h3>
							<div class="price-range__edit">
								<input type="text" name="" id="" placeholder="₫ TỪ"
									class="price-range__input">
								<div class="price-range__input-line"></div>
								<input type="text" name="" id="" placeholder="₫ ĐẾN"
									class="price-range__input">
							</div>
							<button class="btn btn--primary">Áp Dụng</button>
						</div>


					
					</div>
					<div class="col l-10 lo-10 m-12 c-12">
						<div class="row sm-gutter">
							<div class="col l-12 lo-12 hide-on-mb-tb">
								<div class="sort-bar">
									<span class="sort-bar__label"> Sắp xếp theo </span>
									<div class="sort-bar-by-options">
										<button class="btn btn--primary">Phổ Biến</button>
										<button class="btn">Mới Nhất</button>
										<button class="btn">Bán Chạy</button>
										<div class="sort-bar-by-options__price">
											<span>Giá</span> 
												<i class='sort-bart-by-options__icon bx bxs-chevron-down' ></i>
											<div class="sort-bar-by-options__price-list">
												<a href="" class="sort-bar-by-options__price-item">
													<p class="sort-bar-by-options__price-text">Giá: Thấp
														đến cao</p>
												</a> <a href="" class="sort-bar-by-options__price-item">
													<p class="sort-bar-by-options__price-text">Giá: Cao đến
														thấp</p>
												</a>
											</div>
										</div>
									</div>
									<div class="sort-bar-mini-page-controller">
										<p class="sort-bar-mini-page-controller__state">
											<span>1</span>/100
										</p>
										<button
											class="btn sort-bar-mini-page-controller__icon-disabled">
											
												<i class='sort-bar-mini-page-controller__icon bx bxs-chevron-left-circle' ></i>
										</button>
										<button class="btn">
											<i
												class="sort-bar-mini-page-controller__icon bx bxs-chevron-right-circle"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="row sm-gutter search-item-result__items">

							<c:forEach items="${listP}" var="o">
								<!-- search-item-1 -->
								<div class="col l-2-4 lo-3 m-4 c-6 search-item-result__item">
									<a href="/Shopee/detail?pid=${o.pId }" class="search-item-result__item-link">
										<div class="search-item-result__item-bgc">
											
											<div class="search-item-result__item-tag-left">
												<div class="mall-tag hide-tag">
													<span>Mall</span>
												</div>
												<div class="order-processing-tag-wrap hide-tag">
													<div class="order-processing-tag"></div>
												</div>
												<div class="favourite-tag">
													<span>Yêu Thích</span>
												</div>
											</div>
											<div class="search-item-result__item-discount">
												<div class="search-item-result__item-discount-text">
													<span>12%</span> GIẢM
												</div>
											</div>
											<div class="search-item-result__item-overlay">
												<img src="${o.pImage}" alt=" ${o.pName}">
											</div>
										</div>
										<div class="search-item-result__item-body">
											<div class="search-item-result__item-group">
												<h3 class="search-item-result__item-title">${o.pName}</h3>
												<div class="search-item-result__item-sale-off">
													<div class="search-item-result__item-sale-off-ticket">
														<svg class="search-item-result__item-sale-off-ticket-icon"
															viewBox="-0.5 -0.5 4 16">
                                                        <path
																d="M4 0h-3q-1 0 -1 1a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3q0 1 1 1h3"
																stroke-width="1" transform="" stroke="currentColor"
																fill="#f69113" color="#f69113"></path>
                                                    </svg>
														<span class="sale-off-tag">Giảm ₫80k</span>
														<svg class="search-item-result__item-sale-off-ticket-icon"
															viewBox="-0.5 -0.5 4 16">
                                                        <path
																d="M4 0h-3q-1 0 -1 1a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3v0.333a1.2 1.5 0 0 1 0 3q0 1 1 1h3"
																stroke-width="1"
																transform="rotate(180) translate(-3 -15)"
																stroke="currentColor" fill="#f69113" color="#f69113"></path>
                                                    </svg>
													</div>
													<span class="buy–with-original">Mua kèm deal sốc</span> <span
														class="installment-tag hide-tag"> 0% TRẢ GÓP </span>
												</div>

											</div>
											<div class="search-item-result__item-price-wrap">
												<span class="search-item-result__item-price">
													₫${o.pPrice+50000} </span>
												<div class="search-item-result__item-price-saleoff">
													<span> ₫${o.pPrice} </span>
													<svg height="12" viewBox="0 0 20 12" width="20"
														class="search-item-result__item-price-saleoff-icon">
                                                    <g fill="none"
															fill-rule="evenodd" transform="">
                                                        <rect
															fill="#00bfa5" fill-rule="evenodd" height="9" rx="1"
															width="12" x="4"></rect>
                                                        <rect height="8"
															rx="1" stroke="#00bfa5" width="11" x="4.5" y=".5">
                                                        </rect>
                                                        <rect
															fill="#00bfa5" fill-rule="evenodd" height="7" rx="1"
															width="7" x="13" y="2"></rect>
                                                        <rect height="6"
															rx="1" stroke="#00bfa5" width="6" x="13.5" y="2.5">
                                                        </rect>
                                                        <circle cx="8"
															cy="10" fill="#00bfa5" r="2"></circle>
                                                        <circle cx="15"
															cy="10" fill="#00bfa5" r="2"></circle>
                                                        <path
															d="m6.7082481 6.7999878h-.7082481v-4.2275391h2.8488017v.5976563h-2.1405536v1.2978515h1.9603297v.5800782h-1.9603297zm2.6762505 0v-3.1904297h.6544972v.4892578h.0505892c.0980164-.3134765.4774351-.5419922.9264138-.5419922.0980165 0 .2276512.0087891.3003731.0263672v.6210938c-.053751-.0175782-.2624312-.038086-.3762568-.038086-.5122152 0-.8758247.3017578-.8758247.75v1.8837891zm3.608988-2.7158203c-.5027297 0-.8536919.328125-.8916338.8261719h1.7390022c-.0158092-.5009766-.3446386-.8261719-.8473684-.8261719zm.8442065 1.8544922h.6544972c-.1549293.571289-.7050863.9228515-1.49238.9228515-.9864885 0-1.5903965-.6269531-1.5903965-1.6464843 0-1.0195313.6165553-1.6669922 1.5872347-1.6669922.9580321 0 1.5366455.6064453 1.5366455 1.6083984v.2197266h-2.4314412v.0351562c.0221328.5595703.373095.9140625.9169284.9140625.4110369 0 .6924391-.1376953.8189119-.3867187zm2.6224996-1.8544922c-.5027297 0-.853692.328125-.8916339.8261719h1.7390022c-.0158091-.5009766-.3446386-.8261719-.8473683-.8261719zm.8442064 1.8544922h.6544972c-.1549293.571289-.7050863.9228515-1.49238.9228515-.9864885 0-1.5903965-.6269531-1.5903965-1.6464843 0-1.0195313.6165553-1.6669922 1.5872347-1.6669922.9580321 0 1.5366455.6064453 1.5366455 1.6083984v.2197266h-2.4314412v.0351562c.0221328.5595703.373095.9140625.9169284.9140625.4110369 0 .6924391-.1376953.8189119-.3867187z"
															fill="#fff"></path>
                                                        <path
															d="m .5 8.5h3.5v1h-3.5z" fill="#00bfa5"></path>
                                                        <path
															d="m0 10.15674h3.5v1h-3.5z" fill="#00bfa5"></path>
                                                        <circle cx="8"
															cy="10" fill="#047565" r="1"></circle>
                                                        <circle cx="15"
															cy="10" fill="#047565" r="1"></circle>
                                                    </g>
                                                </svg>
												</div>
											</div>
											<div class="search-item-result__item-react">
												<div class="search-item-result__item-like">
													
													<i class='search-item-result__item-like-icon bx bx-heart' ></i>
													<!-- <i class="search-item-result__item-like-icon fas fa-heart"></i> -->
												</div>
												<div class="search-item-result__item-rated">
													<div class="search-item-result__item-icon">
														<i class="bx bxs-star"></i> <i class="bx bxs-star"></i> <i
															class="bx bxs-star"></i> <i class="bx bxs-star"></i> <i
															class="bx bxs-star"></i>
													</div>
													<span>Đã bán 5</span>
												</div>
											</div>
											<p class="search-item-result__item-location">TP. Hồ Chí
												Minh</p>
										</div>
									</a>
								</div>
							</c:forEach>
						
							
						</div>
						<ul class="pagination hide-on-mb">
							<li class="pagination-item"><a href=""
								class="pagination-item-link"> <i
									class="pagination-item-icon bx bxs-chevron-left"></i>
							</a></li>
							<li class="pagination-item"><a href=""
								class="pagination-item-link bgc-highlight"> 1 </a></li>
							<li class="pagination-item"><a href=""
								class="pagination-item-link"> 2 </a></li>
							<li class="pagination-item"><a href=""
								class="pagination-item-link"> 3 </a></li>
							<li class="pagination-item"><a href=""
								class="pagination-item-link"> 4 </a></li>
							<li class="pagination-item"><a href=""
								class="pagination-item-link"> 5 </a></li>
							<li class="pagination-item"><a href=""
								class="pagination-item-link"> ... </a></li>
							<li class="pagination-item"><a href=""
								class="pagination-item-link"> <i
									class="pagination-item-icon bx bxs-chevron-right"></i>
							</a></li>
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
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
            <script>
                var swiper = new Swiper(".mySwiper", {
                  spaceBetween: 30,
                  centeredSlides: true,
                  autoplay: {
                    delay: 2500,
                    disableOnInteraction: false,
                  },
                  pagination: {
                    el: ".swiper-pagination",
                    clickable: true,
                  },
                  navigation: {
                    nextEl: ".swiper-button-next",
                    prevEl: ".swiper-button-prev",
                  },
                });
              </script>
</body>
</html>