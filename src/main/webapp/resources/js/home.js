
//function for filepicker 
filepicker.setKey('AgcKB8GxpR92mBoDWt96Cz');
function pick(id){
  filepicker.pickAndStore({
    mimetypes: ['image/*'],
  }, {location:"S3", path: id + "/photos/",access:'public'},
  function(InkBlob){
    console.log(JSON.stringify(InkBlob));
    document.getElementById('uploadFilename').innerHTML = InkBlob[0].filename;
    document.getElementById("imgurl").value = "s3.amazonaws.com/photomap-czy-xx/"+ InkBlob[0].key;
  },
  function(FPError){
      console.log(FPError.toString());
    }
  );
}

$(document).ready(function() {
  $(".fancybox").fancybox({
    openEffect  : 'none',
    closeEffect : 'none',
    helpers : {
        title : {
          type : 'over'
        },
        
    }
  });
});
$(document).ready(function(){
  $("#signupForm").validate({
    rules:{
      username:"required",
      password:{required:true, minlength:6},
      email:{required:true, email: true}
    },
    messages: {
      username: "Please enter your username",
      password: {required: "Please provide your password",
                 minlength: "Your password should be at least 6 characters long"},
      email: "Please enter a valid email address"
    },
    errorElement: 'div'

    
  });
}); 

//function for maps
var input = document.getElementById('pac-input');
function initmap() {
  var mapOptions = {
    center: new google.maps.LatLng(40.7143528,-74.0059731),
    zoom: 13
  };
  var map = new google.maps.Map(document.getElementById('map-canvas'),
    mapOptions);

  map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
  

  var autocomplete = new google.maps.places.Autocomplete(input);
  autocomplete.setTypes([]);
  autocomplete.bindTo('bounds', map);
  

  var infowindow = new google.maps.InfoWindow();
  var marker = new google.maps.Marker({
    map: map
  });
  google.maps.event.addListener(autocomplete, 'place_changed', function() {
    infowindow.close();
    marker.setVisible(false);
    var place = autocomplete.getPlace();
    if (!place.geometry) {
      return;
    }

    // If the place has a geometry, then present it on a map.
    if (place.geometry.viewport) {
      map.fitBounds(place.geometry.viewport);
    } else {
      map.setCenter(place.geometry.location);
      map.setZoom(17);  // Why 17? Because it looks good.
    }
    marker.setIcon(/** @type {google.maps.Icon} */({
      url: place.icon,
      size: new google.maps.Size(71, 71),
      origin: new google.maps.Point(0, 0),
      anchor: new google.maps.Point(17, 34),
      scaledSize: new google.maps.Size(35, 35)
    }));
    marker.setPosition(place.geometry.location);
    marker.setVisible(true);

    var address = '';
    if (place.address_components) {
      address = [
        (place.address_components[0] && place.address_components[0].short_name || ''),
        (place.address_components[1] && place.address_components[1].short_name || ''),
        (place.address_components[2] && place.address_components[2].short_name || '')
      ].join(' ');
    }

    infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
    console.log(place);
    document.getElementById("latitude").value = place.geometry.location.lat();
    document.getElementById("longitude").value = place.geometry.location.lng();
    document.getElementById("locationName").value = place.name;
    infowindow.open(map, marker);
});
}
google.maps.event.addDomListener(window, 'load', initmap);



$(document).ready(function() {
         $('.carousel').carousel({
             interval: 3000
         })
}); 



