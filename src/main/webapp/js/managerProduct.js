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

function deleteModal(param) {
	document.getElementById('deleteId').setAttribute('value', param);
	$("#deleteProductModal").modal('show');
}

function returnValue(){
	document.getElementById('deleteId').setAttribute('value', 0);
}

$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});
