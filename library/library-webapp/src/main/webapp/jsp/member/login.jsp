<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/style/connection.css" />" rel="stylesheet" type="text/css">
        <%@ include file="../_include/header.jsp" %>
    </head>
<body class="text-center">
    
  <div class="row">
      <div class="col-6">
  
  <form class="form-signin login">
        <h1 class="h3 mb-3 font-weight-normal" id="anyaccount">Are you a member?<br> Please sign in</h1>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control"  [(ngModel)]="emailaddress"  name="user" placeholder="email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" [(ngModel)]="passworduser"  name="pass" class="form-control" placeholder="password" required>
        <div class="checkbox mb-3">
          <label class="remember">
            <input type="checkbox" value="remember-me" > Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block butSignIn" type="submit" (click)="getAccount()">Sign in</button>
      </form>
    </div>
  
  <div class="col-6">
  <form class="form-signin signup">
        <h1 class="h3 mb-3 font-weight-normal" id="anyaccount1">Do you want to be our member?<br>You can sign up</h1>
        <label for="inputFirstName" class="sr-only" >First Name</label>
        <input type="firstname" id="inputFirstName" class="form-control" placeholder="first name" required autofocus>
        <label for="inputLastName" class="sr-only" >Last Name</label>
        <input type="lastname" id="inputLastName" class="form-control" placeholder="last name" required autofocus>
        <label for="inputAddress" class="sr-only" >Address</label>
        <input type="address" id="inputAddress" class="form-control" placeholder="address" required autofocus>
        <label for="inputEmail" class="sr-only" >Email address</label>
        <input type="email" id="inputEmail2" class="form-control" placeholder="email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword2" class="form-control" placeholder="password" required>
        <div class="checkbox mb-3">
          <label class="remember">
            <input type="checkbox" value="remember-me" > Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block butSignIn" type="submit">Sign up</button>
      </form>
  
  </div>
  
</div>
<%@ include file="../_include/footer.jsp" %>
   </body>