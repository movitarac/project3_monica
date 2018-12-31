<body >
<%@ include file="../_include/header.jsp" %>
<div class="worksFound">

    <c:if test="${not empty worksListFound}">

        <c:forEach items="${worksListFound}" var="work">

            <ul class="worksfounddetail">

                <li><a href="/library-webapp/workinfo/${work.worksId}" class="infowork"> <h4>${work.title}</h4> by ${work.author}</a></li>
                <span class="profDetail">Available copies: </span> <span class="profInfo">${work.copiesvailable}</span><br>

            </ul>

        </c:forEach>
    </c:if>



</div>
<%@ include file="../_include/footer.jsp" %>
</body>
