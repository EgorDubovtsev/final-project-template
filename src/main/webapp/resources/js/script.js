 $(document).ready(function () {
    const userLogin = $("#login").text().trim()
    reloadCounter(userLogin);
    getTotalPrice()

	$(".bookEntity").click(function () {
		var win = $("#window");
		var wall = $("#windowBack");
		const bookName = $(this).attr('value');
 		console.log(bookName)
        openPopup(bookName,wall,win);
	});

	$("#closeWindow").click(()=>{
	    closeWindow();
	});

    $("#addToCart").click(function(){
        const bookName = $(this).attr('value');
        addBookToCart(bookName);
    })
    $("#deleteFromTheCart").click(function(){
        const bookName = $(this).attr("value");
        const userLogin = $("#login").text().trim()
        console.log(bookName)
        console.log(userLogin)
        deleteFromTheCart(bookName,userLogin);
    })
 });

function getTotalPrice(){
   let booksPrice = []
   $('.bookPrice').each(function(){
       booksPrice.push($(this).text());
     });
   let totalPrice = 0;
   for(let i=0;i<booksPrice.length;i++){
        totalPrice= Number(totalPrice)+Number(booksPrice[i]);
   }
   $('#totalPrice').text(totalPrice)
}

 function addBookToCart(bookName){
 const userLogin = $("#login").text().trim()
    $.getJSON("/api/addToCart",{name:bookName, login:userLogin},(result)=>{
        closeWindow();
        reloadCounter(userLogin);
        if(result){
            //toast succ
        }else{
        //toast fail
        }
      })
 }
 function deleteFromTheCart(name,login){
    $.getJSON("/api/deleteBook",{bookName:name,userLogin:login},(result)=>{
    location.reload()
        if(result) {
             console.log("Success")
        }else{
            console.log("Fail")
        }
        closeWindow()
    })
 }


 function closeWindow() {
 	 $("#windowBack").css({"display":"none","opacity":"0"});
 	 $("#window").css({"display":"none","opacity":"0"});
 	 $("#window").animate({top:"+170px", opacity:"0"},"fast");
 }
 function reloadCounter(userLogin){
    $.getJSON("/api/getCountOfBooks",{login:userLogin},(result)=>{
        $("#counter").text(result)
    })
 }


 function openPopup(bookName, background, popup){
   	$.getJSON("/api",{name:bookName},(result)=>{
   	        console.log("OPEN BOOk")
 	        $('#window').css("display","flex");
 	        $('#bookNameInPopup').text(result.name);
 	        $('#bookAuthorInPopup').text(result.author);
 	        $('#bookPublishYearInPopup').text(result.publishYear);
 	        $('#bookGenreYearInPopup').text(result.genre);
 	        $('#bookDescriptionInPopup').text(result.description);
 	        $('#bookPriceInPopup').text(result.price);
 	        $('#addToCart').attr("value", bookName);
 	        $('#deleteFromTheCart').attr("value",bookName);
    })
    background.css("display","block");
    popup.css("display","flex");
    background.animate({opacity:"0.6"},"normal");
    popup.animate({top:"+100px", opacity:"1"},"normal");
 }

 function showToast(isOperationSuccess){
     if(isOperationSuccess){
        $("#toast").addClass("success");
        $("#toast").animate({bottom:"+40px", opacity:0.8}, "normal");
//        window.setTimeout(()=>{
//            $("#toast").css("bottom":"20px","opacity":"0")
//        },2000)
     }else{
        $("#toast").addClass("fail")
        $("#toast").animate({bottom:"+40px", opacity:0.8}, "normal");
     }
 }
