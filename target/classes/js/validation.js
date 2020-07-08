    $(document).ready(function (){
//        $("#publishYear-createBook").val(0)
//        $("#price-createBook").val(0)
        $("#name-createBook").change(()=>checkValueLengthText("name-createBook",50))
        $("#author-createBook").change(()=>checkValueLengthText("author-createBook",100))
        $("#bookDescription-createBook").change(()=>checkValueLengthText("bookDescription-createBook",100))
//        $("#author-createBook").change(checkCreateBookFields())
//        $("#genre-createBook").change(checkCreateBookFields())
        $("#publishYear-createBook").change(()=>checkValuePublishYear("publishYear-createBook"))
        $("#price-createBook").change(()=>checkValuePrice("price-createBook"))
//        $("#bookDescription-createBook").change(checkCreateBookFields())
    })
// $("#price-createBook").change(checkCreateBookFields())
//    function checkCreateBookFields(){
//    console.log("CHAMGE")
//        checkValueLengthText("name-createBook")
//        checkValueLengthText("author-createBook")
//        checkValuePublishYear("publishYear-createBook")
////        checkValuePrice("price-createBook")
//        checkValueLengthText("bookDescription-createBook")
//    }

    function checkValueLengthText(id,maxLength){
     const value = $("#"+id).val()
     console.log(value)
     if(value.length>maxLength){
       $("#"+id).val(value.substring(0,maxLength-1))
     }
    }
    function checkValuePublishYear(id){
    const inputValue = $("#"+id).val();
        if(/\D/.test(inputValue) || inputValue.length>4 || inputValue[0]=="0"){
            $("#"+id).val(0)
        }
    }

    function checkValuePrice(id){
        const priceValue = $("#"+id).val().trim()
        console.log(priceValue)
        if(/\D/.test(priceValue)|| priceValue>100000 || priceValue[0]=="0"){
            $("#"+id).val("0")
        }
    }