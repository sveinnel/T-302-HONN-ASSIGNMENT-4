
var driverProductList = [];

var ratingProductId = -1;
var latlong1 = {};
var latlong2 = {};
var myTrips = {};


/**
 * Returns rider history object only returns if a user is signed in.
 * adds the rider history to the dom
 */
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

/**
 * Generates html list for comments
 * @param comments array of comments
 */
function geneRateCommentsForProduct(comments){
    var out = "";

    var totalRating = 0;
    for(var j = 0; j < comments.length; j++) {
        totalRating += comments[j].rating;
    }

    if(comments.length > 0){
        totalRating /= comments.length;
        out += "<span>Average rating : " + totalRating.toString().substr(0,3) + "</span>";
    }else{
        out += "This driver has no reviews";
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
/**
 * Get request for reviews by product id, on callback gegnerates the comments
 * for the product
 * @param id integer of product to get
 */
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

/**
 * Parse date object returns the date as string object
 * @param arr date object
 * @returns {number} date as string
 */

function parseDate(arr){
    var d = new Date(arr);
    var dateStr = d.getDate();
    dateStr += "-" + d.getDate();
    dateStr += "-" + d.getYear();
    return dateStr;
};
/**
 * Calculates the time a trip took.  If less then an hour return only min
 * @param start start time in millisec
 * @param end end time in millisec
 * @returns {string} time as a sting
 */
function parseTripLength(start,end){
    var totalSec = (end - start)/1000;

    var hr = Math.floor(totalSec / 3600);
    var min = Math.floor((totalSec - (hr * 3600))/60);
    if(hr === 0)
        return min + "min";
    else
        return hr + "Hr" + ":" + min + "min";
};

/**
 * Set the google maps coordinates points by selected trip.
 * Calls initialize to reset the coordinates to default
 * @param id id of trip object
 */

var setCoord = function setCoord(id){
    latlong1 = new google.maps.LatLng(myTrips[id].startLatitude, myTrips[id].startLongitude);
    latlong2 = new google.maps.LatLng(myTrips[id].endLatitude, myTrips[id].endLongitude);
    initialize(latlong1,latlong2);
};

/**
 * Generates html for rider history object
 * @param arr   arr[i].product json object
 * @returns {string} Html table
 */
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

/**
 * Sets which product is being rated and focus to the text fields
 * @param id of product to be rated
 */
var modalReviewOpening = function modalReviewOpening(id){
    ratingProductId = id;
    document.getElementById('inputComment').focus()
};

/**
 * Generates html for drivers to review
 * @param id of driver to list reviews
 * @returns {string} html string
 */
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

/**
 * Called when to populate data into the dom
 * @param id
 */
function displayProductsForDriver(id){
    var constructDriverData =  document.getElementById("constructroductsListData");
    constructDriverData.innerHTML = driverProductGenerator(id);

};
/**
 * Construct html for the driver table generates id's to be
 * able to click on fiedls
 * @param obj array of driver
 * @returns {string} html string
 */
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


/**
 * Get request to get drivers
 * Returns a callback to create the driver table
 */
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
/**
 * Post a comment to the API takes from the input fields of a modal
 * Simple error check to check input errors.
 * if valid post a comment to the server and recives a callback to
 * populate the new data into the view
 * @returns {null} if there is an error inserting values
 */
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
                getReviewsByProductId(ratingProductId);
                var commentTxt =  $("#inputComment").val("");
                var rating =  $("#inputRating").val("");
            }
        }
        http.send(JSON.stringify(toSend));
    }
};
/**
 * Calculate radians
 * @param Value number
 * @returns {number} radians
 */
var toRad = function toRad(Value) {
    return Value * Math.PI / 180;
};
/**
 * Calculate to degrees
 * @param angle angle
 * @returns {number} degrees
 */
var toDegrees =function toDegrees (angle) {
    return angle * (180 / Math.PI);
};

/**
 * Calculates a midpoint between two coordinates
 * @param lat1  lat coords
 * @param lon1  lng coords
 * @param lat2  lat coords
 * @param lon2  lng coords
 * @returns {{lat: number, lng: number}} lat lng object
 */
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


/**
 * Calculates a zoom level for google maps
 * @param bounds google.bounds object
 * @param mapDim size of the map to display in
 * @returns {number} proper zoom level
 */
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
/**
 * Create the bound object for all markes
 * @param markers point on the map
 * @returns {google.maps.LatLngBounds}
 */
var createBoundsForMarkers= function createBoundsForMarkers(markers) {
    var bounds = new google.maps.LatLngBounds();
    $.each(markers, function() {
        bounds.extend(this.getPosition());
    });
    return bounds;
};
/**
 * initialize the google map is called every time a coordinates are calculated
 * @param latlong1 marker for start posision
 * @param latlong2 marker for end posision
 */
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
            zoom: (bounds) ? (getBoundsZoomLevel(bounds, mapdim)-1) : 0
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

    //function to resize the map inside the modal window
    $("#purchaseModal").on("shown.bs.modal"), function(e){
        google.maps.event.trigger( map, "resize");
        map.setCenter(markerLatLng);
    };
    latlong1 = new google.maps.LatLng(0,0);
    latlong2 = new google.maps.LatLng(0,0);

    google.maps.event.addDomListener(window, 'load', initialize(latlong1,latlong2));

});


