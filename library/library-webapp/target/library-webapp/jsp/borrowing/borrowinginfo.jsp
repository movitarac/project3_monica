
<body class="borrowlist">
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">
    <h4 class="cover-heading">Your borrowing information </h4>
    <c:choose>
    <c:when test="${not empty borrowingList}">

    <c:forEach items="${borrowingList}" var="borrow">

        <h5>${borrow.book.work.title}</h5>
        <ul>
            <li>Issue date : ${borrow.issueDate}</li>
            <li>Return date : ${borrow.issueDate}</li>
            <li>Status: ${borrow.status}</li>
            <input hidden name="idborrow" value="${borrow.idborrow}"/>
            <li id="extendbutton"><input type="submit" class="btn btn-success" value="Extend" /></li>
            <li id="returnbutton"><input type="submit" class="btn btn-success" value="Return book" /></li>
        </ul>


    </c:forEach>
        <a href="/library/profile"> back to profile</a>
    </c:when>
        <c:otherwise>
            <h5>You haven't borrowed any book from the library</h5>
            <a href="/library/profile"> back to profile</a>
            <br>
            <a href="/library/browse"> browse books </a>
        </c:otherwise>
    </c:choose>
</main>
<%@ include file="../_include/footer.jsp" %>
</body>
