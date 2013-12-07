<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="home-wrapper">
    <div class="home-container">
<div class="carousel-container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner carousel-image">
            <div class="item active">
                <div class="carousel-inner-image">
                <img src="http://s3.amazonaws.com/photomap-czy-xx/carousel/greenland.jpg"></div>
                <div class="carousel-caption">1</div>
            </div>
            <div class="item">
                <div class="carousel-inner-image">
                <img class="carousel-inner-image" src="http://s3.amazonaws.com/photomap-czy-xx/carousel/nature1.jpg"></div>
                <div class="carousel-caption">2</div>
            </div>
            <div class="item">
                <img class="carousel-inner-image" src="http://s3.amazonaws.com/photomap-czy-xx/carousel/map.png">
                <div class="carousel-caption">3</div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
</div>
<div class="signup-container">
<div id="sign-up-box">
    <div class="box-title-wrapper">
        <div class="box-title">
            <h2>Sign up</h2>
        </div>
    </div>
    <div class="box-content">
        <form:form method="POST" action="/signup" commandName="signupForm">
            <div class="sign-up-field">
                <form:label path="username" cssClass="label-wrapper">Username:</form:label>
                <form:input path="username" cssClass="input-medium signup-input"/>
            </div>
            <div class="sign-up-field">
                <form:label path="password" cssClass="label-wrapper">Password:</form:label>
                <form:input path="password" cssClass="input-medium signup-input" type="password"/>
            </div>
            <div class="sign-up-field">
                <form:label path="email" cssClass="label-wrapper">Email:</form:label>
                <form:input path="email" cssClass ="input-medium signup-input" />
            </div>
            
            <div class = "sign-up-field">
                <input class="btn btn-primary btn-block" type= "submit" value="Sign up now!"/>
            </div>
        </form:form>        
    </div>


</div>
</div>
</div>
</div>

