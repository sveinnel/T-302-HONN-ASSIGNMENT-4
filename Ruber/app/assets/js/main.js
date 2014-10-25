
function getRiderHistory(){
    console.log("Clickes a button ");
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
function constructRiderHistory(arr) {
    var out = "";
    var i;
    for(i = 0; i < arr.length; i++) {
        out +="<tr>"
        out += "<td>"+ arr[i].id +"  </td>" ;
        out += "<td>"+ arr[i].requestTime +"  </td>" ;
        out += "<td>"+ arr[i].productId +"  </td>" ;
        out += "<td>"+ arr[i].status +"  </td>" ;
        out += "<td>"+ arr[i].distance +"  </td>" ;
        out += "<td>"+ arr[i].startTime +"  </td>" ;
        out += "<td>"+ arr[i].endTime +"  </td>" ;
        out += "<td>"+ arr[i].startLongitude +"  </td>" ;
        out += "<td>"+ arr[i].endLongitude +"  </td>" ;
        out += "<td>"+ arr[i].startLatitude +"  </td>" ;
        out += "<td>"+ arr[i].endLatitude +"  </td>" ;
        out += "<td>"+ arr[i].riderId +"  </td>" ;
        out +="</tr>"
    }
    return out;
}


