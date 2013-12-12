<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<div class="user-photo-wrapper">
	<div class="big-photo-container">
		<c:forEach var="p" items="${photos}">
		<div class="photo-container">
			<div class="photo-shadow">
			<a class="fancybox" rel="gallery1" href="http://${p.imgUrl}" title="${p.description}">
				<img class="image-box" id="${name}${p.photoId}" src="http://${p.imgUrl}" >
			</a>
			<a href="/delete/${p.photoId}/">
				<span class="glyphicon glyphicon-remove"></span>
			</a>
			</div>
		</div>
		</c:forEach>
	</div>
</div>

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

