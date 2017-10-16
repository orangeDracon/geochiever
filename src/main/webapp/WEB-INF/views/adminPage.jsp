<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <head>

            <link href="<c:url value="/resources/css/views/adminPage.css" />" rel="stylesheet">

        </head>

        <body>
            <div>Admin Page</div>

            <div>Welcome : ${pageContext.request.userPrincipal.name}</div>

            <b>This is protected page!</b>  
        </body>
    </tiles:putAttribute>
</tiles:insertDefinition>