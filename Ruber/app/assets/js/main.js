
var driverProductList = [];
var getRiderHistory =function(){
    if($("#tripHistory").length >0){
        console.log("Getting rider history ");
        var xmlhttp = new XMLHttpRequest();
        var url = "/rider/history";

        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
            var constructRiderTable =  document.getElementById("constructTripData");
            if (xmlhttp.readyState == 4) {
                if ( xmlhttp.status == 200) {
                    var obj = (JSON.parse(xmlhttp.responseText));
                    var toReturn = constructRiderHistory(obj);
                    constructRiderTable.innerHTML =toReturn;
                }
                else{
                    console.log("Error ->" + xmlhttp.responseText);
                }
            }
        };
    }
};




function getProducts(){
    console.log("Clickes a button ");
    var xmlhttp = new XMLHttpRequest();
    var url = "/products";
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {
        var constructRiderTable =  document.getElementById("constructTripData");
        if (xmlhttp.readyState == 4) {
            if ( xmlhttp.status == 200) {
                var obj = (JSON.parse(xmlhttp.responseText));
                console.log(JSON.stringify(obj, null,4));


            }
            else{
                console.log("Error ->" + xmlhttp.responseText);
            }
        }
    };
};

var getReviewsByProductId = function getReviewsByProductId(){
    console.log("Clickes a button ");
    var xmlhttp = new XMLHttpRequest();
    var url = "/product/1/reviews";
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {
        var constructRiderTable =  document.getElementById("constructTripData");
        if (xmlhttp.readyState == 4) {
            if ( xmlhttp.status == 200) {
                var obj = (JSON.parse(xmlhttp.responseText));
                console.log(JSON.stringify(obj, null,4));
            }
            else{
                console.log("Error ->" + xmlhttp.responseText);
            }
        }
    };
};

function parseDate(arr){
    var d = new Date(arr);
    var dateStr = d.getDate();
    dateStr += "-" + d.getDate();
    dateStr += "-" + d.getYear();
    return dateStr;
};

function parseTripLength(start,end){
    var totalSec = (end - start)/1000;

    var hr = Math.floor(totalSec / 3600);
    var min = Math.floor((totalSec - (hr * 3600))/60);
    if(hr === 0)
        return min + "min";
    else
        return hr + "Hr" + ":" + min + "min";
};


function constructRiderHistory(arr) {
    var out = "";
    var i;
    for(i = 0; i < arr.length; i++) {
        out += "<tr>"
        out += "<td>"+ (i+1) +"</td>" ;
        out += "<td>"+ parseDate(arr[i].startTime) +"</td>" ;
        out += "<td>" + arr[i].product.price.finalPrice + arr[i].product.price.currencyCode + "</td>" ;
        out += "<td>"+ arr[i].distance +" KM</td>" ;
        out += "<td class='tripLength'>"+parseTripLength(arr[i].startTime, arr[i].endTime) +"  </td>" ;
        out += "<td>" + arr[i].product.driver.firstName + " " + arr[i].product.driver.lastName + "</td>" ;
        out += "</tr>"
    }
    return out;
};
function showProductTable(a){
    console.log(a);
}




function constructDriverProducts(product){
    var out = "";
    var i;
    for(i = 0; i < product.length; i++) {
        out += "<tr>"
        out += "<td>" + (i+1)+ "</td>";
        out += "<td>" + product[i].description +"</td>";
        out += "</tr>"
    }
    return out;
};

function driverProductGenerator(id){
    var out = "";
    var i = 0;
    for(i = 0; i < driverProductList[id].product.length; i++) {
        out += "<tr>"
        out += "<td>" + (i+1) + "</td>";
        out += "<td>" + driverProductList[id].product[i].displayName + "<td>";
        out += "<td>" + driverProductList[id].product[i].description + "<td>";
        out += "</tr>"
    }
    return out;
}

function displayProductsForDriver(id){
    var constructDriverData =  document.getElementById("constructroductsListData");
    constructDriverData.innerHTML = driverProductGenerator(id)
}

function constructDriverTable(obj){
    driverProductList = obj;
    var out = "";
    var i;
    for(i = 0; i < obj.length; i++) {
        out += "<tr>"
        out += "<td>" + (i+1)+ "</td>";
        out += "<td>" + obj[i].user.firstName +" "+obj[i].user.lastName + "</td>";
        out += "<td>" + obj[i].user.email + "</td>";
        out += "<td><button class='btn btn-primary' onclick='displayProductsForDriver("+i+")' id='driverNo"+i+"'>" + "Display"+ "</button></td>";
        out += "</tr>"
    }
    return out;
}



var getDrivers = function getDrivers(){
    console.log("Get drivers");
    if($("#driversList").length > 0 ){
        console.log("Found #driverList tag");
        var xmlhttp = new XMLHttpRequest();
        var url = "/driverss";
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
            var constructDriverData =  document.getElementById("constructDriverData");
            if (xmlhttp.readyState == 4) {
                if ( xmlhttp.status == 200) {
                    var obj = (JSON.parse(xmlhttp.responseText));
                    console.log(JSON.stringify(obj, null,4));
                    var toReturn = constructDriverTable(obj);
                    console.log(toReturn);
                    constructDriverData.innerHTML =toReturn;
                }
                else{
                    alert("Error ->" + xmlhttp.responseText);
                    console.log(xmlhttp.responseText)
                }
            }
        };
    }
};

$(function() {
    $('.tripLength').hover();

    setTimeout(function() {
        $('#welcomeMessage').fadeOut('slow');
    }, 1000);
    getRiderHistory();
    getDrivers();

});


