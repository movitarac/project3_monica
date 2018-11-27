
<body class="text-center">
<%@ include file="../_include/header.jsp" %>
<div class="element">
    <form class="form-signin signup">
        <h1 class="h3 mb-3 font-weight-normal" id="anyaccount1">Create your account member</h1>
        <label for="inputFirstName" class="sr-only" >First Name</label>
        <input type="firstname" id="inputFirstName" class="form-control" placeholder="first name" required autofocus>
        <label for="inputLastName" class="sr-only" >Last Name</label>
        <input type="lastname" id="inputLastName" class="form-control" placeholder="last name" required autofocus>
        <label for="inputAddress" class="sr-only" >Address</label>
        <input type="address" id="inputAddress" class="form-control" placeholder="address" required autofocus>
        <label for="inputUsername2" class="sr-only" >Username</label>
        <input type="username" id="inputUsername2" class="form-control" placeholder="username" required autofocus>
        <label for="inputEmail2" class="sr-only" >Email address</label>
        <input type="email" id="inputEmail2" class="form-control" placeholder="email address" required autofocus>
        <label for="inputPassword2" class="sr-only">Password</label>
        <input type="password" id="inputPassword2" class="form-control" placeholder="password" required>
        <div class="checkbox mb-3">
            <label class="remember">
                <input type="checkbox" value="remember-me" > Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block butSignIn" type="submit">Sign up</button>
    </form>

</div>
<%@ include file="../_include/footer.jsp" %>
</body>