/**
 * 
 */

function createFaction() {
	var num = 1
	document.querySelector('.cart-qty').innerHTML = num;
}
$("#cart-qty-plus").click(function() {
	num = parseInt($(".cart-qty").text());
	$(".cart-qty").text(num + 1);
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
