<body class="worksFound">
<%@ include file="../_include/header.jsp" %>
<div>

    <c:if test="${not empty worksListFound}">

        <c:forEach items="${worksListFound}" var="work">

            <ul class="worksfounddetail">

                <li><h4>${work.title}</h4> by ${work.author}</li>

                    <span class="profDetail">Book description: </span> <span class="profInfo">${work.bookDescription}</span> <br>
                    <span class="profDetail">Publication year: </span> <span class="profInfo">${work.publicationYear}</span> <br>
                <span class="profDetail">Available copies: </span> <span class="profInfo">${work.copiesvailable}</span> <br>

            </ul>

        </c:forEach>
    </c:if>



</div>
<%@ include file="../_include/footer.jsp" %>
</body>
