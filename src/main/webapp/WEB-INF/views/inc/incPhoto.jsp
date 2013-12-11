<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<p>${displayUser.username}'s photo map</p>

	<div class="user-photo-wrapper">
		<div class="map-wrapper">
			<div id="map"></div>
		</div>
	</div>

<script type="text/javascript">
	var mapOptions = {
    	center: new google.maps.LatLng(40.7143528,-74.0059731),
    	zoom: 10
  	};
  	var map = new google.maps.Map(document.getElementById('map'),mapOptions);
	var data = [
	<c:forEach var="p" items="${photos}" varStatus="loop">
		{img: "${p.imgUrl}", pb:"${p.latitude}",qb:"${p.longitude}"},
	</c:forEach>
	];
	var infowindow = new google.maps.InfoWindow({
      maxWidth: 400,
      maxHeigth: 300
    });
	for(var i=0;i<data.length;i++){
		var l = new google.maps.LatLng(data[i].pb, data[i].qb, true);
		var marker = new google.maps.Marker({
			map:map,
			position:l
		});
		google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent("<img class='map-window-photo' src=http://"+data[i].img+">");
          infowindow.open(map, marker);
         }
        })(marker, i));
		
	}
</script>
<!-- <c:forEach var="photo" items="${photos}">
${photo.photoId}
${photo.description}
${photo.imgUrl}
${photo.locationName}
${photo.latitude}
${photo.longitude}
${photo.createdTime}
${photo.userId}
</br>
</c:forEach> -->
