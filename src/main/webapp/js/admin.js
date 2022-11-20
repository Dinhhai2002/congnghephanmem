/**
 * 
 */
let selectImage=document.getElementById('idImage');
const text=document.getElementById('text');
const file=document.getElementById('file');

selectImage.onchange=displayvaluechange;
function displayvaluechange(){
    if(this.value=="link")
    {
        text.style.display="block";
        file.style.display="none";
        file.name="image1";
        text.name="image";
    }
    if(this.value=="file")
    {
        file.style.display="block";
        text.style.display="none";
        text.name="image1";
        file.name="image";
    }
    
}
// add hovered class to selected list item
let list = document.querySelectorAll(".navigation li");

function activeLink() {
  list.forEach((item) => {
    item.classList.remove("hovered");
  });
  this.classList.add("hovered");
}

list.forEach((item) => item.addEventListener("mouseover", activeLink));

// Menu Toggle
let toggle = document.querySelector(".toggle");
let navigation = document.querySelector(".navigation");
let main = document.querySelector(".main");

toggle.onclick = function () {
  navigation.classList.toggle("active");
  main.classList.toggle("active");
};

function deleteCategoryModal(param) {
	document.getElementById('deleteId').setAttribute('value', param);
	$("#deleteCategoryModal").modal('show');
}

function editCategoryModal(param) {
	editCategory(param);
	$("#editCategoryModal").modal('show');
}

function editCategory(param){
	$.ajax({
		url: "/Shopee/admin/category/edit",
		type: 'GET',
		contentType: 'application/json',
		data: {
			id: param
		},
		success: function(result) {	
			console.log(result);	
			document.getElementById('editId').setAttribute('value', result.cId);
			document.getElementById('editName').setAttribute('value', result.cName);
			if(result.cImage.includes('https')){
				document.getElementById('editImage').setAttribute('src', result.cImage);
			}else{
				document.getElementById('editImage').setAttribute('src', 'http://localhost:8080/Shopee/image?fname=' + result.cImage);
			}
				
		},
		error: function() {
			alert("Lỗi không lấy được dữ liệu")
		}
	});
}

function deleteProductModal(param) {
	document.getElementById('deletepId').setAttribute('value', param);
	$("#deleteProductModal").modal('show');
}

function returnProductIdValue(){
	document.getElementById('deleteId').setAttribute('value', 0);
}

function editProductModal(param) {
	editProduct(param);
	$("#editProductModal").modal('show');
}

function editProduct(param){
	$.ajax({
		url: "/Shopee/admin/product/edit",
		type: 'GET',
		contentType: 'application/json',
		data: {
			id: param
		},
		success: function(result) {	
			console.log(result);
			document.getElementById('editpId').setAttribute('value', result.pId);
			document.getElementById('editpName').setAttribute('value', result.pName);
			if(result.pImage.includes('https')){
				document.getElementById('editpImage').setAttribute('src', result.pImage);
			}else{
				document.getElementById('editpImage').setAttribute('src', 'http://localhost:8080/Shopee/image?fname=' + result.pImage);
			}
			document.getElementById('editpPrice').setAttribute('value', result.pPrice);
			document.getElementById('editpQuantity').setAttribute('value', result.pQuantity);
			document.getElementById('editpDescription').innerHTML = result.pDescription;
			var select = document.getElementById('editpCategory');
			var option;
			for (var i=0; i<select.options.length; i++) {
  				option = select.options[i];

  				if (option.text === result.category.cName) {
     			option.setAttribute('selected', true);
     			// For a single select, the job's done
     			return; 
  				} 
			}
			
		},
		error: function() {
			alert("Lỗi không lấy được dữ liệu")
		}
	});
}

window.onload = function()
{
    addProductError();
};
 
function addProductError()
{
	let queryString = window.location.search;
	let urlParams = new URLSearchParams(queryString);
	let error = urlParams.get('error');
	
	if(error === "1")
	{
		alert("Thêm không thành công. Vui lòng chọn ảnh sản phẩm");
	}else if(error === "2"){
		alert("Có lỗi xảy ra khi chỉnh sửa. Vui lòng thử lại sau");
	}else if(error === "3"){
		alert("Có lỗi xảy ra. Vui lòng thử lại sau");
	}
}


