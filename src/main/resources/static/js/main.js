
var today = new Date();
var localDate=today.toLocaleDateString()
/*var income =document.getElementById("income").value;*/

var saveExpences = document.getElementById('saveExpences');
var array = [];
var obj={};


window.onload = function() {

    $.ajax({
        url: 'http://localhost:8080/getAllExpenses',
        type: 'get',
        success: function(response){
            convertObjToArray(response)

        }
    });
}

function convertObjToArray(obj){

    var result = Object.keys(obj).map(function (key) {

        return [obj[key].id,obj[key].quantity,obj[key].content,obj[key].explanation, obj[key].expensesDate,obj[key].amount]
    });
    table(result);
}

function table(array){
    var table = document.getElementById("table");
// console.log(array.length);
    var data = "";
    for (var i = 0; i < array.length; i++) {
        data += "<tr>";
        for (var j = 0; j < array[i].length; j++) {
            if (j == 0) {
                data += "<td><a href = '#'>" + array[i][j] + "</a></td>";
            } else {
                data += "<td>" + array[i][j] + "</td>";
            }
        }
        data += "</tr>";
    }
    var tbody = document.getElementById("records");
    tbody.innerHTML = data;
}

function liraFormatter(price){
    var currency_symbol = "₺"
    var formattedOutput = new Intl.NumberFormat('tr-TR', {
        style: 'currency',
        currency: 'TRY',
        minimumFractionDigits: 2,
    });
    return formattedOutput.format(price).replace(currency_symbol, '')
}



function sendIncome() {
    /*  document.getElementById("forDate").innerHTML = "Tarih  :"+explanation;*/
    var amount=document.getElementById("amount").value;
    var content=document.getElementById("content").value;
    var explanation=document.getElementById("explanation").value;
    var quantity=document.getElementById("qty").value;
    var date=document.getElementById("datePicker").value;

    debugger;


     obj = {"amount":amount,
        "expensesDate":date,
        "content":content,
        "explanation":explanation,
        "quantity":quantity,

       };

    var link='http://localhost:8080/saveExpenses';

    $.ajax({
        type: "POST",
        url: link,
        async: false,
        headers: {  'Access-Control-Allow-Origin' : 'http://localhost:8080/saveExpenses' },
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


