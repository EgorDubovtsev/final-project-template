<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
	<form action="/" method="get">
		<button class="link toShop">
			<span class="icon-home"></span>
		</button>
	</form>
	<div class="cartName">Корзина</div>
	<%-- TODO: here popup(disabled add to cart button)--%>
	<div class="cartListOuter">
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