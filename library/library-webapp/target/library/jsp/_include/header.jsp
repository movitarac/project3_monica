<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet" type="text/css">
        <link href="<c:url value="/resources/style/style.css" />" rel="stylesheet" type="text/css">
        <title>Test</title>
    </head>
    <body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand">City Library</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" id="menuS0">Home</a>
        </li>
        
        <li class="nav-item">
          <a class="nav-link" id="menuS">Works</a>
        </li> 
        <li class="nav-item">
          <a class="nav-link" id="menuS1">Connection</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" id="menuS2">How to?</a>
        </li>
      </ul>
      <form class="form-inline mt-2 mt-md-0">
        <input class="form-control mr-sm-2" name="search" placeholder="Works,book,title..." >
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
      
    </div>
  </nav>
</header>

</body>
</html>