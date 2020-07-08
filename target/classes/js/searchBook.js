    $(document).ready(function(){
      $("#searchButton").click(()=>searchBook())

    })

    function searchBook(){
        const bookName = $("#searchLine").val()
        const bookAuthor = $("#author").val()
        const bookMaxPrice = $("#price").val()
        const bookGenre = $("#genre").val()
        console.log(bookName+" "+ bookAuthor+" "+bookMaxPrice+" "+bookGenre)
        $.getJSON("/api/search",{name:bookName,author:bookAuthor,genre:bookGenre,maxPrice:bookMaxPrice},(response)=>{
                console.log(response.length)
             let validBooksNames=[];
            for(let i=0;i<response.length;i++){
                validBooksNames.push(response[i].name)
            }
            $(".bookName").filter((index,element)=>{
                for(let j=0;j<validBooksNames.length;j++){
                    console.log(j)
                    if(validBooksNames[j]==element.textContent) {
                        return true;
                    }
                }
                return false;
            }).css("display","none")

        })

    }