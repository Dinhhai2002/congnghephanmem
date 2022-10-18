/**
 * 
 */
 
//filter price
(function() {
	
    let field = document.querySelector('.search-item-result__items');
    let li = Array.from(field.children);

  

    function SortProduct() {
        let select = document.getElementById('select');
        let ar = [];
        for(let i of li){
            const last = i.querySelector(".search-item-result__item-price");
            const x = last.textContent.trim();
            console.log(x);
            const y = Number(x.substring(1));
           
            console.log(y);
            i.setAttribute("data-price", y);
            ar.push(i);
        }
        this.run = ()=>{
            addevent();
        }
        function addevent(){
            select.onchange = sortingValue;
        }
        function sortingValue(){
        
            if (this.value === 'Default') {
                while (field.firstChild) {field.removeChild(field.firstChild);}
                field.append(...ar);	
            }
            if (this.value === 'LowToHigh') {
                SortElem(field, li, true)
            }
            if (this.value === 'HighToLow') {
                SortElem(field, li, false)
            }
        }
        function SortElem(field,li, asc){
            let  dm, sortli;
            dm = asc ? 1 : -1;
            sortli = li.sort((a, b)=>{
                const ax = a.getAttribute('data-price');
                const bx = b.getAttribute('data-price');
                return ax > bx ? (1*dm) : (-1*dm);
            });
             while (field.firstChild) {field.removeChild(field.firstChild);}
             field.append(...sortli);	
        }
    }

    
    new SortProduct().run();
})();
 
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
	threshold: 0.05
	};
	const observer = new IntersectionObserver(handleIntersect, options);
	observer.observe(document.querySelector("footer"));
});

function handleIntersect(entries){
	if(entries[0].isIntersecting){
		console.warn("something is intersecting with the viewport");
		loadMore();
	}
}

//loadmore with ajax
function loadMore() {
	var amount = document.getElementsByClassName("col l-2-4 lo-3 m-4 c-6").length;
	$.ajax({
		url: "/Shopee/load",
		type: "get",
		data: {
			amount: amount
		},
		success: function(data) {
			var row = document.getElementById("content")
			row.innerHTML += data;
		},
		error: function(xhr) {

		}
	});
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


