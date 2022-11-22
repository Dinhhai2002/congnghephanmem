/**
 * 
 */
const username=document.querySelector("#username");
const fullName=document.querySelector("#fullName");
const pass=document.querySelector("#pass");
const repass=document.querySelector("#repass");
const email=document.querySelector("#email");
const phoneNumber=document.querySelector("#phoneNumber");
const address=document.querySelector("#address");
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

function checkLengthError(input,min,max){
    input.value=input.value.trim();
    if(input.value.length <min){
        showError(input,`Phải có ít nhất ${min} kí tự`);
        return true;
    }
    if(input.value.length >max){
        showError(input,`Độ dài không vượt quá ${max} kí tự`);
        return true;
    }
    
    return false;

}

function checkEmail(input) {
    const regexEmail=/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    input.value=input.value.trim();
    let isEmailError=!regexEmail.test(input.value);
    if(regexEmail.test(input.value))
    {
        showSuccess(input);
    }
    else{
        showError(input,"email không hợp lệ");
    }
    return isEmailError;
}

function checkMatchPasswordError(pass,repass){
    pass.value=pass.value.trim();
    repass.value=repass.value.trim();
    if(pass.value != repass.value)
    {
        showError(repass,'mật khẩu không trùng khớp');
        return true;
    }
    return false;

}

form.addEventListener("submit",function(e)
{
//    e.preventDefault();

    let isEmptyError=checkEmptyError([username,fullName,pass,repass,email,phoneNumber,address])
    let isEmailError=checkEmail(email);
    let isLenghtUsername=checkLengthError(username,8,20);
    let isLenghtPassword=checkLengthError(pass,5,20);
    let isMatchpass=checkMatchPasswordError(pass,repass);
    if(isEmptyError|| isEmailError || isLenghtUsername || isLenghtPassword|| isMatchpass)
    {
    	e.preventDefault();
    }
})

    


