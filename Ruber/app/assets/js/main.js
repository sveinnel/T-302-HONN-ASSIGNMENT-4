
var driverProductList = [];

var ratingProductId = -1;
var latlong1 = {};
var latlong2 = {};
var myTrips = {};

var getRiderHistory =function(){
    if($("#tripHistory").length >0){
        var xmlhttp = new XMLHttpRequest();
        var url = "/rider/history";

        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
            var constructRiderTable =  document.getElementById("constructTripData");
            if (xmlhttp.readyState == 4) {
                if ( xmlhttp.status == 200) {
                    var obj = (JSON.parse(xmlhttp.responseText));
                    myTrips = obj;
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

//For debugging only
function getProducts(){
    var xmlhttp = new XMLHttpRequest();
    var url = "/products";
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {
        var constructRiderTable =  document.getElementById("constructTripData");
        if (xmlhttp.readyState == 4) {
            if ( xmlhttp.status == 200) {
                var obj = (JSON.parse(xmlhttp.responseText));
            }
            else{
                console.log("Error ->" + xmlhttp.responseText);
            }
        }
    };
};

function geneRateCommentsForProduct(comments){
    var out = "";

    var totalRating = 0;
    for(var j = 0; j < comments.length; j++) {
        totalRating += comments[j].rating;
    }

    if(comments.length > 0){
        totalRating /= comments.length;
        out += "<span>Total rating : " + totalRating.toString().substr(0,3) + "</span>";
    }else{
        out += "This driver is unrated";
    }

    for(var i = 0; i < comments.length; i++) {
        out += "<div class='list-group'>";
        out += "<h4 class='list-group-item-heading'> "+ comments[i].reviewer.username + " wrote: </h4>";
        out += "<div href='' class='list-group-item'>";
        out += "<p class='list-group-item-text'>" +comments[i].comment+ "</p>";
        out += "<span class=' rating list-group-item-text '>Rated : " +comments[i].rating+ "</span>";
        out += "</div>"
        out += "</div>";
    }
    var reviewForProduct = document.getElementById("productWithId");
    reviewForProduct.innerHTML = out;
}

var getReviewsByProductId = function getReviewsByProductId(id){
    var xmlhttp = new XMLHttpRequest();
    var url = "/products/"+id+"/reviews";
    xmlhttp.open('GET',url,true);
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function() {

        if (xmlhttp.readyState == 4) {
            if ( xmlhttp.status == 200) {
                var obj = (JSON.parse(xmlhttp.responseText));
                geneRateCommentsForProduct(obj);
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

var setCoord = function setCoord(id){
    latlong1 = new google.maps.LatLng(myTrips[id].startLatitude, myTrips[id].startLongitude);
    latlong2 = new google.maps.LatLng(myTrips[id].endLatitude, myTrips[id].endLongitude);
    initialize(latlong1,latlong2);
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
        out += "<td> <button type='button' class='btn btn-default btn-sm' data-toggle='modal'  data-target='#purchaseModal' onclick='setCoord("+i+")'>Display trip map</button></td>";
        out += "</tr>"
    }
    return out;
};

var modalReviewOpening = function modalReviewOpening(id){
    ratingProductId = id;
    document.getElementById('inputComment').focus()
};

function driverProductGenerator(id){
    var reviewForProduct = document.getElementById("productWithId");
    reviewForProduct.innerHTML = "<div>  </div>";

    var driverName = document.getElementById("nameOfDriver");
    driverName.innerHTML =driverProductList[id].user.firstName
        + " " + driverProductList[id].user.lastName+ " car";

    var out = "";
    var i = 0;
    for(i = 0; i < driverProductList[id].product.length; i++) {
        out += "<tr>"
        out += "<td>" + (i+1) + "</td>";
        out += "<td>" + driverProductList[id].product[i].displayName + "</td>";
        out += "<td>" + driverProductList[id].product[i].capacity + "</td>";
        out += "<td>" + driverProductList[id].product[i].description + "</td>";
        out += "<td><img alt='Driver image' class='img-thumbnail driverimageClip' src='"+driverProductList[id].product[i].image +"'/> </td>"

        out += "</tr>"
        out += "<tr>";
        out += "<td> <button class='btn btn-default btn-sm' onclick='getReviewsByProductId("+(id+1)+")'>Display Reviews</button></td>";
        out += "<td> <button type='button' class='btn btn-default btn-sm' data-toggle='modal' onClick='modalReviewOpening("+driverProductList[id].product[i].id+")'  data-target='#purchaseModal'>Add a review</button></td>";
        out += "</tr>";

    }
    return out;
};

function displayProductsForDriver(id){
    var constructDriverData =  document.getElementById("constructroductsListData");
    constructDriverData.innerHTML = driverProductGenerator(id);

};

function constructDriverTable(obj){

    driverProductList = obj;
    var out = "";
    var i;
    for(i = 0; i < obj.length; i++) {
        out += "<tr>"
        out += "<td>" + (i+1)+ "</td>";
        out += "<td>" + obj[i].user.firstName +" "+obj[i].user.lastName + "</td>";
        out += "<td>" + obj[i].user.email + "</td>";
        out += "<td><button class='btn btn-default btn-sm' onclick='displayProductsForDriver("+i+")' id='driverNo"+i+"'>" + "Display"+ "</button></td>";
        out += "</tr>"
    }
    return out;
}



var getDrivers = function getDrivers(){

    if($("#driversList").length > 0 ){
        var xmlhttp = new XMLHttpRequest();
        var url = "/drivers";
        xmlhttp.open('GET',url,true);
        xmlhttp.send(null);
        xmlhttp.onreadystatechange = function() {
            var constructDriverData =  document.getElementById("constructDriverData");
            if (xmlhttp.readyState == 4) {
                if ( xmlhttp.status == 200) {
                    var obj = (JSON.parse(xmlhttp.responseText));
                    var toReturn = constructDriverTable(obj);
                    constructDriverData.innerHTML =toReturn;
                }
                else{
                    console.log(xmlhttp.responseText)
                }
            }
        };
    }
};

var postComment = function postComment(){

    var commentTxt =  $("#inputComment").val();
    var rating =  $("#inputRating").val();
    var toSend = {
        "productId" :ratingProductId.toString(),
        "rating" : parseInt(rating),
        "comment" : commentTxt
    };

    if(parseInt(rating) > 5 || parseInt(rating) < 0  )
    {
        alert("Rating is between 0 and 5 !");
        return null;
    }
    else if(rating.length <= 0){
        alert("There must be a comment ");
        return null;
    }else {
        var http = new XMLHttpRequest();
        var url = " /products/review";
        http.open("POST", url, true);

        http.setRequestHeader("Content-type", "application/json");

        http.onreadystatechange = function () {//Call a function when the state changes.
            if (http.readyState == 4 && http.status == 200) {
                //TODO: There is a possibiltiy to update the dom here...
            }
        }
        http.send(JSON.stringify(toSend));
    }
};

var toRad = function toRad(Value) {
    /** Converts numeric degrees to radians */
    return Value * Math.PI / 180;
};
var toDegrees =function toDegrees (angle) {
    return angle * (180 / Math.PI);
};

var midPoint = function midPoint(lat1,lon1,lat2,lon2){

    var dLon = toRad(lon2 - lon1);

    lat1 = toRad(lat1);
    lat2 = toRad(lat2);
    lon1 = toRad(lon1);

    var Bx = Math.cos(lat2) * Math.cos(dLon);
    var By = Math.cos(lat2) * Math.sin(dLon);
    var lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
    var lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);

    //print out in degrees
    return {
        lat : toDegrees(lat3),
        lng : toDegrees(lon3)
    };
};

var getBoundsZoomLevel = function getBoundsZoomLevel(bounds, mapDim) {
    var WORLD_DIM = { height: 256, width: 256 };
    var ZOOM_MAX = 21;

    function latRad(lat) {
        var sin = Math.sin(lat * Math.PI / 180);
        var radX2 = Math.log((1 + sin) / (1 - sin)) / 2;
        return Math.max(Math.min(radX2, Math.PI), -Math.PI) / 2;
    }

    function zoom(mapPx, worldPx, fraction) {
        return Math.floor(Math.log(mapPx / worldPx / fraction) / Math.LN2);
    }

    var ne = bounds.getNorthEast();
    var sw = bounds.getSouthWest();

    var latFraction = (latRad(ne.lat()) - latRad(sw.lat())) / Math.PI;

    var lngDiff = ne.lng() - sw.lng();
    var lngFraction = ((lngDiff < 0) ? (lngDiff + 360) : lngDiff) / 360;

    var latZoom = zoom(mapDim.height, WORLD_DIM.height, latFraction);
    var lngZoom = zoom(mapDim.width, WORLD_DIM.width, lngFraction);

    return Math.min(latZoom, lngZoom, ZOOM_MAX);
};

var createBoundsForMarkers= function createBoundsForMarkers(markers) {
    var bounds = new google.maps.LatLngBounds();
    $.each(markers, function() {
        bounds.extend(this.getPosition());
    });
    return bounds;
};

var initialize = function initialize(latlong1,latlong2) {
    if($("#map_canvas").length> 0){


        var centerOftwoPoints = midPoint(latlong1.lat(),latlong1.lng(),latlong2.lat(),latlong2.lng());

        var markers = [];

        var firstMarker = new google.maps.Marker({
            position: latlong1,
            title:"Start"
        });

        var secondMarker = new google.maps.Marker({
            position: latlong2,
            title:"End"
        });

        markers.push(firstMarker);
        markers.push(secondMarker);
        var bounds = new google.maps.LatLngBounds();

        var bounds = (markers.length > 0) ? createBoundsForMarkers(markers) : null;

      var mapdim = {
            height: 300,
            width : 550
        }

        mapOptions = {
            center: centerOftwoPoints,
            zoom: (bounds) ? getBoundsZoomLevel(bounds, mapdim) : 0
        };

        map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);

        firstMarker.setMap(map);
        secondMarker.setMap(map);

        $("#purchaseModal").on("shown.bs.modal", function(e) {
            google.maps.event.trigger(map, "resize");
            return map.setCenter(mapOptions.center);
        });

    }
};



$(function() {
    var map;
    $('.tripLength').hover();

    setTimeout(function() {
        $('#welcomeMessage').fadeOut('slow');
    }, 1000);

    getRiderHistory();
    getDrivers();

    $("#purchaseModal").on("shown.bs.modal"), function(e){
        google.maps.event.trigger( map, "resize");
        map.setCenter(markerLatLng);
    };
    latlong1 = new google.maps.LatLng(64.133333,-21.933333);
    latlong2 = new google.maps.LatLng(64.133222,-21.9111);

    google.maps.event.addDomListener(window, 'load', initialize(latlong1,latlong2));


});


