<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet" type="text/css">
        
        <%@ include file="../_include/header.jsp" %>
    </head>
    <body class="information">
        <h1>Becoming a member</h1>
        <p> On your first visit to the Library
        <ul>
        	<li>present to Library Reception</li>
        	<li>bring ID card and a proof of address</li>
        	<li>complete the application form</li>
        	<li>confirm the Library's conditions of use</li>
        	<li>confirm the Computer Use Policy</li>
        </ul>
        The receptionist or the librarian will help you to create your online account, so you can check and organize your borrowing list.
        </p>
       
         <%@ include file="../_include/footer.jsp" %>
    </body>
</html>