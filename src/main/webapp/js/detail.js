
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
	var action = "buynow";
	var x = '/Shopee/member/cart-add?pId=' + pId;
	x = x + '&quantity=' + num;
	x = x + '&action=' + action;
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
			url: "member/cart-add",
			data: {
				pId: pId,
				quantity: num,
				action: "addtocart"
			},
			success: function(data) {
				if (data == 'true') {
					alert('đã thêm hàng vào giỏ');
				} else if (data = "overquantity") {
					alert('Không thể thêm số lượng đã chọn vào giỏ hàng vì sẽ vượt quá giới hạn mua hàng của bạn.');
				} else {
					var x = '/Shopee/login';
					location.href = x;
				};
			},


		});
	});
});

