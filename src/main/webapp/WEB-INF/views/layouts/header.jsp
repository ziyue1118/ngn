<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class = "header">
    <div id = "header-wrapper">
      <div class="site-title"><strong>PhotoMap</strong></div>
    </div>
    <sec:authorize ifAnyGranted="ROLE_USER">                    
		<li><a href="<c:url value="/j_spring_security_logout" />" >Logout</a></li> 
    </sec:authorize> 
</div>
