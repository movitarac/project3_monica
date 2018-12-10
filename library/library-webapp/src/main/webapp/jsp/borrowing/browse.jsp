<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>

<%@ include file="../_include/header.jsp"%>


    <div class="browsebook">


            <c:forEach items="${worksList}" var="work">
                <form:form method="POST" action="/library/borrow">
                <ul>
                    <li><a href="/library/workinfo/${work.worksId}" class="infowork">${work.title} by ${work.author}</a>
                    <input hidden name="worksId" value="${work.worksId}"/>
                    <li id="borrowbutton"><input type="submit" class="btn btn-success" value="Borrow" /></li>
                </ul>
                </form:form>
            </c:forEach>

        <div class="message">${msg}</div>

    </div>


</body>