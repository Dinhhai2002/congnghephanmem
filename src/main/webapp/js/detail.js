/**
 * 
 */

function add()
{
   	this.number=Number.parseInt(document.querySelector('.model_quantity_number_quan').innerHTML)
   	this.number++;
    document.querySelector('.model_quantity_number_quan').innerHTML=this.number;
}
function remove(){
    this.number=Number.parseInt(document.querySelector('.model_quantity_number_quan').innerHTML)
    if(number>0)
    {
		this.number--;
        document.querySelector('.model_quantity_number_quan').innerHTML=this.number;
    }
    else{
        alert("Không thực hiện được thao tác")
    }
}
document.querySelector('.model_quantity_number_add').addEventListener("click",add)
document.querySelector('.model_quantity_number_remove').addEventListener("click",remove)