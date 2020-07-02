<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Book Shop</title>
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/script.js"></script>
	<style>
       <%@include file='../../resources/css/main.css' %>
        <%@include file='../../resources/css/createBook.css' %>
        <%@include file='../../resources/css/cart.css' %>
    </style>
</head>
<body>
<div class="wallpaper" style="background:url('${staticRoot}/resources/img/fom1.jpg')"></div>
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
		<form:form class="cartListInner" action="/createBook/proceed" method="post" modelAttribute="createBookForm" >
			<div class="paramBook">
				<label>Название: </label>
				<form:input type="text" maxlength="50" class="filterField" path="name"/>
			</div>
			<div class="paramBook">
				<label>Автор: </label>
				<form:input type="text" maxlength="30" class="filterField" path="author"/>
			</div>
			<div class="paramBook">
				<label>Жанр: </label>
				<form:select class="select" path="genre">
					<option value="null" selected>Выберите жанр</option>
					<option value="Детектив">Детектив</option>
					<option value="Роман">Роман</option>
					<option value="Драмма">Драмма</option>
					<option value="Научная фантастика">Научная фантастика</option>
				</form:select>
			</div>			
				
			<div class="paramBook">
				<label>Год Издания: </label>
				<form:input type="number" class="filterField" path="publishYear"/>
			</div>
			<div class="paramBook">
				<label>Цена: </label>
				<form:input type="number" class="filterField" path="price"/>
			</div>
			<div class="paramBook">
				<label>Описание: </label>
				<form:textarea path="description" maxlength="200" class="bookDescription" ></form:textarea>
			</div>
			<%--<div class="paramBook">
				<label>Изображение </label>
				<input type="file" class=" fileInput" title="bookImage">
			</div>--%>

			<div class="saveWrapper">
				<div class="errorWrapperLogin">
					<span class="errorMessage">${errorMessage}</span>
				</div>
				<button class="btn saveBtn">Сохранить</button>
			</div>
		</form:form>
	</div>
</body>
</html>