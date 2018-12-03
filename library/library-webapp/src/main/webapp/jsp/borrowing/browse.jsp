<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>

<%@ include file="../_include/header.jsp"%>


    <div class="browsebook">

        <form:form method="POST" action="/library/browse/borrow/" modelAttribute="member">
            <c:forEach items="${worksList}" var="work">
                <ul>
                <li>${work.title} by ${work.author}
                    <li id="borrowbutton"><input type="submit" value="Borrow" /></li>
                </ul>
            </c:forEach>
        </form:form>


    </div>


</body>