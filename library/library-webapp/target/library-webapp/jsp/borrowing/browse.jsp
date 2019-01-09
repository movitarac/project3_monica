<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>

<%@ include file="../_include/header.jsp"%>

    <div class="browsebook">

            <c:forEach items="${worksList}" var="work">
                <ul class="list-unstyled media">
                    <li>
                   <a href="${pageContext.request.contextPath}/borrow/${work.worksId}" class="badge badge-secondary">Borrow this book</a>
                    </li>
                    <li class="media-body">
                            <a href="${pageContext.request.contextPath}/workinfo/${work.worksId}" class="infowork">${work.title}
                        by ${work.author}</a>
                    </li>

                </ul>
            </c:forEach>
    </div>


</body>