<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body class="loginelement">
<%@ include file="../_include/header.jsp" %>

<form:form action="/library/profile" method="POST">
    <div align="center">
        <h1 class="h3 mb-3 font-weight-normal">Are you a member? Please sign in</h1>
        <table>
            <tr>
                <label for="inputUsername" class="sr-only"><td>Username</td></label>
                <td><input type="username" id="inputUsername"
                           class="form-control" placeholder="username" name="username" path="username"/></td>
            </tr>
            <tr>
                <label for="inputPassword" class="sr-only"><td>Password</td></label>
                <td> <input type="password" id="inputPassword" placeholder="password"
                            class="form-control" name="password" path="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Login" /></td>
            </tr>
        </table>
        <div style="color: red">${msg}</div>
        <input type="hidden" name="{_csrf.parameterName}" value="{_csrf.token}">

    </div>
</form:form>
</body>

