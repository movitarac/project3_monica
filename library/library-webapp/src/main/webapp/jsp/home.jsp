<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <<link href="<c:url value="/resources/style/bootstrap.min.css" />" rel="stylesheet" type="text/css">
        
        <title>Test</title>
    </head>
    <body>
        <h1>Hello ${firstname} ${lastname} welcome to electronic library</h1>
    </body>
</html>