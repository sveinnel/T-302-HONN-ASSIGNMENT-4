//$( document ).ready(function() {

    setTimeout(function() {
        $('#welcomeMessage').fadeOut('slow');
    }, 1000);

/*
    getRiderHistory(function(){
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
    });
*/
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
        var j;
        //console.log(arr.trips.id);
        console.log(arr.trips[0].id);
        for(i = 0; i < arr.trips.length; i++) {
            out +="<tr>"
            out += "<td>"+ arr.trips[i].id +"  </td>" ;
            out += "<td>"+ arr.trips[i].requestTime +"  </td>" ;
            out += "<td>"+ arr.trips[i].productId +"  </td>" ;
            out += "<td>"+ arr.trips[i].status +"  </td>" ;
            out += "<td>"+ arr.trips[i].distance +"  </td>" ;
            out += "<td>"+new Date(arr.trips[i].startTime) +"  </td>" ;
            out += "<td>"+ arr.trips[i].endTime +"  </td>" ;
            out += "<td>"+ arr.trips[i].startLongitude +"  </td>" ;
            out += "<td>"+ arr.trips[i].endLongitude +"  </td>" ;
            out += "<td>"+ arr.trips[i].startLatitude +"  </td>" ;
            out += "<td>"+ arr.trips[i].endLatitude +"  </td>" ;
            out += "<td>"+ arr.trips[i].riderId +"  </td>" ;
            out +="</tr>"
        }
        return out;
    }

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
    function getReviewsByProductId(){
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
    }

//});