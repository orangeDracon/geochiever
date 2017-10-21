<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link href="<c:url value="/resources/css/template/menu.css" />" rel="stylesheet">
</head>

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

            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
                </li>
            </c:if>
    </ul>
</body>