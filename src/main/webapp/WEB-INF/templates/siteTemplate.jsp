<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="<c:url value="/resources/css/template/siteTemplate.css" />" rel="stylesheet">

        <title>Geochiever</title>
    </head>

    <body>
        <div class="fullPage">
            <div class="headerZone">
                <tiles:insertAttribute name="header" />
            </div>
            
            <div class="menuZone">
                <tiles:insertAttribute name="menu" />
            </div>
            
            <div class="bodyZone">
                <tiles:insertAttribute name="body" />
            </div>
            
            <div class="footerZone">
                <tiles:insertAttribute name="footer" />
            </div>
        </div>
    </body>
</html>