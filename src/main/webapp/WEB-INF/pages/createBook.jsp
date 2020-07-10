<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Book Shop</title>
	<c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="${staticRoot}/resources/js/cart.js"></script>
	<script type="text/javascript" src="${staticRoot}/resources/js/main.js"></script>
	<script type="text/javascript" src="${staticRoot}/resources/js/validation.js"></script>
	<style>
       <%@include file='../../resources/css/main.css' %>
        <%@include file='../../resources/css/createBook.css' %>
        <%@include file='../../resources/css/cart.css' %>
    </style>
</head>
<body>
<div class="wallpaper" 
	style="background:url('${staticRoot}/resources/img/fom1.jpg') no-repeat;
		-webkit-background-size: cover;
    	-moz-background-size: cover;
    	-o-background-size: cover;
   		background-size: cover;"></div>
	<div class="userMenu">
		<span class="name">
			 ${name}
		</span>
		<div class="menuButtonWrapper">
			<form action="/logout" method="post" class="menuButton">
				<button>Log Out</button>
			</form>
		</div>
	</div>
	<form action="/" method="get" class="redirectButtonWrapper">
        <button class="link redirectButton">
            <span class="icon-home"></span>
        </button>
	</form>
	<div class="cartName">Добавить новую книгу</div>
	<div class="cartListOuter">
		<form:form class="cartListInner" action="/createBook/proceed" method="post" modelAttribute="createBookForm" >
			<div class="paramBook">
				<label>Название: </label>
				<form:input id="name-createBook" type="text" class="filterField" path="name"/>
			</div>
			<div class="paramBook">
				<label>Автор: </label>
				<form:input type="text" id="author-createBook"  class="filterField" path="author"/>
			</div>
			<div class="paramBook">
				<label>Жанр: </label>
				<form:select class="select" path="genre" id="genre-createBook">
					<option value="null" selected>Выберите жанр</option>
					<option value="Детектив">Детектив</option>
					<option value="Роман">Роман</option>
					<option value="Драмма">Драмма</option>
					<option value="Научная фантастика">Научная фантастика</option>
				</form:select>
			</div>			
				
			<div class="paramBook">
				<label>Год Издания: </label>
				<form:input type="text" class="filterField" valuer="0" path="publishYear" id="publishYear-createBook"/>
			</div>
			<div class="paramBook">
				<label>Цена: </label>
				<form:input type="text" class="filterField" value="0" path="price" id="price-createBook"/>
			</div>
			<div class="paramBook">
				<label>Описание: </label>
				<form:textarea path="description" class="bookDescription bigFont" id="bookDescription-createBook"></form:textarea>
			</div>
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