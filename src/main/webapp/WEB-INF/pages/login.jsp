
<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Book Shop</title>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<script type="text/javascript" src="${staticRoot}resources/js/main.js"></script>
	<style>
       <%@include file='../../resources/css/main.css' %>
       <%@include file='../../resources/css/registrationAndLogin.css' %>
    </style>
</head>
<body>
<div class="wallpaper" 
	style="background:url('${staticRoot}/resources/img/fom1.jpg') no-repeat;
		-webkit-background-size: cover;
    	-moz-background-size: cover;
    	-o-background-size: cover;
   		background-size: cover;"></div>
<div class="regPlace">
	<div class="logWindow">
		<div class="regFields">
			<form  class="regFields" action="login/process" method="post">
				<h3>Укажите данные для входа</h3>
				<input class="filterField regImpt" placeholder="Логин" authentication-success-handler-ref="fullyAccessHandlerService" type="text" name="login">
				<input class="filterField regImpt" placeholder="Пароль" type="password" name="password">
				<div class="errorWrapperLogin sml">	<span class="errorMessage">${errorMessage}</span>
				</div>
				<button type="submit" href="#" class="btn regBtn">Войти</button>
			</form>
			<form action="registration" method="get" class="redirectButtonWrapper ">
	        	<input type="submit" class="link haveAcc" value="Еще нет аккаунта?">
	        </form>
        </div>
	</div>
	<div class="toast success" id="toast">
		Регистрация прошла успешно
	</div>
</div>
</body>
</html>