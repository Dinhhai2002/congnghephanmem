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
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="/fontawesome/css/all.min.css">
<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
	<div class="app">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="container">
			<div class="grid wide">

				<!-- Body -->
				<div class="shop-category-on-mb-tb hide-on-pc">
					<div class="col m-12 c-12 search-item-result-on-mb-tb hide-on-pc">
						<ul class="row no-gutters search-item-result-on-mb-tb-list">
						<c:forEach items="${listCC}" var="o">
										
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item">
								<!-- border-primary color-primary --> <a href="product?index=${o.cId}&page=1"
								class="search-item-result-on-mb-tb-link ${cid==o.cId?"category-list__item-link-highlight":""}  ">
									<span class="search-item-result-on-mb-tb-text"> ${o.cName} </span>
									<span class="separate"></span>
							</a>
							</li>
							</c:forEach>

						</ul>
					</div>
				</div>
				<div class="row sm-gutter body-content">
					<div class="col m-12 c-12 search-item-result-on-mb-tb hide-on-pc">
						<ul class="row no-gutters search-item-result-on-mb-tb-list">
							<li class="col m-3 c-3 search-item-result-on-mb-tb-item"><a
								href="product?index=0&page=1"
								class="search-item-result-on-mb-tb-link border-primary color-primary">
									<span class="search-item-result-on-mb-tb-text"> Tất cả sản phẩm
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
							<li class="col c-3 m-3 search-item-result-on-mb-tb-item">
							
							</li>
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
									<li class="category-list__item "><a
										href="/Shopee/product?index=${o.cId}&page=1"
										class="category-list__item-link ${cid==o.cId?"category-list__item-link-highlight":""} ">
											<i class="category-list__item-icon fas fa-caret-right"></i>
											${o.cName}
									</a></li>
								</c:forEach>




							</ul>
						</div>



					</div>
					<div class="col l-10 lo-10 m-12 c-12">
						<div class="row sm-gutter">
							<div class="col l-12 lo-12 hide-on-mb-tb">
								<div class="sort-bar">
									<span class="sort-bar__label"> Sắp xếp theo </span>
									<div class="sort-bar-by-options">
										<button onclick="location.href='/Shopee/product?index=0&page=1'" class="btn btn--primary">Tất cả sản phẩm</button>
										<!-- <button class="btn">Mới Nhất</button>
										<button class="btn">Bán Chạy</button> -->
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
									<!-- <div class="sort-bar-mini-page-controller">
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
									</div> -->
								</div>
							</div>
						</div>
						<c:if test="${empty listP}">
						<h1 style="text-align: center;">Không tìm thấy kết quả cho <span style="font-style: italic;">${txtS}</span></h1>
						</c:if>
						<div id="content" class="row sm-gutter search-item-result__items">

							<c:forEach items="${listP}" var="o">

								<div class="col l-2-4 lo-3 m-4 c-6 search-item-result__item">
									<a href="/Shopee/product/detail?pId=${o.pId}&quantity=1&action="
										class="search-item-result__item-link">
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
											<!-- <div class="search-item-result__item-discount">
												<div class="search-item-result__item-discount-text">
													<span>12%</span> GIẢM
												</div>
											</div> -->
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
													₫${o.pPrice *1.2} </span>
												<div class="search-item-result__item-price-saleoff">
													<span> <fmt:formatNumber
														type="number" pattern="#,###"
														value="${o.pPrice}"></fmt:formatNumber>đ  </span>
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
														<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
															class="fas fa-star"></i> <i class="fas fa-star"></i> <i
															class="fas fa-star"></i>
													</div>
													<!-- <span>Đã bán 5</span> -->
												</div>
											</div>
											<p class="search-item-result__item-location">${o.shop.shopAddress}</p>
										</div>
									</a>
								</div>
							</c:forEach>










							<!-- search-item-50 -->
						</div>
						<c:if test="${isSearch == 1}">
						<c:set var = "productUrl" value = "searchproduct?txtS=${txtS}&page="/>
						</c:if>
						<c:if test="${isSearch == 0}">
						<c:set var = "productUrl" value = "product?index=${cid}&page="/>
						</c:if>
						<ul id="moreP1" class="pagination hide-on-mb">
							<c:if test="${tag > 1}">
								<li class="pagination-item"><a
									href="${productUrl}${tag-1}"
									class="pagination-item-link"> <i style="font-size: 2.5rem;"
										class='pagination-item-icon bx bx-chevron-left'></i>
								</a></li>
							</c:if>
							<c:if test="${endPage < 10}">
								<c:forEach begin="1" end="${endPage}" var="i">
									<li class="pagination-item"><a
										href="${productUrl}${i}"
										class="pagination-item-link ${tag == i?"bgc-highlight":""}">${i}</a></li>
								</c:forEach>
							</c:if>

							<c:if test="${endPage >= 10}">
								<c:if test="${tag <= 4}">
									<c:forEach begin="1" end="5" var="i">
										<li class="pagination-item"><a
											href="${productUrl}${i}"
											class="pagination-item-link ${tag == i?"bgc-highlight":""}">${i}</a></li>
									</c:forEach>
									<li class="pagination-item"><span
										class="pagination-item-link">...</span></li>
									<c:forEach begin="${endPage}" end="${endPage}" var="i">
										<li class="pagination-item"><a
											href="${productUrl}${i}"
											class="pagination-item-link ${tag == i?"bgc-highlight":""}">${i}</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${tag > 4 && tag < endPage - 4}">

									<li class="pagination-item"><a
										href="${productUrl}1"
										class="pagination-item-link ${tag == 1?"bgc-highlight":""}">1</a></li>

									<li class="pagination-item"><span
										class="pagination-item-link">...</span></li>
									<c:forEach begin="${tag - 1}" end="${tag + 2}" var="i">
										<li class="pagination-item"><a
											href="${productUrl}${i}"
											class="pagination-item-link ${tag == i?"bgc-highlight":""}">${i}</a></li>
									</c:forEach>
									<li class="pagination-item"><span
										class="pagination-item-link">...</span></li>
									<c:forEach begin="${endPage}" end="${endPage}" var="i">
										<li class="pagination-item"><a
											href="${productUrl}${i}"
											class="pagination-item-link ${tag == i?"bgc-highlight":""}">${i}</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${tag == endPage - 4}">
									<li class="pagination-item"><a
										href="${productUrl}1"
										class="pagination-item-link ${tag == 1?"bgc-highlight":""}">1</a></li>
									<li class="pagination-item"><span
										class="pagination-item-link">...</span></li>
									<c:forEach begin="${tag - 2}" end="${endPage}" var="i">
										<li class="pagination-item"><a
											href="${productUrl}${i}"
											class="pagination-item-link ${tag == i?"bgc-highlight":""}">${i}</a></li>
									</c:forEach>
								</c:if>
								<c:if test="${tag > endPage - 4}">
									<li class="pagination-item"><a
										href="${productUrl}1"
										class="pagination-item-link ${tag == 1?"bgc-highlight":""}">1</a></li>
									<li class="pagination-item"><span
										class="pagination-item-link">...</span></li>
									<c:forEach begin="${endPage - 5}" end="${endPage}" var="i">
										<li class="pagination-item"><a
											href="${productUrl}${i}"
											class="pagination-item-link ${tag == i?"bgc-highlight":""}">${i}</a></li>
									</c:forEach>
								</c:if>
							</c:if>


							<c:if test="${tag < endPage}">
								<li class="pagination-item"><a
									href="${productUrl}${tag+1}"
									class="pagination-item-link"> <i style="font-size: 2.5rem;"
										class='pagination-item-icon bx bx-chevron-right'></i>
								</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script src="<c:url value="/js/home.js"/>"></script>
	<script src="<c:url value="/js/product.js"/>"></script>
</body>

</html>