<body class="profile">
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">

    <c:if test="${not empty list}">
        <h1 class="cover-heading">${list.get(0)}</h1>
        <p class="lead">
            <span class="profDetail">Author </span> <span class="profInfo">${list.get(1)}</span> <br>
            <span class="profDetail">Book description: </span> <span class="profInfo">${list.get(2)}</span> <br>
            <span class="profDetail">Publication year: </span> <span class="profInfo">${list.get(3)}</span> <br>
            <span class="profDetail">Copies: </span> <span class="profInfo">${list.get(4)}</span> <br>
            <span class="profDetail"></span>
            <button class="btn btn-lg btn-primary btn-block butSignIn" type="submit"> Borrowing list</button>
            <span class="profInfo"></span> <br>

        </p>
    </c:if>

</main>
<%@ include file="../_include/footer.jsp" %>
</body>
