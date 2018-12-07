<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body class="profile">
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">
<form:form method="POST" action="/library/borrowinglist">
    <c:if test="${not empty member}">
        <h1 class="persoinfo">Your personal information</h1>
        <p class="lead">
            <span class="profDetail">First Name: </span> <span class="profInfo">${details.get(0)}</span> <br>
            <span class="profDetail">Last Name: </span> <span class="profInfo">${details.get(1)}</span> <br>
            <span class="profDetail">Username: </span> <span class="profInfo">${details.get(2)}</span> <br>
            <span class="profDetail">Email: </span> <span class="profInfo">${details.get(3)}</span> <br>
            <span class="profDetail">Address: </span> <span class="profInfo">${details.get(4)}</span> <br>
            <span class="profDetail"></span>
            <button class="btn btn-lg btn-primary btn-block butBorrowList" type="submit"> Borrowing list</button>
            <span class="profInfo"></span> <br>
        </p>
    </c:if>
</form:form>
</main>

</body>
