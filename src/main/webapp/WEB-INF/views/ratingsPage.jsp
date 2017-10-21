<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page pageEncoding="ISO-8859-1" %>
<%@page contentType="text/html; charset=utf-8" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">    
        <head>

            <link href="<c:url value="/resources/css/views/ratingsPage.css" />" rel="stylesheet">

        </head>

        <body>

            <table>
                <tr>
                    <td id="ratingsPageTitle" colspan="3">
                        <p>USERS RATINGS LISTS</p>
                    </td>
                </tr>
                <tr>
                    <td id="ratingsPageColumns">
                        <table>
                            <tr>
                                <th id="achiTableHeader" colspan="2">
                                    <p>POINT ACHIVEMENTS</p>
                                </th>
                            </tr>
                            <c:forEach var="pointAchi" items="${userAchiPointRatingsList}">
                                <tr>
                                    <td id="achiTableLeft">
                                        <c:out value="${pointAchi.username}"/>
                                    </td>
                                    <td id="achiTableRight">
                                        <c:out value="${pointAchi.count}"/>
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                    </td>

                    <td id="ratingsPageColumns">
                        <table>
                            <tr>
                                <th id="achiTableHeader" colspan="2">
                                    <p>ZONE ACHIVEMENTS</p>
                                </th>
                            </tr>
                            <c:forEach var="zoneAchi" items="${userAchiZoneRatingsList}">
                                <tr>
                                    <td id="achiTableLeft">
                                        <c:out value="${zoneAchi.username}"/>
                                    </td>
                                    <td id="achiTableRight">
                                        <c:out value="${zoneAchi.count}"/>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </td>

                </tr>
            </table>

        </body>      
    </tiles:putAttribute>
</tiles:insertDefinition>
