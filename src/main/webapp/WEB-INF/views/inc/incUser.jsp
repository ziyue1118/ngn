<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<p>These are all the users</p>

<c:forEach items="${userlist}" var="user">
	<ul>
		<li>${user.id} ${user.username} ${user.password} ${user.email}</li>
	</ul>
</c:forEach>
