<body class="profile">
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">


        <p class="sorry">Sorry.. <br>
                ${loggedInMember.firstName}
                <br>
                the book is not available, please choose another book.
                <br>
                <a href="${pageContext.request.contextPath}/browse">go back to browse</a>
        </p>

</main>
</body>