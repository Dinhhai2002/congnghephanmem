function fillterproduct() {

	let field = document.querySelector('.search-item-result__items');
	let li = Array.from(field.children);

	function SortProduct() {
		let select = document.getElementById('select');
		let ar = [];
		for (let i of li) {
			const last = i.querySelector(".search-item-result__item-price");
			if (last != null) {
				console.log(last);
				const x = last.textContent.trim();
				console.log(x);
				const y = Number(x.substring(1));

				console.log(y);
				i.setAttribute("data-price", y);
				ar.push(i);
			}

		}
		this.run = () => {
			addevent();
		}
		function addevent() {
			select.onchange = sortingValue;
		}
		function sortingValue() {

			if (this.value === 'Default') {
				while (field.firstChild) { field.removeChild(field.firstChild); }
				field.append(...ar);
			}
			if (this.value === 'LowToHigh') {
				function SortElem1(field, li) {
					let dm, sortli;

					sortli = li.sort((a, b) => {
						const ax = a.getAttribute('data-price');
						const bx = b.getAttribute('data-price');
						return ax - bx;
					});
					while (field.firstChild) { field.removeChild(field.firstChild); }
					field.append(...sortli);
				}
				new SortElem1(field, li);
				// SortElem(field, li, true)
			}
			if (this.value === 'HighToLow') {
				function SortElem2(field, li) {
					let dm, sortli;

					sortli = li.sort((a, b) => {
						const ax = a.getAttribute('data-price');
						const bx = b.getAttribute('data-price');
						return bx - ax;
					});
					while (field.firstChild) { field.removeChild(field.firstChild); }
					field.append(...sortli);
				}
				new SortElem2(field, li);
				// SortElem(field, li, false)
			}
		}

	}


	new SortProduct().run();
};
(function() {
	fillterproduct();
})();

//search item with ajax

/*function searchByName(param) {
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
}*/

//lazy loading more content with scroll - infinity scrolling
document.addEventListener("DOMContentLoaded", () => {
	let options = {
		root: null,
		rootMargins: "0px",
		threshold: 0.01
	};
	const observer = new IntersectionObserver(handleIntersect, options);
	observer.observe(document.querySelector("#moreP1"));
	observer.observe(document.querySelector("#moreP2"));
});

function handleIntersect(entries) {
	entries.forEach((entry) => {
		if (entry.isIntersecting) {
			console.warn("something is intersecting with the viewport");
			loadMore();
			//fillterproduct();
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
	let txtS = urlParams.get('txtS');
	if(!page){
		page="1";
	}
	let currentP = parseInt(page);
	//let currentCate = document.getElementById("currentCate").innerHTML;
	let amount = document.getElementsByClassName("col l-2-4 lo-3 m-4 c-6").length;
	let amountP = (currentP - 1) * maxContent + amount;
	if(txtS){
		if(amountP < maxContent * currentP){
			$.ajax({
			url: "/Shopee/loadPS",
			type: "get",
			data: {
				txtS: txtS,
				amount: amountP
			},
			success: function(data) {
				var row = document.getElementById("content");
				row.innerHTML += data;
			},
			error: function(xhr) {
				alert("Lỗi")
			}
			});
		}
	}else if (currentCate == "0" && (amountP < maxContent * currentP)) {
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
	} else if (currentCate != "0" && (amountP < maxContent * currentP)) {
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


