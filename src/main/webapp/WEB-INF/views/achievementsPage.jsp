<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <head>

            <link href="<c:url value="/resources/css/views/achievementsPage.css" />" rel="stylesheet">

        </head>

        <body>
            <div>Achievemnts</div>
        </body>
    </tiles:putAttribute>
</tiles:insertDefinition>
