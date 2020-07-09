<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title>Book Shop</title>
    <c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/popup.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/cart.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/main.js"></script>
	<style>
         <%@include file='../../resources/css/main.css' %>
         <%@include file='../../resources/css/cart.css' %>
    </style>

</head>
<body>
<div class="wallpaper" style="background:url('${staticRoot}/img/fom1.jpg') no-repeat;
	-webkit-background-size: cover;
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;"></div>
	<div class="userMenu">
		<span class="name" id="login">
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
	<div class="cartName">Корзина</div>
		<div id="windowBack" class="windowBack"></div>
		<form  method="get" id="window" class="window">
			<div id="closeWindow" class="closeWindow">
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
				<a id="deleteFromTheCart" class="btn addButton">Удалить из корзины</a>
			</div>
		</form>
	<div class="cartListOuter">
		<div class="cartListInner">
		<c:forEach items="${booksInTheCart}" var="book">
			<div>
				<button class="link bookInCart bookEntity" name="open" value="${book.getName()}">
						<div class="picBookInCart">
							<img class="bookPicture" src="${staticRoot}/img/book.jpg"/>
						</div>
						<div class="bookNameInCart">${book.getName()}</div>
						<div class="priceWrapper">
							<div class="priceInCart">
								<span class="bookPrice">${book.getPrice()}</span>руб.
							</div>
						</div>
				</button>
			</div>
		</c:forEach>
		<div class="resultPriceWrapper">
			<div class="resultPrice">
				Стоимость составит: <span id="totalPrice"></span>руб.
			</div>
			<a class="btn buyBtn" id="buyButton">Купить</a>
		</div>
	</div>
</body>
</html>