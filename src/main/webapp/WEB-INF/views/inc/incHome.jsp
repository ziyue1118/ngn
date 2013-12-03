<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${not empty error}">
<div class="errorblock">
	Your login attempt was not successful, try again.<br /> Caused :
	${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
</div>
</c:if>

<c:if test="${not empty success}">
<div class="errorblock">
	You've signed up successfully, now you can login in!<br />
</div>
</c:if>

<h2>Sign Up</h2>
<form:form method="POST" action="/signup" commandName="signupForm">
   <table>
    <tr>
        <td><form:label path="username">Username</form:label></td>
        <td><form:input path="username" /></td>
    </tr>
        <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input type="password" path="password" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
 	

