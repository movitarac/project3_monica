<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body class="signupnelement">
<%@ include file="../_include/header.jsp" %>

<form:form name="submitForm" method="POST">
    <div align="center">
        <h1 class="h3 mb-3 font-weight-normal">Not a member? You can sign up</h1>
        <table>
            <tr>
                <label for="inputFirstname" class="sr-only"><td>First name</td></label>
                <td><input type="firstname" id="inputFirstname"
                           class="form-control" placeholder="firstname" name="firstName" /></td>
            </tr>

            <tr>
                <label for="inputLastname" class="sr-only"><td>Last name</td></label>
                <td><input type="lastname" id="inputLastname"
                           class="form-control" placeholder="lastname" name="lastName" /></td>
            </tr>

            <tr>
                <label for="inputAddress" class="sr-only"><td>Address</td></label>
                <td><input type="address" id="inputAddress"
                           class="form-control" placeholder="address" name="address" /></td>
            </tr>

            <tr>
                <label for="inputEmail" class="sr-only"><td>Email</td></label>
                <td><input type="email" id="inputEmail"
                           class="form-control" placeholder="email" name="email" /></td>
            </tr>

            <tr>
                <label for="inputUsername" class="sr-only"><td>Username</td></label>
                <td><input type="username" id="inputUsername"
                           class="form-control" placeholder="username" name="username" /></td>
            </tr>
            <tr>
                <label for="inputPassword" class="sr-only"><td>Password</td></label>
                <td> <input type="password" id="inputPassword" placeholder="password"
                            class="form-control" name="password" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Sign up" /></td>
            </tr>
        </table>
        <div>${error}</div>

    </div>
</form:form>
</body>

