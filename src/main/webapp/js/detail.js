
$('.cart-qty').on("myCustomEvent", function(event, myName) {
	$("#noti")
		.stop()
		.css("opacity", 1)
		.text(myName)
		.fadeIn(40)
		.fadeOut(1000);
});

$("#cart-qty-plus").click(function() {
	avai = $('#QUAN').val();
	num = parseInt($(".cart-qty").text());
	if (num < avai) {
		$(".cart-qty").text(num + 1);
		return false
	}
	else {
		$(".cart-qty").trigger("myCustomEvent", ["Số lượng bạn chọn đã đạt mức tối đa của sản phẩm này"]);
	}
})


$("#cart-qty-minus").click(function() {
	num = parseInt($(".cart-qty").text());
	if (num == 1) {
		return false
	}
	$(".cart-qty").text(num - 1);
})

function replace() {
	num = parseInt($(".cart-qty").text());
	var pId = $('#PID').val();
	var x = '/Shopee/member/cart-add?pId=' + pId;
	x = x + '&quantity=' + num;
	location.href = x;
}
$(document).ready(function($) {

	//Use this inside your document ready jQuery 
	$(window).on('popstate', function() {
		location.reload(true);
	});

});

$(document).ready(function() {
	$("#addproductcart").click(function() {
		num = parseInt($(".cart-qty").text());
		var pId = $('#PID').val();
		$.ajax({
			type: "GET",
			url: "/Shopee/member/cart-add",
			data: {
				pId: pId,
				quantity: num,
				action: "addtocart"
			},
			success: function(data) {
				if (data == 'true') {
					alert('Đã thêm hàng vào giỏ');
				}else if (data == 'overquantity') {
					alert('Không thể thêm số lượng đã chọn vào giỏ hàng vì sẽ vượt quá giới hạn mua hàng của bạn.');
				} else {
					var x = '/Shopee/login';
					location.href = x;
				};

			},

		});
	});
});


//rate details product

//var xhttp;
//var username=document.Myform.usernamecomment.value;
//var content=document.Myform.content.value;
//var url="detail?content="+content;
//	if(window.XMLHttpRequest)
//		{
//			xhttp=new XMLHttpRequest();
//		}
//	else{
//		xhttp=new ActiveXObject("Microsoft.XMLHTTP");
//	}
//	
//	xhttp.onreadystatechange=function()
//	{
//		if(xhttp.readyState)
//			{
//				var data=xhttp.responseText;
//				document.querySelector(".comment-detail-display").innerHTML=data;
//			}
//		
//	}
//	xhttp.open("POST",url,true);
//	xhttp.send();


