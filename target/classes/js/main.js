$(document).ready(function () {
    const userLogin = $("#login").text().trim()
    reloadCounter(userLogin);
    getTotalPrice()

    $(".bookEntity").click(function () {
        const win = $("#window");
        const wall = $("#windowBack");
        const bookName = $(this).attr('value');
        openPopup(bookName, wall, win);
    });

    $("#closeWindow").click(() => {
        closeWindow();
    });

    $("#addToCart").click(function () {
        const bookName = $(this).attr('value');
        addBookToCart(bookName);
    })
    $("#deleteFromTheCart").click(function () {
        const bookName = $(this).attr("value");
        const userLogin = $("#login").text().trim()
        deleteFromTheCart(bookName, userLogin);
    })

    $("#buyButton").click(function () {
        const login = $("#login").text().trim()
        $.getJSON("/api/buy", {userLogin: login}, (isSuccess) => {
            if (isSuccess) {
                location.reload()
            }
        })

    })
});


function showToast(isOperationSuccess) {
    if (isOperationSuccess) {
        $("#toast").addClass("success");
        $("#toast").animate({bottom: "+40px", opacity: 0.8}, "normal");
//        window.setTimeout(()=>{
//            $("#toast").css("bottom":"20px","opacity":"0")
//        },2000)
    } else {
        $("#toast").addClass("fail")
        $("#toast").animate({bottom: "+40px", opacity: 0.8}, "normal");
    }
}
