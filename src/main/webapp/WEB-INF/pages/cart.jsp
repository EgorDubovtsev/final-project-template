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
                 <%@include file='../../css/cart.css' %>
            </style>
</head>
<body>
<div class="wallpaper"></div>
	<div class="userMenu">
		<div class="name"><a href="#">User 1</a></div>
		<div class="exit"><a href="#">Log Out</a></div>
	</div>
	<a href="index.html">
		<div class="toShop">
			<span class="icon-home"></span>
		</div>
	</a>
	<div class="cartName">Корзина</div>
	<div id="windowBack" class="windowBack"></div>
	<div id="window" class="window">
		<div id="closeWindow" class="closeWindow"><a onclick="closeWindow()" href="#">X</a></div>
		<div class="bookPictureInWindow">
			<img src="img/book.jpg" class="bookPicture" />
		</div>
		<div class="bookDescription">
			<h3 class="bookName">Название книги</h3>
			<p class="descElement">Автор: <span>Аристотель</span></p>
			<p class="descElement">Год издания: <span>1999</span></p>
			<p class="descElement sml">Не следует, однако забывать, что начало повседневной работы по формированию позиции позволяет выполнять важные задания по разработке позиций, занимаемых участниками в отношении поставленных задач. Равным образом дальнейшее развитие различных форм деятельности играет важную роль в формировании модели развития. Не следует, однако забывать, что укрепление и развитие структуры позволяет оценить значение модели развития.</p>
			<div class="price">
				<span>1000</span>руб.
			</div>
			<a class="btn">Добавить в корзину</a>
		</div>
	</div>
	<div class="cartListOuter">
		<div class="cartListInner">
			<div class="bookInCart">
				<div class="picBookInCart">
					<img class="bookPicture" src="img/book.jpg"/>
				</div>
				<div class="bookNameInCart">Nicomachean Ethics – Aristotle</div>
				<a class="delFromCart" href="#">X</a>
				<div class="priceWrapper">
					<div class="priceInCart">
						<span>1999</span>руб.
					</div>
				</div>
			</div>
			<div class="bookInCart">
				<div class="picBookInCart">
					<img class="bookPicture" src="img/book.jpg"/>
				</div>
				<div class="bookNameInCart">Nicomachean Ethics – Aristotle</div>
				<a class="delFromCart" href="#">X</a>
				<div class="priceWrapper">
					<div class="priceInCart">
						<span>1999</span>руб.
					</div>
				</div>
			</div>
			<div class="bookInCart">
				<div class="picBookInCart">
					<img class="bookPicture" src="img/book.jpg"/>
				</div>
				<div class="bookNameInCart">Nicomachean Ethics – Aristotle</div>
				<a class="delFromCart" href="#">X</a>
				<div class="priceWrapper">
					<div class="priceInCart">
						<span>1999</span>руб.
					</div>
				</div>
			</div>
			<div class="bookInCart">
				<div class="picBookInCart">
					<img class="bookPicture" src="img/book.jpg"/>
				</div>
				<div class="bookNameInCart">Nicomachean Ethics – Aristotle</div>
				<a class="delFromCart" href="#">X</a>
				<div class="priceWrapper">
					<div class="priceInCart">
						<span>1999</span>руб.
					</div>
				</div>
			</div>
		<div class="resultPriceWrapper">
			<div class="resultPrice">
				Стоимость составит: <span>2000</span>руб.
			</div>
			<a class="btn buyBtn" href="#">Купить</a>
		</div>
	</div>
</body>
</html>