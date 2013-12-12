
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="user-photo-wrapper">
	<div class="posting-container">
		<div class="search-input-container">
			<span class="glyphicon glyphicon-search"></span>
			<input id="search-input" class="controls" type="text"
         placeholder="Search photos at location">
         	<a id="search-link">
         		<div class="search-button"><button class="btn btn-primary">Go</button></div>
         	</a>
     	</div>
		<c:forEach var="user" items="${users}">
		<div class="posting-photo-container">
			<img class="posting-photo" src="http://${mapphotos[user].imgUrl}">
			<div class="posting-text-container">
				<div class="username-text-box">
					<div class="username-text" ><a href="/photo/${user.id}">${user.username}</a>(@${mapphotos[user].locationName})</div>
					<div class="date-text">posted at ${mapphotos[user].createdTime}</div>
				</div>
				<div class="description-text-box"> 
					<div class="description-text">${mapphotos[user].description}</div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	<script type="text/javascript">
		var searchautocomplete = new google.maps.places.Autocomplete(
      	(document.getElementById('search-input')),
      	{ types: ['geocode'] });
  	google.maps.event.addListener(searchautocomplete, 'place_changed', function() {
  		var searchplace = searchautocomplete.getPlace();
  		var searchString = "/events?lat="+searchplace.geometry.location.lat()+"&lng="+ 
  		searchplace.geometry.location.lng();
  		document.getElementById('search-link').href = searchString;
    });
	</script>
</div>


