<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty error}">
<div class="errorblock">
	Your login attempt was not successful, try again.<br /> Caused :
	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</div>
</c:if>
 	

