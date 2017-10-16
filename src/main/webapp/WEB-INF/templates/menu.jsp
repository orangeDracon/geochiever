<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link href="<c:url value="/resources/css/template/menu.css" />" rel="stylesheet">
</head>

<!--<body>
    <table class="table">
        <tr>
            <th class="button">
                <a href="${pageContext.request.contextPath}/welcome" target="_blank">HOME</a>  
            </th>

            <th class="button">
                <a href="${pageContext.request.contextPath}/userProfile">USER PROFILE</a>
            </th>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <th class="button">
                    <a href="${pageContext.request.contextPath}/register">REGISTER</a>
                </th>
            </c:if>

            <th class="button">
                <a href="${pageContext.request.contextPath}/ratings">RATINGS</a>
            </th>

            <th class="button">
                <a href="${pageContext.request.contextPath}/achievements">LATEST ACHIVEMENTS</a>
            </th>

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <th class="button">
                    <a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
                </th>
            </c:if>
        </tr>
    </table>
</body>-->

<body>
    <ul>
            <li>
                <a href="${pageContext.request.contextPath}/welcome">HOME</a>  
            </li>

            <li>
                <a href="${pageContext.request.contextPath}/userProfile">USER PROFILE</a>
            </li>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li>
                    <a href="${pageContext.request.contextPath}/register">REGISTER</a>
                </li>
            </c:if>

            <li>
                <a href="${pageContext.request.contextPath}/ratings">RATINGS</a>
            </li>

            <!--<li>
                <a href="${pageContext.request.contextPath}/achievements">LATEST ACHIVEMENTS</a>
            </li>-->

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
                </li>
            </c:if>
    </ul>
</body>