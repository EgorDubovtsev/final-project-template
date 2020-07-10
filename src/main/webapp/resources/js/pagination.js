$(document).ready(function(){
    let activePage = 1;
    $(".paginationElement").click((event)=>{
        console.log(event.target.textContent)
        activePage=event.target.textContent
        console.log(activePage+" ACTIVE PAGE")
        activatePagination(activePage);
    })
    activatePagination(activePage);
})

function activatePagination(activePage){
    const booksCount = $(".book").length
    const booksOnPage = 10;
    const preventPage = $(".activePage").text()

    $(".paginationElement").removeClass("activePage")
    activatePaginationButton(activePage)

    console.log(preventPage+ " Prevent page")
    $(".book").css("display","none")
    if(preventPage<activePage){
        incrementPageNumber(preventPage,activePage,booksOnPage)
    }else{
        decrementPageNumber(preventPage,activePage,booksOnPage)//remove unused parameter from signature
    }
}

function activatePaginationButton(activePage){
    const pageButtonsCount = $(".paginationElement").length
    $(".paginationElement").filter((index,element)=>{
        if(element.textContent==activePage){
            return true
        }
        return false;
    }).addClass("activePage");
}
function decrementPageNumber(preventPage,activePage,booksOnPage){
    if(activePage==1){
            for(let i=activePage-1;i<activePage*booksOnPage;i++){
                $(".book").eq(i).css("display","block")
            }
    }else{
         for(let i=activePage-booksOnPage;i<=activePage*booksOnPage;i++){
                $(".book").eq(i).css("display","block")
         }
    }
}

function incrementPageNumber(preventPage,activePage,booksOnPage){
    if(preventPage==""){
    console.log("PREV NULL")
            for(let i=0;i<activePage*booksOnPage;i++){
                $(".book").eq(i).css("display","block")
            }
    }else{
         for(let i=preventPage*booksOnPage;i<=activePage*booksOnPage;i++){
                $(".book").eq(i).css("display","block")
         }
    }
}
