<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/home.css"/>" rel="stylesheet">
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="menu" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
    <!-- Button trigger modal -->
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="//api.filepicker.io/v1/filepicker.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/js/home.js"/>"></script>
</body>
</html>