     function reloadCounter(userLogin){
        $.getJSON("/api/getCountOfBooks",{login:userLogin},(result)=>{
            $("#counter").text(result)
        })
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
