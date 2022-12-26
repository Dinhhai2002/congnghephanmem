<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiết sản phẩm</title>


<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
	<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

	<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/grid.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/responsive.css"/>" rel="stylesheet"
	type="text/css" />
	<link href="<c:url value="/css/details.css"/>" rel="stylesheet"
	type="text/css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
  .footer-logo-background{
  /* background: url("<c:url value="/img/bg-icon.png"/>"); */
  background: url("${pageContext.request.contextPath}/img/bg-icon.png");
  }
  body{
  margin:0;
  }
  </style>

</head>
<body>

	
	<div class="app">
        <jsp:include page="header.jsp"></jsp:include>
        <div  class="container">
            <div class="grid wide">
                <div class="row sm-gutter body-content">
                    <aside class="col m-6 c-6 bottom border-right">
                        <article class="gallery-wrap">
                        	<input type="hidden" id="PID" value="${p.pId}">
                            <img class="gallery-wrap-img" src="${p.pImage }"
                                alt="${p.pName}">

                        </article>
                        <!-- gallery-wrap .end// -->
                    </aside>
                    <aside style="margin-bottom: 20px;"class="col m-6 c-6 bottom">
                        <article class="card-body ">
                            <h3 class="title ">${p.pName}</h3>

                            <p class="price-detail-wrap">
                                <span class="price h3 text-warning"> <span
                                    class="currency"></span><span class="num">${p.pPrice}</span>
                                </span>
                                <!--<span>/per kg</span>-->
                            </p>
                            <!-- price-detail-wrap .// -->
                            <dl >
                                <dt>Mô tả</dt>
                                <dd>
                                    <p class="item-property">${p.pDescription}</p>
                                </dd>
                            </dl>
                           

                            <hr>
                            <dl class="param param-inline">
                                        <dt>Số lượng:</dt>
                                        <div class="model_quantity_number">  
                                               									
                                        <button type="button" id="cart-qty-minus" name="cart-qty-minus" ><i
                                                class='bx bx-minus'></i></button>
                                                
                                            <p class="cart-qty">1</p>
                                           
                                           <!--  <p id="cart-qty" name="cart-qty" >  1  </p> -->                              
                                            <button type="button" id="cart-qty-plus" name ="cart-qty-plus"><i
                                                class='bx bx-plus'></i></button>
                                                <input type="hidden" id="QUAN" value="${p.pQuantity}">
                                                <p style="font-size:12px;" id="test">${p.pQuantity} sản phẩm có sẵn</p>                                                                                              
                                            
                                        </div>
                                        <p style="display:none;color:red;font-size:12px" id="noti"></p>
                             </dl>
                                    <!-- item-property .// -->
                              
                                <!-- col.// -->

                            
                            <!-- row.// -->
                            <hr>
                            <div class="btn-footer">
                                     <button  id="addproductcart" type="button" 
                                    class="submit"> <i
                                    class="fas fa-shopping-cart"></i> Thêm hàng vào giỏ
                                </button>
                                <a onclick="replace()" class="submit">
                                    Mua ngay </a>
                            </div>
                        </article>
                        <!-- card-body.// -->
                    </aside>
                    <div class="col  m-12 c-12">
                        <div class="row sm-gutter">
                            <div class="col l-12 lo-12 hide-on-mb-tb">
                                <div class="sort-bar">
                                    <span style="font-size:18px;font-weight:500;" class="sort-bar__label">
                                       Các sản phẩm liên quan
                                    </span>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="row sm-gutter search-item-result__items">

                             <c:forEach items="${listP}" var="o"> 
                            <!-- search-item-1 -->
                            <div class="col l-2-4 lo-3 m-4 c-6 search-item-result__item">
                                <a href="/Shopee/detail?pId=${o.pId}&quantity=1&action=" class="search-item-result__item-link">
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
                                        <div class="search-item-result__item-overlay">
                                            <img src="${o.pImage}" alt=" ${o.pName}">
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
                                                            stroke-width="1" transform="rotate(180) translate(-3 -15)"
                                                            stroke="currentColor" fill="#f69113" color="#f69113"></path>
                                                    </svg>
                                                </div>
                                                <span class="buy–with-original">Mua kèm deal sốc</span>
                                                <span class="installment-tag hide-tag">
                                                    0% TRẢ GÓP
                                                </span>
                                            </div>

                                        </div>
                                        <div class="search-item-result__item-price-wrap">
                                            <span class="search-item-result__item-price">
                                                ₫${o.pPrice +30000}
                                            </span>
                                            <div class="search-item-result__item-price-saleoff">
                                                <span>
                                                    ₫${o.pPrice}
                                                </span>
                                                <svg height="12" viewBox="0 0 20 12" width="20"
                                                    class="search-item-result__item-price-saleoff-icon">
                                                    <g fill="none" fill-rule="evenodd" transform="">
                                                        <rect fill="#00bfa5" fill-rule="evenodd" height="9" rx="1"
                                                            width="12" x="4"></rect>
                                                        <rect height="8" rx="1" stroke="#00bfa5" width="11" x="4.5"
                                                            y=".5">
                                                        </rect>
                                                        <rect fill="#00bfa5" fill-rule="evenodd" height="7" rx="1"
                                                            width="7" x="13" y="2"></rect>
                                                        <rect height="6" rx="1" stroke="#00bfa5" width="6" x="13.5"
                                                            y="2.5">
                                                        </rect>
                                                        <circle cx="8" cy="10" fill="#00bfa5" r="2"></circle>
                                                        <circle cx="15" cy="10" fill="#00bfa5" r="2"></circle>
                                                        <path
                                                            d="m6.7082481 6.7999878h-.7082481v-4.2275391h2.8488017v.5976563h-2.1405536v1.2978515h1.9603297v.5800782h-1.9603297zm2.6762505 0v-3.1904297h.6544972v.4892578h.0505892c.0980164-.3134765.4774351-.5419922.9264138-.5419922.0980165 0 .2276512.0087891.3003731.0263672v.6210938c-.053751-.0175782-.2624312-.038086-.3762568-.038086-.5122152 0-.8758247.3017578-.8758247.75v1.8837891zm3.608988-2.7158203c-.5027297 0-.8536919.328125-.8916338.8261719h1.7390022c-.0158092-.5009766-.3446386-.8261719-.8473684-.8261719zm.8442065 1.8544922h.6544972c-.1549293.571289-.7050863.9228515-1.49238.9228515-.9864885 0-1.5903965-.6269531-1.5903965-1.6464843 0-1.0195313.6165553-1.6669922 1.5872347-1.6669922.9580321 0 1.5366455.6064453 1.5366455 1.6083984v.2197266h-2.4314412v.0351562c.0221328.5595703.373095.9140625.9169284.9140625.4110369 0 .6924391-.1376953.8189119-.3867187zm2.6224996-1.8544922c-.5027297 0-.853692.328125-.8916339.8261719h1.7390022c-.0158091-.5009766-.3446386-.8261719-.8473683-.8261719zm.8442064 1.8544922h.6544972c-.1549293.571289-.7050863.9228515-1.49238.9228515-.9864885 0-1.5903965-.6269531-1.5903965-1.6464843 0-1.0195313.6165553-1.6669922 1.5872347-1.6669922.9580321 0 1.5366455.6064453 1.5366455 1.6083984v.2197266h-2.4314412v.0351562c.0221328.5595703.373095.9140625.9169284.9140625.4110369 0 .6924391-.1376953.8189119-.3867187z"
                                                            fill="#fff"></path>
                                                        <path d="m .5 8.5h3.5v1h-3.5z" fill="#00bfa5"></path>
                                                        <path d="m0 10.15674h3.5v1h-3.5z" fill="#00bfa5"></path>
                                                        <circle cx="8" cy="10" fill="#047565" r="1"></circle>
                                                        <circle cx="15" cy="10" fill="#047565" r="1"></circle>
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
                                                <span>Đã bán 5</span>
                                            </div>
                                        </div>
                                        <p class="search-item-result__item-location">
                                            TP. Hồ Chí Minh
                                        </p>
                                    </div>
                                </a>
                            </div>
                         </c:forEach> 
                           
                            
                            
                             
                        </div>
                       
                </div>
                 <div class="col m-12 c-12">
                 
                    <form name="Myform" method="post"class="row sm-gutter comment">
                    <input name="usernamecomment" value="${sessionScope.acc.uName}" hidden/>
                        <h3 class="comment-header">Bình luận</h3>
                        <textarea class="comment-content"name="content" id="" cols="30" rows="10" required></textarea>
                        <button type="submit">Đăng</button>
                    </form>
                    <div class="row sm-gutter comment-detail">
                        <div class="comment-detail-header">
                            <h3>Các đánh giá đã có</h3>
                        </div>
                        <div class="comment-detail-display">

                        <c:forEach items="${listComment}" var="o">
                        
                        <div class="comment-detail-content">
                            <img src="<c:url value="/img/anhdaidiennull.jpg"/>" alt="">
                            <div class="comment-detail-content-user">
                                <h3>${o.user.getuName()}</h3>
                                <p>${o.content}</p>
                            </div>
                            
                        </div>
                      </c:forEach>
                    </div>
                        
                       
                        
                    </div>
                </div>
                       
            </div>
        </div>
         </div>
        	<jsp:include page="footer.jsp"></jsp:include> 
        
         </div>
	<script src="<c:url value="/js/home.js"/>"></script>
	<script src="<c:url value="/js/detail.js"/>"></script>
</body>
</html>
