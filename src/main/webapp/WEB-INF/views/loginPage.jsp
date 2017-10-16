<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <head>

            <link href="<c:url value="/resources/css/views/loginPage.css" />" rel="stylesheet">

        </head>

        <body>
            <!-- /login?error=true -->
            <c:if test="${param.error == 'true'}">
                <div class="loginError">

                    Login Failed<br />
                    Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

                </div>
            </c:if>

            <form name='form' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>

                <table>
                    <tr>
                        <td>
                            <h3>Sign in to account</h3>
                            <div class="loginInputGroup">
                                <input  type="text" name="username" placeholder="Enter Username" required>
                            </div>
                            <div class="loginInputGroup">
                                <input  type="password" name="password" placeholder="Enter Password" required>
                            </div>
                            <div class="loginInputGroup">
                                <button type="submit">SIGN IN</button>
                            </div>
                        </td>
                    </tr>
                </table>

            </form>
        </body>
    </tiles:putAttribute>
</tiles:insertDefinition>
