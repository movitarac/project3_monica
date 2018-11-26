<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/style/profile.css" />" rel="stylesheet" type="text/css">
        
        <%@ include file="../_include/header.jsp" %>
    </head>
    <body>
<main role="main" class="inner cover">
  <h1 class="cover-heading">Your personal information</h1>
  <p class="lead">
    <span class="profDetail">First Name: </span> <span class="profInfo">${firstname}</span> <br>
    <span class="profDetail">Last Name: </span> <span class="profInfo">${lastname}</span> <br>
    <span class="profDetail">Email: </span> <span class="profInfo">${email}</span> <br>
    <span class="profDetail">Address: </span> <span class="profInfo">${address}</span> <br>
    <span class="profDetail"></span><button class="btn btn-lg btn-primary btn-block butSignIn" type="submit">Borrowing list </button><span class="profInfo"></span> <br>

  </p>
  
</main>
 <%@ include file="../_include/footer.jsp" %>
</body>
</html>