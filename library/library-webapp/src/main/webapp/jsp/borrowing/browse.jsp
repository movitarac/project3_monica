<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>

<%@ include file="../_include/header.jsp"%>


    <div class="browsebook">


            <c:forEach items="${worksList}" var="works">
                <form:form method="POST" action="/library/borrow">
                <ul>
                <li>${works.title} by ${works.author}
                    <input hidden name="worksId" value="${works.worksId}"/>
                    <li id="borrowbutton"><input type="submit" class="btn btn-success" value="Borrow" /></li>
                </ul>
                </form:form>
            </c:forEach>

        <div class="message">${msg}</div>

    </div>


</body>