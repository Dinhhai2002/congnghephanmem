/**
 * 
 */

function myFunction(e) {
	if (document.querySelector('.category-list__list a.category-list__item-link-highlight') !== null) {
		document.querySelector('.category-list__list a.category-list__item-link-highlight').classList.remove('category-list__item-link-highlight');
	}
	e.target.className = "category-list__item-link category-list__item-link-highlight";
}

function purchase(e) {
	var text = e.textContent;
	text = text.trim();
	var html = ""; //declare this
	var temp = ""; //declare this
	$.ajax({
		url: "/Shopee/member/purchase",
		type: 'GET',
		contentType: 'application/json',
		data: {
			action: text
		},
		success: function(result) {
			console.log(text)
			if (result.length == 0) {
				temp += `<img src="https://icons.veryicon.com/png/o/miscellaneous/contribution/empty-box-1.png" alt="" style="width:90px; height:90px;">
							<p>Chưa có đơn hàng</p>`
			} else {
				for (var i = 0; i < result.length; i++) {
					html += `<tr style="margin: 8px 0;">`
					html += `<td>${result[i].product.pName}</td>`
					html += `<td><img src="${result[i].product.pImage}" style="width:90px; height:90px;"></td>`
					html += `<td>${result[i].totalPrice}</td>`
					html += `<td>${result[i].status.nameStatus}</td>`
				}
			}
			$("table tbody").html(html) //add result inside 
			$(".home-product-shipping").html(temp)
			
		},
		error: function() {
			alert("Lỗi không lấy được dữ liệu")
		}
	});
}
