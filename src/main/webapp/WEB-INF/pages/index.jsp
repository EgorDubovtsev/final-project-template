<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html dir="ltr">
<head>
	<title>Book Shop</title>
    <c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/script.js"></script>
	<style>
         <%@include file='../../resources/css/main.css' %>
         <%@include file='../../resources/css/registrationAndLogin.css' %>
    </style>
</head>
<body>
<div class="wallpaper" style="background:url('${staticRoot}/img/fom1.jpg')"></div>
	<div class="userMenu">
		<span class="name" id="login">
			 ${name}
		</span>
		<div class="menuButtonWrapper">
			<c:if test="${admin != null}">
	            <form action="/createBook" method="get" class="menuButton">
	                <button>Создать книгу</button>
	            </form>
			</c:if>
			<form action="/logout" method="post" class="menuButton">
				<button>Log Out</button>
			</form>
		</div>
	</div>
	<span>
		<form action="/cart" class="cart">
            <button class="link toCart">
                <span class="itemCouter" id="counter">0</span>
                <span class="icon-cart"></span>
            </button>
		</form>
	</span>
	<div class="mainName">Book Shop</div>
	<form class="search">
		<input type="text" placeholder="Название книги" name="search" id="searchLine">
		<a href="#" id="searchButton">Найти</a>
	</form>
	<div class="filters">
		<div class="filterColumn">
			<label>Автор: <input type="text" name="author" class="filterField"></label>
		</div>
		<div class="filterColumn">
			<label>Жанр:
				<select class="filterField">
					<option selected="selected">Выберите жанр</option>
					<option>Детектив</option>
					<option>Роман</option>
					<option>Драмма</option>
					<option>Научная фантастика</option>
				</select>
			</label>
		</div>
		<div class="filterColumn">
			<label>Цена до: <input type="number" name="price" class="filterField"></label>
		</div>
	</div>
		<div id="windowBack" class="windowBack"></div>
		<form  method="get" id="window" class="window">
			<div id="closeWindow" class="closeWindow" coursor="pointer">
				<a class="bigFont link">X</a> 
			</div>
			<img class="bookPictureInWindow" src="${staticRoot}/img/book.jpg">
			<div class="bookDescription">
				<h3 id="bookNameInPopup" class="bookName"></h3>
				<p  class="descElement">Автор: <span id="bookAuthorInPopup"></span></p>
				<p  class="descElement">Жанр: <span id="bookGenreInPopup"></span></p>
				<p  class="descElement">Год издания: <span id="bookPublishYearInPopup"></span></p>
				<p id="bookDescriptionInPopup" class="descElement sml"></p>

				<div class="price">
					<span id="bookPriceInPopup"></span>руб.
				</div>
				<a id="addToCart" class="btn addButton">Добавить в корзину</a>
			</div>
		</form>
	<div class="allBooks">
		<div class="space"></div>
		<div class="booksList">
			 <c:forEach items="${booksList}" var="book">
                	<button class="link bookEntity" name='open' value='${book.getName()}'>
	                	<div class="book">
			                <div class="bookPictureWrapper">
			                     <img class="bookPicture" src="${staticRoot}/img/book.jpg">
			                 </div>
			                 <h3 class="bookName">${book.getName()}</h3>
		                 </div>
	                 </button>
			 </c:forEach>
		</div>
	</div>
	<div class="searchResults">
		<h2 class="resultText">Результаты по запросу N</h2>
		<div class="booksList">
			<div class="book">
				<div class="bookPicture"></div>
				<h3 class="bookName">Nicomachean Ethics – Aristotle</h3>
			</div>
			<div class="book">
				<div class="bookPicture"></div>
				<h3 class="bookName">Nicomachean Ethics – Aristotle</h3>
			</div>
			<div class="book">
				<div class="bookPicture"></div>
				<h3 class="bookName">Nicomachean Ethics – Aristotle</h3>
			</div>
			<div class="book">
				<div class="bookPicture"></div>
				<h3 class="bookName">Nicomachean Ethics – Aristotle</h3>
			</div>
			<div class="book">
				<div class="bookPicture"></div>
				<h3 class="bookName">Nicomachean Ethics – Aristotle</h3>
			</div>
		</div>
	</div>
</body>
</html>