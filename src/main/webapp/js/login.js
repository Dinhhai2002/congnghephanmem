/**
 * 
 */
const username=document.querySelector("#username");
const pass=document.querySelector("#pass");
const form=document.querySelector("form")

//check validate input
function showError(input,message)
{
    let parent=input.parentElement;
    let small=parent.querySelector('small');
  
   input.classList.add("error");
   small.innerHTML=message;
    
}

function showSuccess(input)
{
    let parent=input.parentElement;
    let small=parent.querySelector('small');
  
   input.classList.remove("error");
   small.innerHTML='';
    
}

function checkEmptyError(ListInput) {
    let isEmptyError=false;

    ListInput.forEach(input => {
        input.value=input.value.trim()

        if(!input.value)
        {
            isEmptyError=true;
            showError(input,'Không được để trống');
        }
        else{
            showSuccess(input);
        }
    });
    return isEmptyError;
}

form.addEventListener("submit",function(e)
		{
//		    e.preventDefault();

		    let isEmptyError=checkEmptyError([username,pass,])
		 
		    if(isEmptyError)
		    {
		    	e.preventDefault();
		    }
		})