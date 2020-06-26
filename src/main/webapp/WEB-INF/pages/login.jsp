<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Book Shop</title>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<style>
       <%@include file='../../css/main.css' %>
       <%@include file='../../css/registrationAndLogin.css' %>
    </style>
</head>
<body>
<div class="wallpaper"></div>
<div class="regPlace">
	<div class="logWindow">
		<form class="regFields" action="login/process" method="post">
			<h3>Укажите данные для входа</h3>
			<input class="filterField regImpt" placeholder="Логин" type="text" name="login">
			<input class="filterField regImpt" placeholder="Пароль" type="password" name="password">
			<div class="error">${error_login_placeholder}</div>
			<input type="submit" href="#" class="btn regBtn" value="Войти" />
		</form>
		<form action="registration" method="get">
        	<input type="submit" href="registration.html" class="haveAcc" value="Еще нет аккаунта?">
        </form>
	</div>
</div>
</body>
</html>