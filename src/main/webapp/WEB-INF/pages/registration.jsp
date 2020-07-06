<!DOCTYPE html>
	<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en" dir="ltr">
<head>

	<title>Book Shop</title>
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
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
	<div class="regWindow">
		<div>
			<form:form action="registration/proceed" method="post" modelAttribute="registrationForm" class="regFields">
				<h3>Регистрация нового пользователя</h3>
				<form:input path="login" id="check_login" class="filterField regImpt" placeholder="Логин" title="Login" />
				<form:input path="password" id="check_password" class="filterField regImpt" placeholder="Пароль"  type="password" title="Password" />
				<form:input path="name" class="filterField regImpt" placeholder="Имя" title="Имя" />
	            <form:input path="birthdate" class="filterField regImpt" placeholder="Дата рождения" type="date" title="Дата рождения" />
	            <form:select path="role" class="filterField regImpt select">
	                <option value="MANAGER">Я менеджер</option>
	                <option value="USER" selected="selected">Я покупатель</option>
	            </form:select>
	            <div class="errorWrapperLogin sml">
	            	<span class="errorMessage">${errorMessage}</span>
				</div>
				<button class="btn regBtn">Зарегестрироваться</button>

			</form:form>
			<form:form action="/login" method="get" class="redirectButtonWrapper">
	        	<button class="link"> Уже есть аккаунт?</button>
	        </form:form>
        </div>
	</div>
</div>
</body>
</html>