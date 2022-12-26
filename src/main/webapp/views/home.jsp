<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
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
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
<style type="text/css">
.footer-logo-background {
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
					<div class="gridswipper col l-12 m-12 c-12">
						<div class="swiper mySwiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/07322294-7f1a-44d0-98f8-fdde85a4cc39/z3788007980337_e2b5cc30c3abcad1cf0ea9d9d2e7cb84.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/09b55ace-b66f-46c6-a499-d45199c40ced/z3788007984286_8a456c60cc73ec5f634e2c07f6f965e4.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/eaef859f-79c9-437b-8f63-69d8adde27e6/z3788007984292_9dc701e54e6e63f600c4c25c602b652a.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/a6546423-6e0e-4d0b-8152-f3f8d97031cb/z3788007984296_b6c7a274737f8341912682368c11b656.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/5fc02732-e7bc-48b1-b658-961a0cd13edb/z3788008001379_78e65fb74dfbb8525a4580513a25b347.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/522627fe-7415-459a-a364-351c2b0c3340/z3788008012653_c7e237fe2dd20180f10f7daa97972146.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/2eca270a-89f5-49a9-adfa-5beaf95b7e22/z3788007994009_ec5e1defa2e702fc0401db963950abe2.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/bbcb0bc2-9c39-4625-a3d2-af3761643c80/z3788008021666_da8cea312c24955943877a1c01dce595.jpg"
										alt="">
								</div>
								<div class="swiper-slide">
									<img
										src="https://ucarecdn.com/580ef643-68da-48f7-b075-634cb8e5cc6d/z3788194475345_7a43857d0ead2dd2ccb521074d9ec505.jpg"
										alt="">
								</div>
							</div>
							<div class="swiper-button-next"></div>
							<div class="swiper-button-prev"></div>
							<div class="swiper-pagination"></div>
						</div>
					</div>
				</div>

				<div class="row no-gutters">
					<div class="col l-12 c-12 m-12 ofs-carousel">
						<div class="ofs-carousel__header">
							<a href="#" class="ofs-carousel__title-shop"> Danh mục sản
								phẩm </a> <a href="/Shopee/product?index=0&page=1"
								class="ofs-carousel__title"> <span>Xem tất cả</span> <i
								class="fas fa-chevron-right"></i>
							</a>
						</div>
					</div>
				</div>
				<div class="top-sales-wrap">
					<div class="top-sales">
						<ul class="row no-gutters top-sales-list">
							<c:forEach items="${listCC}" var="o">
								<li class="col l-2 lo-2 m-3 c-4 top-sales-item"><a
									href="/Shopee/product?index=0&page=1"
									class="top-sales-item-link">
										<div style="margin-right: 4px;"
											class="top-sales-item-link__container">
											<div class="top-sales-item-link__img">
												<div
													style="background: center / contain no-repeat url(<c:url value="${o.cImage}"/>) "
													class="top-sales-item-link__img-bgc1"></div>
											</div>
											<p class="top-sales-item-link__text">${o.cName}</p>

										</div>
								</a></li>
							</c:forEach>
						</ul>
					</div>
					<span class="ofs-carousel__arrow-next hide-on-mb-tb"> <i
						class="fas fa-chevron-right"></i>
					</span>
				</div>





				<!-- Body -->
				<div class="row sm-gutter body-content">

					<div class="col l-12 lo-12 m-12 c-12">
						<div class="row sm-gutter">
							<div class="col l-12 lo-12 hide-on-mb-tb">
								<div class="sort-bar">
									<span class="sort-bar__label"> Sắp xếp theo </span>
									<div class="sort-bar-by-options">
										<button class="btn btn--primary">Phổ Biến</button>
										<button class="btn">Mới Nhất</button>
										<button class="btn">Bán Chạy</button>
										<select class="sort-bar-by-options__price" id="select">

											<div class="sort-bar-by-options__price-list">
												<option value="Default"
													class="sort-bar-by-options__price-item">Giá:mặc
													định</option>
												<option value="LowToHigh"
													class="sort-bar-by-options__price-item">Giá: Thấp
													đến cao</option>
												<option value="HighToLow"
													class="sort-bar-by-options__price-item">Giá: Cao
													đến thấp</option>
											</div>
										</select>
									</div>
									<div class="sort-bar-mini-page-controller">
										<p class="sort-bar-mini-page-controller__state">
											<span>1</span>/100
										</p>
										<button
											class="btn sort-bar-mini-page-controller__icon-disabled">
											<i
												class="sort-bar-mini-page-controller__icon fas fa-angle-left"></i>
										</button>
										<button class="btn">
											<i
												class="sort-bar-mini-page-controller__icon fas fa-angle-right"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="row sm-gutter search-item-result__items">

                             <c:forEach items="${listP}" var="o"> 
                   
                            <div class="col l-2-4 lo-3 m-4 c-6 search-item-result__item">
                                <a href="/Shopee/product/detail?pId=${o.pId}" class="search-item-result__item-link">
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
                                                <span>12%</span>
                                                GIẢM
                                            </div>
                                        </div>
                                        <c:url value="/image?fname=${o.pImage}" var="imgUrl"></c:url>
											<div class="search-item-result__item-overlay">
												<c:if test="${fn:contains(o.pImage, 'https')}">
													<img src="${o.pImage}" alt=" ${o.pName}">
												</c:if>
												<c:if test="${fn:contains(o.pImage, 'product')}">
													<img src="${imgUrl}" alt=" ${o.pName}">
												</c:if>

											</div>
                                    </div>
                                    <div class="search-item-result__item-body">
                                        <div class="search-item-result__item-group">
                                            <h3 class="search-item-result__item-title">
                                                ${o.pName}
                                            </h3>
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
													₫${o.pPrice *1.2} </span>
												<div class="search-item-result__item-price-saleoff">
													<span> <fmt:formatNumber
														type="number" pattern="#,###"
														value="${o.pPrice}"></fmt:formatNumber>đ </span>
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
                                                <i class="search-item-result__item-like-icon far fa-heart"></i>
                                                <!-- <i class="search-item-result__item-like-icon fas fa-heart"></i> -->
                                            </div>
                                            <div class="search-item-result__item-rated">
                                                <div class="search-item-result__item-icon">
                                                    <i class="fas fa-star"></i>
                                                    <i class="fas fa-star"></i>
                                                    <i class="fas fa-star"></i>
                                                    <i class="fas fa-star"></i>
                                                    <i class="fas fa-star"></i>
                                                </div>
                                                <!-- <span>Đã bán 5</span> -->
                                            </div>
                                        </div>
                                        <p class="search-item-result__item-location">
                                            ${o.shop.shopAddress}
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </c:forEach> 
                     
                           
                            
                             
                        </div>
                        <ul class="pagination ">
                           <a href="/Shopee/product?index=0&page=1"class="pagination_btn">Xem tất cả</a>
                        </ul>
                    </div>
                </div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>

	</div>
	<script src="<c:url value="/js/home.js"/>"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
	<script>
		var swiper = new Swiper(".mySwiper", {
			spaceBetween : 30,
			centeredSlides : true,
			autoplay : {
				delay : 2500,
				disableOnInteraction : false,
			},
			pagination : {
				el : ".swiper-pagination",
				clickable : true,
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	</script>
</body>
</html>