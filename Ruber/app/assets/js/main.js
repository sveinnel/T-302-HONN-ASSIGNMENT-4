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
                    console.log(JSON.stringify(obj, null,4));
                    var toReturn = constructRiderHistory(obj);
                    console.log(toReturn);
                    constructRiderTable.innerHTML =toReturn;
                }
                else{
                    alert("Error ->" + xmlhttp.responseText);
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
                alert("Error ->" + xmlhttp.responseText);
            }
        }
    };
}
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
                alert("Error ->" + xmlhttp.responseText);
                console.log(xmlhttp.responseText)
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
    return hr +"."+ min ;
};
function getDriverInfo(productId) {
  return productId;
}


function constructRiderHistory(arr) {
    var out = "";
    var i;
    for(i = 0; i < arr.length; i++) {
        out +="<tr>"
        out += "<td>"+ (i+1) +"</td>" ;
        out += "<td>"+ parseDate(arr[i].startTime) +"</td>" ;
        out += "<td > i</td>" ;
        out += "<td>"+ arr[i].distance +" KM</td>" ;
        out += "<td class='tripLength'>"+parseTripLength(arr[i].startTime, arr[i].endTime) +"  </td>" ;
        out += "<td>" + getDriverInfo(arr[i].productId)+"</td>" ;
        out +="</tr>"
    }
    return out;
};
var getDrivers = function getDrivers(){
    console.log("Clickes a button ");
    var xmlhttp = new XMLHttpRequest();
    var url = "/driverss";


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
                alert("Error ->" + xmlhttp.responseText);
                console.log(xmlhttp.responseText)
            }
        }
    };
};

$(function() {
    $('.tripLength').hover()

    setTimeout(function() {
        $('#welcomeMessage').fadeOut('slow');
    }, 1000);
    getRiderHistory();

});