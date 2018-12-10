
<body>
<%@ include file="../_include/taglib.jsp" %>
<main role="main" class="inner cover">
    <h4 class="cover-heading">Your borrowing information </h4>
    <c:forEach items="${borrowingList}" var="borrow">

        <h5>${borrow.book.works.title}</h5>
        <ul>
            <li>Issue date : ${borrow.issueDate}</li>
            <li>Return date : ${borrow.issueDate}</li>
            <li>Status: ${borrow.status}</li>
            <input hidden name="idborrow" value="${borrow.idborrow}"/>
            <li id="extendbutton"><input type="submit" class="btn btn-success" value="Extend" /></li>
            <li id="returnbutton"><input type="submit" class="btn btn-success" value="Return book" /></li>
        </ul>

    </c:forEach>

</main>
<%@ include file="../_include/footer.jsp" %>
</body>
