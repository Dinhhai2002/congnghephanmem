/**
 * 
 */

function add()
{
    number=Number.parseInt(document.querySelector('.model_quantity_number_quan').innerHTML)
    document.querySelector('.model_quantity_number_quan').innerHTML=number+1;
}
function remove(){
    number=Number.parseInt(document.querySelector('.model_quantity_number_quan').innerHTML)
    if(number>0)
    {

        document.querySelector('.model_quantity_number_quan').innerHTML=number-1;
    }
    else{
        alert("Không thực hiện được thao tác")
    }
}
document.querySelector('.model_quantity_number_add').addEventListener("click",add)
document.querySelector('.model_quantity_number_remove').addEventListener("click",remove)