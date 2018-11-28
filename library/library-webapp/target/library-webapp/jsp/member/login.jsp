
<body>
<%@ include file="../_include/header.jsp" %>
<form class="form-signin" method="post">
    <h1 class="h3 mb-3 font-weight-normal">Are you a member?<br>Please sign in</h1>
    <label for="inputUsername" class="sr-only">Username</label>
    <input type="username" id="inputUsername" class="form-control" placeholder="username" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</form>
<%@ include file="../_include/footer.jsp" %>
</body>
</html>