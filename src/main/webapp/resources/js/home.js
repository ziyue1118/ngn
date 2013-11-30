
//function for filepicker 
filepicker.setKey('AgcKB8GxpR92mBoDWt96Cz');
function pick(){
  filepicker.pick({
    mimetypes: ['image/*'],
  },
  function(InkBlob){
    console.log(JSON.stringify(InkBlob));
    document.getElementById('uploadFilename').innerHTML = InkBlob.filename;
  },
  function(FPError){
      console.log(FPError.toString());
    }
  );
}

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
    console.log(place.geometry.location.ob);
    console.log(place.geometry.location.pb);
    console.log(place.name);
    infowindow.open(map, marker);
});
}

$('#UploadModal').on('shown.bs.modal', function () {
    initmap();
});

