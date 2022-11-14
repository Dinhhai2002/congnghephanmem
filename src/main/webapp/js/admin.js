/**
 * 
 */
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
		url: "/Shopee/editcategory",
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
