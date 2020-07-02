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