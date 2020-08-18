'use strict';
var today = new Date();
var localDate=today.toLocaleDateString()
/*var income =document.getElementById("income").value;*/
document.getElementById("okey").onclick = function fun() {
    getValues();
    sendIncome();
}

document.getElementById("first").onclick = function fun() {
    getValues();

}



function getValues(){
    document.getElementById("forIncome").innerHTML = document.getElementById("income").value;
    document.getElementById("forcontent").innerHTML = document.getElementById("content").value;
    document.getElementById("forexplanation").innerHTML = document.getElementById("explanation").value;
    document.getElementById("headerDate").innerHTML =localDate;
    document.getElementById("forDate").innerHTML =localDate;
}

function sendIncome(event) {
    /*  document.getElementById("forDate").innerHTML = "Tarih  :"+explanation;*/
    var obj = {"amount":income,
        "incomeDate":today,
        "content":content,
        "explanation":explanation};
    var link='http://localhost:8080/saveIncome';

    $.ajax({
        type: "POST",
        url: link,
        async: false,
        headers: {  'Access-Control-Allow-Origin': 'http://localhost:8080/saveIncome' },
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        data:JSON.stringify(  obj )

        ,
        success: function (response) {
            if (response == 'success')
                       alert("deneme"+obj)
        },

    });
}


