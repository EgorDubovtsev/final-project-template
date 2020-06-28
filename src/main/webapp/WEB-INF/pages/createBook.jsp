<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Book Shop</title>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/script.js"></script>
	<style>
       <%@include file='../../css/main.css' %>
        <%@include file='../../css/createBook.css' %>
        <%@include file='../../css/cart.css' %>
    </style>
</head>
<body>
	<div class="wallpaper"></div>
	<div class="userMenu">
		<div class="name">
			<a href="#">User 1</a>
		</div>
		<div class="exit">
			<a href="#">Log Out</a>
		</div>
	</div>
	<form action="/" method="get">

            <button class="link toShop">
                <span class="icon-home"></span>
            </button>

	</form>
	<div class="cartName">Добавить новую книгу</div>
	<div class="cartListOuter">
		<form class="cartListInner">
			<div class="paramBook">
				<label>Название: </label>
				<input type="text" maxlength="50" class="filterField" name="bookNameCreate">
			</div>
			<div class="paramBook">
				<label>Автор: </label>
				<input type="text" maxlength="30"class="filterField" name="bookAuthorCreate">
			</div>
			<div class="paramBook">
				<label>Год Издания: </label>
				<input type="number" class="filterField" name="bookYearCreate">
			</div>
			<div class="paramBook">
				<label>Цена: </label>
				<input type="number" class="filterField" name="priceCreate">
			</div>
			<div class="paramBook">
				<label>Описание: </label>
				<textarea name="description" maxlength="200" class="descCreate"></textarea>
			</div>
			<div class="paramBook">
				<label>Изображение </label>
				<input type="file" class=" fileInput" name="priceCreate">
			</div>
			<div class="saveWrapper">
				<a href="#" class="btn saveBtn">Сохранить</a>
			</div>
		</form>
	</div>
</body>
</html>