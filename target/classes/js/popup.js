 function closeWindow() {
 	 $("#windowBack").css({"display":"none","opacity":"0"});
 	 $("#window").css({"display":"none","opacity":"0"});
 	 $("#window").animate({top:"+170px", opacity:"0"},"fast");
 }
  function openPopup(bookName, background, popup){
    	$.getJSON("/api/popup",{name:bookName},(result)=>{
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