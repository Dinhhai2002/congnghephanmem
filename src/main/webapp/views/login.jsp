<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
<link href="<c:url value="/css/base.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/main.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/css/login.css"/>" rel="stylesheet"
	type="text/css" />

<link href='https://unpkg.com/boxicons@2.1.2/css/boxicons.min.css'
	rel='stylesheet'>
<title>Đăng nhập tài khoản</title>
</head>
<body>
	<input type=“hidden” name ="username" value=“<% request.getParameter("username"); %>”>
	<div class="modal">
		<div class="modal__overlay"></div>
		<div class="modal__body">
			<form action="login" method="post" class="authForm">
				<div class="authForm__body">
					<div class="authForm__header">
						<h3 class="authForm__heading">Đăng Nhập</h3>
						<a href="/Shopee/register" class="authForm__switch-btn"> Đăng
							Ký </a>
					</div>
					<div class="authForm__form">
						<h3 style="color:red;">${mess}</h3>
						<div class="authForm__group">
							<input id="username" value="${username}"name="username" type="text" class="authForm__input"
								placeholder="Nhập tên tài khoản" required>
								
						</div>
						<div class="authForm__group">
							<input id="pass" value="${pass}"name="password" type="password" class="authForm__input_password" placeholder="Nhập mật khẩu" required>
                            <div class="login-input-eye">
                                <!-- icon-hide -->
                                <a href="#" class="eye-open  "><i class='bx bx-show-alt'></i></a>
                                <a href="#" class="eye-close "><i class='bx bx-hide' ></i></a>
                            </div>
                           
						</div>
					</div>
					<div class="authForm__checkbox">
                        <input type="checkbox" id="1" name="remember" checked value="">
                            <label for="1"> Nhớ mật khẩu</label><br>
                    </div>
					<div class="authForm__policy">
						<div class="authForm__help">
							<a href="#"
								class="authForm__help-link authForm__help-forgot"> Quên Mật
								Khẩu </a> <span class="authForm__help-separate"></span> <a href="#"
								class="authForm__help-link"> Cần Trợ Giúp? </a>
						</div>
					</div>
					<div class="authForm__controls">
						<a href="/Shopee/home"class="btn btn-hover">TRỞ LẠI</a>
						<button type="submit" class="btn btn--primary ml-8">ĐĂNG
							NHẬP</button>
					</div>
				</div>
				<div class="authForm__social">
					 <a
						href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/Shopee/logingoogle&response_type=code
                        &client_id=965552027153-4qmaigfiko3ajcldouedsj1h9kts562i.apps.googleusercontent.com&approval_prompt=force"
						class="btn btn__social social__icon-gg"> 
						<img src="<c:url value="/img/g-normal.png"/>" alt="" class="authForm__social-img">
						 <span>
							Đăng nhập Google </span>
					</a>
				</div>
			</form>
		</div>
	</div>
	<form class="modal_select ">
		<div class="modal__overlay_select"></div>
		<div class="modal__body_select">
			<div class="authForm_select">
				<div class="authForm__body_select">
					<h3 class="authForm__header_select">
						Vui lòng chọn <a class="authForm__header_select_icon" href="#"><i
							class='bx bx-x'></i></a>
					</h3>

					<div class="authForm__controls_select">
						<a href="/Shopee/forgotPasswordSMS" class="btn select ">Xác nhận SMS</a>
						 <a href="/Shopee/forgotPasswordEmail"
							class="btn select ml-8">Xác nhận Gmail</a>
					</div>
				</div>

			</div>
		</div>
	</form>
	<script type="text/javascript">

	const btnpass=document.querySelector('.authForm__help-forgot');
	const modalSelect=document.querySelector('.modal_select');
	const modal=document.querySelector('.modal');
	const btnclose=document.querySelector('.authForm__header_select_icon');

	btnpass.addEventListener('click',add);
	btnclose.addEventListener('click',remove);

	function add(){
	   
	    modalSelect.classList.add("active");
	   
	    modal.classList.add("active");
	    
	}
	function remove(){
	    
	    modalSelect.classList.remove("active");
	   
	    modal.classList.remove("active");
	}

	// Show eye pass word
	const eyeOpen=document.querySelectorAll('.eye-open');
	const eyeClose=document.querySelectorAll('.eye-close');

	eyeClose.forEach(item => {
	    item.addEventListener('click',togglePassword);
	})
	eyeOpen.forEach(item => {
	    item.addEventListener('click',toggleText);
	})

	function toggleText(){
	    this.classList.remove('is-active');
	    const input=this.parentNode?.previousElementSibling;
	    if(input)
	    {
	        input.setAttribute("type","password");
	    }
	}

	function togglePassword(){
	    const Open=this.previousElementSibling;
	    const input=this.parentNode?.previousElementSibling;

	    if(Open)
	    {
	        Open.classList.add('is-active');
	    }
	    if(input)
	    {
	        input.setAttribute("type","text");
	    }
	    
	}
</script>
	

</body>
</html>