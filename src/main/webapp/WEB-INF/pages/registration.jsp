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
			<form:input path="name" class="filterField regImpt" placeholder="Имя" title="Имя" />
            <form:input path="birthdate" class="filterField regImpt" placeholder="Дата рождения" type="date" title="Дата рождения" />
            <form:select path="role" class="filterField regImpt">
                <option value="MANAGER">Я менеджер</option>
                <option value="USER" selected="selected">Я покупатель</option>
            </form:select>
			<button class="btn regBtn">Зарегестрироваться</button>

		</form:form>
		<form:form action="/login" method="get">
        	<button> Уже есть аккаунт?</button>
        </form:form>
	</div>
</div>
</body>
</html>