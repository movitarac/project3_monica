<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<%@ include file="../_include/header.jsp" %>


<form:form method="POST" action="/library/borrow">
<div class="browsebook">
    <h1>${work.title}</h1>
    <ul class="workdetail">
        <li hidden><input hidden name="worksId" value="${work.worksId}"/></li>
        <li> <img src="${work.imageUrl}" class="bookcover"/> </li>
        <li id="bookdetail"> Author: ${work.author} <br>
        Publication Year : ${work.publicationYear}<br>
        Description : ${work.bookDescription}<br>

        <button type="submit" class="btn btn-success">Borrow</button></li>

    </ul>

</div>
</form:form>
<%@ include file="../_include/footer.jsp" %>
</body>
