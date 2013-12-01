<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<p>These are all the users</p>
<c:forEach var="photo" items="${photos}">
${photo.photoId}
${photo.description}
${photo.imgUrl}
${photo.locationName}
${photo.latitude}
${photo.longitude}
${photo.createdTime}
${photo.userId}
</br>
</c:forEach>

