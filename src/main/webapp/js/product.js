/**
 * 
 */

//search item with ajax

function searchByName(param) {
	var txtS = param.value;
	$.ajax({
		url: "/Shopee/search",
		type: "get",
		data: {
			txtS: txtS
		},
		success: function(data) {
			var row = document.getElementById("content")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
}

//lazy loading more content with scroll - infinity scrolling
document.addEventListener("DOMContentLoaded", () => {
	let options = {
		root: null,
		rootMargins: "0px",
		threshold: 0.01
	};
	const observer = new IntersectionObserver(handleIntersect, options);
	observer.observe(document.querySelector("footer"));
});

function handleIntersect(entries) {
	entries.forEach((entry) => {
		if (entry.isIntersecting) {
			console.warn("something is intersecting with the viewport");
			loadMore();
		}
	});
}

//loadmore with ajax
function loadMore() {
	let maxContent = 35;
	let queryString = window.location.search;
	let urlParams = new URLSearchParams(queryString);
	let page = urlParams.get('page');
	let currentCate = urlParams.get('index');
	//let current = document.getElementById("currentPage").innerHTML;
	let currentP = parseInt(page);
	//let currentCate = document.getElementById("currentCate").innerHTML;
	let amount = document.getElementsByClassName("col l-2-4 lo-3 m-4 c-6").length;
	let amountP = (currentP - 1) * maxContent + amount;
	if (currentCate=="0" && (amountP < maxContent * currentP)) {
		$.ajax({
			url: "/Shopee/load",
			type: "get",
			data: {
				amount: amountP
			},
			success: function(data) {
				var row = document.getElementById("content");
				row.innerHTML += data;
			},
			error: function(xhr) {

			}
		});
	}else if(currentCate!="0" && (amountP < maxContent * currentP)){
		$.ajax({
			url: "/Shopee/loadPC",
			type: "get",
			data: {
				cid: currentCate,
				amount: amountP
			},
			success: function(data) {
				var row = document.getElementById("content");
				row.innerHTML += data;
			},
			error: function(xhr) {

			}
		});
	}
}

/*var cId = 1;
//category with ajax
function cateAjax(cateId) {
	$.ajax({
		url: "/Shopee/category",
		type: "get",
		data: {
			cid: cateId
		},
		success: function(data) {
			var row = document.getElementById("content")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
	document.getElementById(cId).classList.remove("active");
	document.getElementById(cateId).classList.add("active");
	cId = cateId;

}


//paging with ajax
$(document).on('click', '.pagination-item-link', function() {
	//lấy phần tử bấm chuột - chính là  $(".example1")
	var index = $(this);
	//lấy nội dung
	var htmlcontent = index.text();
	$.ajax({
		url: "/Shopee/pagingAjax",
		type: "get",
		data: {
			index: htmlcontent
		},
		success: function(data) {
			var row = document.getElementById("content")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
	$.ajax({
		url: "/Shopee/page",
		type: "get",
		data: {
			index: htmlcontent
		},
		success: function(data) {
			var row = document.getElementById("page")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
});

$(document).on('click', '.bx-chevron-left', function() {
	var index = $(this);
	//lấy nội dung
	var htmlcontent = index.text();
	$.ajax({
		url: "/Shopee/pagingAjax",
		type: "get",
		data: {
			index: htmlcontent
		},
		success: function(data) {
			var row = document.getElementById("content")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
	$.ajax({
		url: "/Shopee/page",
		type: "get",
		data: {
			index: htmlcontent
		},
		success: function(data) {
			var row = document.getElementById("page")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
});

$(document).on('click', '.bx-chevron-right', function() {
	var index = $(this);
	var htmlcontent = index.text();
	$.ajax({
		url: "/Shopee/pagingAjax",
		type: "get",
		data: {
			index: htmlcontent
		},
		success: function(data) {
			var row = document.getElementById("content")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
	$.ajax({
		url: "/Shopee/page",
		type: "get",
		data: {
			index: htmlcontent
		},
		success: function(data) {
			var row = document.getElementById("page")
			row.innerHTML = data;
		},
		error: function(xhr) {

		}
	});
});*/
