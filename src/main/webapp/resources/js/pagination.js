$(document).ready(function () {
    let activePage = 1;
    const booksCount = $(".book").length
    const booksOnPage = 10;
    createPagesButtons(booksCount, booksOnPage)
    $(".paginationElement").click((event) => {
        activePage = event.target.textContent
        activatePagination(activePage, booksCount, booksOnPage);
    })
    activatePagination(activePage, booksCount, booksOnPage);
})

function activatePagination(activePage, booksCount, booksOnPage) {
    const preventPage = $(".activePage").text()
    $(".paginationElement").removeClass("activePage")
    activatePaginationButton(activePage)
    $(".book").css("display", "none")
    if (preventPage < activePage) {
        incrementPageNumber(preventPage, activePage, booksOnPage)
    } else {
        decrementPageNumber(activePage, booksOnPage)
    }
}

function activatePaginationButton(activePage) {
    $(".paginationElement").filter((index, element) => {
        return element.textContent == activePage;

    }).addClass("activePage");
}

function decrementPageNumber(activePage, booksOnPage) {
    if (activePage == 1) {
        for (let i = activePage - 1; i < activePage * booksOnPage; i++) {
            $(".book").eq(i).css("display", "block")
        }
    } else {
        for (let i = activePage*10 - booksOnPage; i < activePage * booksOnPage; i++) {
            $(".book").eq(i).css("display", "block")
        }
    }
}

function incrementPageNumber(preventPage, activePage, booksOnPage) {
    if (preventPage == "") {
        for (let i = 0; i < activePage * booksOnPage; i++) {
            $(".book").eq(i).css("display", "block")
        }
    } else if(preventPage == 1){
        for (let i = (activePage - preventPage) * booksOnPage; i < activePage * booksOnPage; i++) {
            $(".book").eq(i).css("display", "block")
        }
    }else {
        for (let i = preventPage * booksOnPage; i < activePage * booksOnPage; i++) {
            $(".book").eq(i).css("display", "block")
        }
    }
}

function createPagesButtons(countOfBooks, booksOnPage) {
    const countOfPages = Math.ceil(countOfBooks / booksOnPage);
    for (let i = 1; i <= countOfPages; i++) {
        $("<div class='paginationElement'>" + i + "</div>").appendTo(".paginationButtonsWrapper")
    }
}
