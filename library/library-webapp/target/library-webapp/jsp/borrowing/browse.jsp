<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>

<%@ include file="../_include/header.jsp"%>


    <div class="browsebook">


            <c:forEach items="${worksList}" var="works">
                <form:form method="GET" action="/library/browse/borrow/${works.worksId}">
                <ul>
                <li>${works.title} by ${works.author}
                    <li id="borrowbutton"><input type="submit" value="Borrow" /></li>
                </ul>
                </form:form>
            </c:forEach>



    </div>


</body>