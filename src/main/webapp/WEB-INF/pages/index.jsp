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
	<script type="text/javascript" src="${staticRoot}/js/popup.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/pagination.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/cart.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/searchBook.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/main.js"></script>
	<style>
         <%@include file='../../resources/css/main.css' %>
         <%@include file='../../resources/css/registrationAndLogin.css' %>
    </style>
</head>
<body>
<div class="wallpaper" 
	style="background:url('${staticRoot}/img/fom1.jpg') no-repeat;
		-webkit-background-size: cover;
    	-moz-background-size: cover;
    	-o-background-size: cover;
   		background-size: cover;"></div>
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
		<form action="/cart" class="redirectButtonWrapper">
            <button class="link redirectButton">
                <span class="itemCouter" id="counter">0</span>
                <span class="icon-cart"></span>
            </button>
		</form>
	<div class="mainName">Book Shop</div>
	<form class="search">
		<input type="text" placeholder="Название книги" name="search" id="searchLine">
		<a id="searchButton">Найти</a>
	</form>
	<div class="filters">
		<div class="filterColumn">
			<label>Автор: <input type="text" id="author" class="filterField"></label>
		</div>
		<div class="filterColumn">
			<label>Жанр:
				<select class="filterField" id="genre">
					<option value="" selected="selected">Выберите жанр</option>
					<option value="Детектив">Детектив</option>
					<option value="Роман">Роман</option>
					<option value="Драмма">Драмма</option>
					<option value="Научная фантастика">Научная фантастика</option>
				</select>
			</label>
		</div>
		<div class="filterColumn">
			<label>Цена до: <input type="text" id="price" class="filterField"></label>
		</div>
	</div>
		<div id="windowBack" class="windowBack"></div>
		<form  method="get" id="window" class="window">
			<div id="closeWindow" class="closeWindow" coursor="pointer">
				<a class="bigFont link">X</a> 
			</div>
			<img class="bookPictureInWindow" src="${staticRoot}/img/book.png">
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
		<div class="booksList">
			 <c:forEach items="${booksList}" var="book">
                	<button class="link bookEntity" name='open' value='${book.getName()}'>
	                	<div class="book">
			                <div class="bookPictureWrapper">
			                     <img class="bookPicture" src="${staticRoot}/img/book.png">
			                 </div>
			                 <h3 class="bookName">${book.getName()}</h3>
		                 </div>
	                 </button>
			 </c:forEach>
		</div>
		<div class="pagination">
			<div class="paginationButtonsWrapper"></div>
		</div>	
	</div>
</body>
</html>