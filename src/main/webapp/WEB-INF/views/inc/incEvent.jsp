
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="user-photo-wrapper">
	<div class="posting-container">
		<c:forEach var="user" items="${users}">
		<div class="posting-photo-container">
			<img class="posting-photo" src="http://${mapphotos[user].imgUrl}">
			<div class="posting-text-container">
				<div class="username-text-box">
					<div class="username-text" ><a href="/photo/${user.id}">${user.username}</a></div>
					<div class="date-text">posted at ${mapphotos[user].createdTime}</div>
				</div>
				<div class="description-text-box"> 
					<div class="description-text">${mapphotos[user].description}</div>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
</div>


