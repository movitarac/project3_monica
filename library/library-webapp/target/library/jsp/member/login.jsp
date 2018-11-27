
<body>
<%@ include file="../_include/header.jsp" %>
<div class="element1">
<div class="row">
    <div class="col">
        <form class="form-signin login">
            <h1 class="h3 mb-3 font-weight-normal" id="anyaccount">Are you a member?<br> Please sign in</h1>
            <label for="inputUsername" class="sr-only">Username</label>
            <input type="username" id="inputUsername" class="form-control" name="user" placeholder="username"
                   required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="pass" class="form-control" placeholder="password" required>
            <div class="checkbox mb-3">
                <label class="remember">
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block butSignIn" type="submit">Sign in</button>
        </form>

        <div class="col">
            <h4>Not a member? Do you want to be our member?<br>You can sign up</h4>
            <p><a href="/registration"> create your account </a></p>
        </div>
    </div>

</div>
</div>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>