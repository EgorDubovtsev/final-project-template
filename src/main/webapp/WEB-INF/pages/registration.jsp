<!DOCTYPE html>
	<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en" dir="ltr">
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
	<div class="regWindow">
		<form:form action="registration/proceed" method="post" modelAttribute="registrationForm" class="regFields">
			<h3>Регистрация нового пользователя</h3>
			 <form:input path="login" id="check_login" class="filterField regImpt" placeholder="Логин" title="Login" />
			<form:input path="password" id="check_password" class="filterField regImpt" placeholder="Пароль"  type="password" title="Password" />
			<button class="btn regBtn">Зарегестрироваться</button>
			<a href="login.html" class="haveAcc"> Уже есть аккаунт?</a>
		</form:form>
	</div>
</div>
</body>
</html>