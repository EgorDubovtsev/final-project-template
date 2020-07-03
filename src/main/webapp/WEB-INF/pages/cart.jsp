<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<title>Book Shop</title>
    <c:set var="staticRoot" value="${pageContext.request.contextPath}/resources"/>
	<link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;700&display=swap" rel="stylesheet">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="${staticRoot}/js/script.js"></script>
	<style>
         <%@include file='../../resources/css/main.css' %>
         <%@include file='../../resources/css/cart.css' %>
    </style>

</head>
<body>
<div class="wallpaper" style="background:url('${staticRoot}/img/fom1.jpg')"></div>
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
	<form action="/" method="get">
		<button class="link toShop">
			<span class="icon-home"></span>
		</button>
	</form>
	<div class="cartName">Корзина</div>
	<div class="cartListOuter">
			<c:if test="${open!=null}">
		<div id="windowBack" class="windowBack"></div>
		<form  method="get" id="window" class="window"><%--action="/?addToCart=true"--%>
			<div id="closeWindow" class="closeWindow">
				<button class="link bigFont" value="/">X</button> 
			</div>
			<img class="bookPictureInWindow" src="${staticRoot}/img/book.jpg">
			<div class="bookDescription">
				<h3 class="bookName">${openedBook.getName()}</h3>
				<p class="descElement">Автор: <span>${openedBook.getAuthor()}</span></p>
				<p class="descElement">Год издания: <span>${openedBook.getPublishYear()}</span></p>
				<p class="descElement sml">
					${openedBook.getDescription()}
				</p>
				<div class="price">
					<span>${openedBook.getPrice()}</span>руб.
				</div>
				<button name="outOfCart" value='${openedBook.getName()}' class="btn addButton">Удалить из корзины</button>
			</div>
		</form>
	</c:if>
		<div class="cartListInner">
		<c:forEach items="${booksInTheCart}" var="book">
			<form>
				<button class="link bookInCart" name="open" value="${book.getName()}">
						<div class="picBookInCart">
							<img class="bookPicture" src="${staticRoot}/img/book.jpg"/>
						</div>
						<div class="bookNameInCart">${book.getName()}</div>
						<a class="delFromCart" href="#">X</a>
						<div class="priceWrapper">
							<div class="priceInCart">
								<span>${book.getPrice()}</span>руб.
							</div>
						</div>
					
				</button>
			</form>
		</c:forEach>
			
			
		<div class="resultPriceWrapper">
			<div class="resultPrice">
				Стоимость составит: <span>${amount}</span>руб.
			</div>
			<a class="btn buyBtn" href="#">Купить</a>
		</div>
	</div>
</body>
</html>