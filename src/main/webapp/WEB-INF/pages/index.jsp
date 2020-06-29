<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html dir="ltr">
<head>
	<title>Book Shop</title>

	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="../../js/script.js"></script>
	<style>
         <%@include file='../../css/main.css' %>
         <%@include file='../../css/registrationAndLogin.css' %>
    </style>
</head>
<body>
	<div class="wallpaper"></div>
	<div class="userMenu">
		<span class="name">
		<c:if test="${admin != null}">
            <form action="/createBook" method="get">
                <button>Создать книгу</button>
            </form>
		</c:if>
      ${name}
		</span>
		<form action="/logout" method="post" class="exit">
			<button>Log Out</button>
		</form>
	</div>
	<span>
		<form action="/cart" class="cart">
            <button class="link">
                <span class="itemCouter">0</span>
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
	<form  method="get" id="window" class="window"><%--action="/?addToCart=true"--%>
		<div id="closeWindow" class="closeWindow">
			<a onclick="closeWindow()" href="#">X</a>
		</div>
		<img class="bookPictureInWindow" src="img/book.jpg">
		<div class="bookDescription">
			<h3 class="bookName">Nicomachean Ethics – Aristotle</h3>
			<p class="descElement">Автор: <span>Аристотель</span></p>
			<p class="descElement">Год издания: <span>1999</span></p>
			<p class="descElement sml">
				Не следует, однако забывать, что начало повседневной работы по формированию позиции позволяет выполнять важные задания по разработке позиций, занимаемых участниками в отношении поставленных задач. Равным образом дальнейшее развитие различных форм деятельности играет важную роль в формировании модели развития. Не следует, однако забывать, что укрепление и развитие структуры позволяет оценить значение модели развития.
			</p>
			<div class="price">
				<span>1000</span>руб.
			</div>
			<button class="btn">Добавить в корзину</button>
		</div>
	</form>
	<div class="allBooks">
		<div class="space"></div>
		<div class="booksList">
			 <c:forEach items="${booksList}" var="book">
                <div class="book">
                <div class="bookPictureWrapper">
                     <img class="bookPicture" src="img/book.jpg">
                 </div>
                <h3 class="bookName">${book.getName()}</h3>
                 </div>
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