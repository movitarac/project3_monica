<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>

<%@ include file="../_include/header.jsp"%>


    <div class="browsebook">

        <form:form method="POST" action="/library/browse/borrow/" modelAttribute="works">
            <c:forEach items="${worksList}" var="works">
                <ul>
                <li>${works.title} by ${works.author}
                    <li id="borrowbutton"><input type="submit" value="Borrow" /></li>
                </ul>
            </c:forEach>
        </form:form>


    </div>


</body>