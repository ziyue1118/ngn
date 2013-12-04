<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class = "header">
    <div id = "header-wrapper">
      <div class="site-title"><strong>PhotoMap</strong></div>
    <sec:authorize ifAnyGranted="ROLE_USER">
      <div id="logout-wrapper">  
        <div id="account-name-wrapper">
            <div id="account-name">Welcome ${name}!</div>
        </div>                    
        <div id="logout-text-wrapper">
            <a id="logout-text" href="<c:url value="/j_spring_security_logout" />" >Logout</a>
        </div> 
    </div>
    </sec:authorize>
    <sec:authorize ifNotGranted="ROLE_USER">
    <div class="loginForm" onload='document.f.j_username.focus();'>
    	<form name='f' action="<c:url value='j_spring_security_check' />"
    	method='POST' >
		Username<input class="login-input" type="text" name='j_username' value=''>
		Password<input class="login-input" type="password" name='j_password' />
				<input name="submit" type="submit"
    	value="Signin" />
    	</form>
	</div>

	</sec:authorize> 
	</div>
</div>
