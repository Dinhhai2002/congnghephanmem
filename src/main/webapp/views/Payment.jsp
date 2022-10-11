<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
             <a href="#"> Go Bach Home</a>
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
                            <span class="header">Payment</span>
                            <div class="icons">
                                <img src="https://img.icons8.com/color/48/000000/visa.png"/>
                                <img src="https://img.icons8.com/color/48/000000/mastercard-logo.png"/>
                                <img src="https://img.icons8.com/color/48/000000/maestro.png"/>
                            </div>
                        </div>
                        <form>
                            <span>Cardholder's name:</span>
                            <input placeholder="Linda Williams">
                            <span>Card Number:</span>
                            <input placeholder="0125 6780 4567 9909">
                            <div class="row">
                                <div class="col-4"><span>Expiry date:</span>
                                    <input placeholder="YY/MM">
                                </div>
                                <div class="col-4"><span>CVV:</span>
                                    <input id="cvv">
                                </div>
                            </div>
                            <input type="checkbox" id="save_card" class="align-left">
                            <label for="save_card">Save card details to wallet</label>  
                        </form>
                    </div>                        
                </div>
                <div class="col-md-5">
                    <div class="right border">
                        <div class="header">Order Summary</div>
                        <p>2 items</p>
                        <div class="row item">
                            <div class="col-4 align-self-center"><img class="img-fluid" src="https://i.imgur.com/79M6pU0.png"></div>
                            <div class="col-8">
                                <div class="row"><b>$ 26.99</b></div>
                                <div class="row text-muted">Be Legandary Lipstick-Nude rose</div>
                                <div class="row">Qty:1</div>
                            </div>
                        </div>
                        <div class="row item">
                            <div class="col-4 align-self-center"><img class="img-fluid" src="https://i.imgur.com/Ew8NzKr.jpg"></div>
                            <div class="col-8">
                                <div class="row"><b>$ 19.99</b></div>
                                <div class="row text-muted">Be Legandary Lipstick-Sheer Navy Cream</div>
                                <div class="row">Qty:1</div>
                            </div>
                        </div>
                        <hr>
                        <div class="row lower">
                            <div class="col text-left">Subtotal</div>
                            <div class="col text-right">$ 46.98</div>
                        </div>
                        <div class="row lower">
                            <div class="col text-left">Delivery</div>
                            <div class="col text-right">Free</div>
                        </div>
                        <div class="row lower">
                            <div class="col text-left"><b>Total to pay</b></div>
                            <div class="col text-right"><b>$ 46.98</b></div>
                        </div>
                        <div class="row lower">
                            <div class="col text-left"><a href="#"><u>Add promo code</u></a></div>
                        </div>
                        <button class="btn">Place order</button>
                        <p class="text-muted text-center">Complimentary Shipping & Returns</p>
                    </div>
                </div>
            </div>
        </div>
        
     <div>
    </div>
    </div>
</body>
</html>