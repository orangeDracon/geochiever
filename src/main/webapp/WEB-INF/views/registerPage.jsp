<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <head>

            <link href="<c:url value="/resources/css/views/registerPage.css" />" rel="stylesheet">

        </head>

        <body>
            <div>
                <form:form method="POST" modelAttribute="registerForm" >
                    <table>
                        <tr>
                            <td>
                                <h3>Create account</h3>
                                <spring:bind path="username">
                                    <div class="registerInputGroup">
                                        <form:input type="text" path="username" placeholder="Username"
                                                    autofocus="true"></form:input>
                                        <form:errors path="username" id="error"></form:errors>
                                        </div>
                                </spring:bind>

                                <spring:bind path="email">
                                    <div class="registerInputGroup">
                                        <form:input type="email" path="email" placeholder="Email"
                                                    autofocus="true"></form:input>
                                        <form:errors path="email" id="error"></form:errors>
                                        </div>
                                </spring:bind>

                                <spring:bind path="password">
                                    <div class="registerInputGroup">
                                        <form:input type="password" path="password" placeholder="Password"></form:input>
                                        <form:errors path="password" id="error"></form:errors>
                                        </div>
                                </spring:bind>

                                <spring:bind path="passwordConfirm">
                                    <div class="registerInputGroup">
                                        <form:input type="password" path="passwordConfirm"
                                                    placeholder="Confirm password"></form:input>
                                        <form:errors path="passwordConfirm" id="error"></form:errors>
                                        </div>
                                </spring:bind>
                                <div class="registerInputGroup">
                                    <button type="submit" >SIGH UP</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
        </body>
    </tiles:putAttribute>
</tiles:insertDefinition>
