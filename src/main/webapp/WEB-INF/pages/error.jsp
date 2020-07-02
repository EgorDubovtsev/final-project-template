<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Book Shop</title>
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<style>
       <%@include file='../../css/main.css' %>
       <%@include file='../../css/registrationAndLogin.css' %>
    </style>
</head>
<body>
<div class="wallpaper" style="background:url('${staticRoot}/resources/img/fom1.jpg')"></div>
<div class="regPlace">
	<div class="logWindow">
	<h1>ERROR</h1>
	</div>
</div>
</body>
</html>