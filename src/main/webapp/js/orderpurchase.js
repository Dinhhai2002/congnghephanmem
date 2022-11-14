/**
 * 
 */

function editStatus(btn) {
	let id = btn.value;
	let statusName = btn.textContent;
	if (statusName === "Mua lại") {
		var x = '/Shopee/member/cart-add?pId=' + id;
		x = x + '&quantity='+1;
		location.href = x;
	}else{
		
		$.ajax({
		url: "/Shopee/member/statusorder", //send to Controller
		type: "get", //send it through get method
		data: {
			id: id,
			statusName: statusName
		},
		success: function(data) {
			
			$(btn).closest('tr').replaceWith(data);
		},
		error: function(xhr) {
			//Do Something to handle error
		}
	});
	}
	
}

function myMobileFunction(e) {
	if (document.querySelector('.row.no-gutters.search-item-result-on-mb-tb-list a.category-list__item-link-highlight') != null) {
		document.querySelector('.row.no-gutters.search-item-result-on-mb-tb-list a.category-list__item-link-highlight').classList.remove('category-list__item-link-highlight');
	}
	e.target.parentElement.className = "search-item-result-on-mb-tb-link category-list__item-link-highlight";	
}

function myFunction(e) {
	if (document.querySelector('.category-list__list a.category-list__item-link-highlight') != null) {
		document.querySelector('.category-list__list a.category-list__item-link-highlight').classList.remove('category-list__item-link-highlight');
	}
	e.target.className = "category-list__item-link category-list__item-link-highlight";
}





var scrollLimit = 500;  // Amount after which ajax() call initializes
var limit = 3;    // item count
var offset = 6;    // offset
$(window).on('scroll', function() {
	scrollPosition = $(this).scrollTop() + 550;
	if (scrollPosition >= scrollLimit) {
		// loadContent method in which ajax() call is defined
		scrollLimit = scrollLimit + 500;
		loadMore();
	}
});


function loadMore() {
	/* tạo viên amount để Gọi và đếm classname là product */
	var amount = document.getElementById("myTable").rows.length;
	$.ajax({
		url: "/Shopee/member/loadorder", //send to Controller
		type: "get", //send it through get method
		data: {
			action: text,
			exits: amount - 1
		},
		success: function(data) {
			$("table tbody").append(data);
		},
		error: function(xhr) {
			//Do Something to handle error
		}
	});
};

var text;
function purchase(e) {
	scrollLimit = 500
	text = e.textContent;
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
			if (result.length == 0) {
				temp += `<img src="https://icons.veryicon.com/png/o/miscellaneous/contribution/empty-box-1.png" alt="" style="width:90px; height:90px;">
							<p>Chưa có đơn hàng</p>`
			} else {
				for (var i = 0; i < result.length; i++) {
					console.log(result[i])
					var s = result[i].status.idStatus;
					html += `<tr style="margin: 8px 0;">`
					html += `<td>${result[i].product.pName}</td>`
					html += `<td><img src="${result[i].product.pImage}" style="width:90px; height:90px;"></td>`
					html += `<td>${result[i].totalPrice}</td>`
					
					if (s == 1 || s == 7) {
						html += `<td>Chờ xác nhận</td>`
						html += `<td><button id="orderStatus" onclick="editStatus(this)" value="${result[i].id}">Hủy đơn</button></td>`
					}else if (s == 4) {
						html += `<td>${result[i].status.nameStatus}</td>`
						html += `<td><button id="orderStatus" onclick="editStatus(this)" value="${result[i].id}">Đã nhận được hàng</button></td>`
					}else if (s == 9 || s == 5) {
						html += `<td>${result[i].status.nameStatus}</td>`
						html += `<td><button id="orderStatus" onclick="editStatus(this)" value="${result[i].product.pId}">Mua lại</button></td>`
					}else {
						html += `<td>${result[i].status.nameStatus}</td>`
					}
					
					html += `<td>`
                    html +=  `<h3 class="detail">Xem`
                    html +=  `<ul class="navbarItem__user-list-detail">`
                    html +=  `<li class="navbarItem__user-item">`
                    html +=  `<a href="" class="navbarItem__user-link">`
                    html +=  `Tên shop: ${result[i].order.shop.shopName}`
                    html +=  `</a>`
                    html +=  `</li>`
                    html +=  `<li class="navbarItem__user-item">`
                    html +=  `<a href="" class="navbarItem__user-link">`
                    html +=  `Địa chỉ shop: ${result[i].order.shop.shopAddress}`
                    html +=  `</a>`
                    html +=  `</li>`
                    html +=  `<li class="navbarItem__user-item">`
                    html +=  `<a href="" class="navbarItem__user-link">`
                    html +=  `Địa chỉ nhận hàng: ${result[i].order.uAddress}`
                    html +=  `</a>`
                    html +=  `</li>`
                    html +=  `</ul>`
                    html +=  `</h3>`                
                    html +=  `</td>`

					html += `</tr>`
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
