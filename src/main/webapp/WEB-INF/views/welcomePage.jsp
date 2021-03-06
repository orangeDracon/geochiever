<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <head>

            <link href="<c:url value="/resources/css/views/welcomePage.css" />" rel="stylesheet">

        </head>

        <body>
            <table>
                <tr>
                    <th id="welcomePageHeader">
                        <p>${message1}</p>
                    </th>
                </tr>
            </table>  

        </body>
    </tiles:putAttribute>
</tiles:insertDefinition>