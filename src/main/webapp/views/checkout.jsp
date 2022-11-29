<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <link href="<c:url value="/css/payment.css"/>" rel="stylesheet"
	type="text/css" />
    <title>Thanh toán</title>
</head>
<body>
    <div class="card">
        <div class="card-top border-bottom text-center">
             <a href="#"> Quay về trang chủ</a>
            <span id="logo">Trang Thanh Toán</span>
        </div>
        <div class="card-body">
            <div class="row upper">
                <span><i class="fa fa-check-circle-o"></i> Shopping bag</span>
                <span><i class="fa fa-check-circle-o"></i> Order details</span>
                <span id="payment"><span id="three">3</span>Payment</span>
            </div>
            <div class="row">
                <div class="col-md-7">
                    <div class="left border">
                        <div class="row">
                            <span class="header">Thanh toán</span>
                            <div class="icons">
                                <img src="https://img.icons8.com/color/48/000000/visa.png"/>
                                <img src="https://img.icons8.com/color/48/000000/mastercard-logo.png"/>
                                <img src="https://img.icons8.com/color/48/000000/maestro.png"/>
                            </div>
                        </div>
                       <form action="/Shopee/member/pay" method="post">
                       
                        	<h5>Thông tin địa chỉ giao hàng</h5>
                            <span>Họ và tên:</span>
          
                            <input type="text" value="${acc.uFullName}" id="username" name="name" required>
                            <span>Số điện thoại</span>
                            <input type="text" value="${acc.uPhone}" id="phone" name="phone" required>
                             <span>Tỉnh/ Thành phố, Quận/Huyện, Phường/Xã</span>
                            <input type="text" value="${acc.uFullAddress}" id="address" name="address" required>
                         <!--    <div class="row">
                                <div class="col-4"><span>Expiry date:</span>
                                    <input placeholder="YY/MM">
                                </div>
                                <div class="col-4"><span>CVV:</span>
                                    <input id="cvv">
                                </div>
                            </div> -->
                           <!--  <input type="checkbox" id="save_card" class="align-left">
                            <label for="save_card">Save card details to wallet</label>   -->
                        
                          <div class="col-lg-6">
							<div
								class="font-weight-bold">PHƯƠNG THỨC THANH TOÁN</div>
							<div class="p-4">
								<select name="payment" id="">
									<option value="offline">Thanh toán khi nhận hàng</option>
									<option value="online">Thanh toán bằng MoMo</option>
								</select>
							</div>
						</div>
                
                    </div>                        
                </div>
                <div class="col-md-5">
                    <div class="right border">
                        <div class="header">Sản phẩm</div>
                        
                        <p>${sessionScope.cart.key}</p>
                        <c:forEach items="${sessionScope.cart}" var="map">
                        <div class="row item">
                            <div class="col-4 align-self-center"><img class="img-fluid" src="${map.value.product.pImage}"></div>
                            <div class="col-8">
     <!--  tien-->              <div class="row"><b>Đơn giá:<fmt:formatNumber type="number" pattern="#,###" value="${map.value.product.pPrice}"></fmt:formatNumber>vnđ </b></div>
                                <div class="row text-muted">${map.value.product.pName}</div>
                                <div class="row">Sô lượng:${map.value.count}</div>
                                 <div class="row">Thành tiền:<fmt:formatNumber type="number" pattern="#,###" value="${map.value.product.pPrice * map.value.count}"></fmt:formatNumber>vnđ</div>
                            </div>
                        </div>
                         </c:forEach>
                       
                        <hr>
                        <div class="row lower">
                           <!--  <div class="col text-left">Thành tiền</div> -->
                            <c:set var="total" value="${0}"/>
										<c:forEach 
											items="${sessionScope.cart}" var="map">
											<c:set var="total"
											value="${total + map.value.product.pPrice * map.value.count }"/>
											</c:forEach>

                            <div class="col text-right"><fmt:formatNumber type="number" pattern="#,###" value="${total}"></fmt:formatNumber>vnđ</div>
                        </div>
                        <%-- <div class="row lower">
                            <div class="col text-left">Phí vận chuyển</div>
                            <div class="col text-right">10000 vnđ</div>
                        </div> -->
                        <div class="row lower">
                            <div class="col text-left"><b>Tổng số tiền</b></div>
                            <div class="col text-right"><b>${total} vnđ</b></div>
                        </div>
                       
                       <!--  <div class="row lower">
                            <div class="col text-left"><a href="#"><u>Thêm mã giảm giá</u></a></div>
                        </div> --%>
                        <input type="submit" value="Đặt hàng" />
                       <!--  <a href="Shopee/member/checkout" class="btn">Đặt hàng</a> -->
                        </form>
                       <!--  <p class="text-muted text-center">Giao hàng & Trả hàng Miễn phí</p>   -->  
                        
                    </div>                                                                           
                </div>
                
                
                    
                
            </div>
        </div>           
     <div>
    </div>
    </div>
</body>
</html>