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
	var display = {}
	<c:forEach var="p" items="${photos}" varStatus="loop">
		if (display[["${p.latitude}","${p.longitude}"]]==undefined){
			display[["${p.latitude}","${p.longitude}"]] = [];
			display[["${p.latitude}","${p.longitude}"]].push({img: "${p.imgUrl}", pb:"${p.latitude}",qb:"${p.longitude}", des: "${p.description}"});
		} 
		else {
			display[["${p.latitude}","${p.longitude}"]].push({img: "${p.imgUrl}", pb:"${p.latitude}",qb:"${p.longitude}", des: "${p.description}"});
		} 
	</c:forEach>
	var infowindow = new google.maps.InfoWindow({
      maxWidth: 400,
      maxHeigth: 300
    });
    for(var key in display){
    	var l = new google.maps.LatLng(display[key][0].pb, display[key][0].qb, true);
    	var marker = new google.maps.Marker({
    		map:map,
    		position:l
    	});
    	google.maps.event.addListener(marker, 'click', (function(marker, key) {
        return function() {
          var contentString = "<div class='photo-scroll'>";
          for (var i=0;i<display[key].length;i++){
          	contentString = contentString + "<a class='fancybox' rel='gallerymap' href=http://"+display[key][i].img + " title='" + display[key][i].des +"'>";
          	contentString = contentString + "<img class='map-window-photo' src=http://"+display[key][i].img+">";
          	contentString = contentString + "</a>";
          }
          contentString = contentString + "</div>";
          infowindow.setContent(contentString);
          infowindow.open(map, marker);
         }
        })(marker, key));
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
