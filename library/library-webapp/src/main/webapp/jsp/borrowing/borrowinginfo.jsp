<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<body class="borrowlist">
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">

    <h2 class="cover-heading">Your borrowing information </h2>
    <br>
    <c:choose>
        <c:when test="${not empty message}">
            <span class="alert alert-success" role="alert"> ${message}</span>
        </c:when>
        <c:when test="${not empty msgError}">
            <span class="alert alert-danger" role="alert"> ${msgError}</span>
        </c:when>
        <c:otherwise>
            <span></span>
        </c:otherwise>
    </c:choose>

    <br><br>
    <c:choose>
        <c:when test="${not empty borrowingList}">

            <c:forEach items="${borrowingList}" var="borrow">

                <h5>${borrow.book.work.title}</h5>
                <ul>

                    <li>Issue date : <fmt:formatDate value="${borrow.issueDate.toGregorianCalendar().time}" pattern="yyyy-MM-dd" /></li>
                    <li>Due date : <fmt:formatDate value="${borrow.returnDate.toGregorianCalendar().time}" pattern="yyyy-MM-dd" /></li>
                    <li>Status: ${borrow.status}</li>

                    <c:choose>
                        <c:when test="${borrow.status != 'returned'}">
                            <li class="badge badge-pill badge-light list-unstyled">
                                <a href="${pageContext.request.contextPath}/borrowinglist/extend/${borrow.idborrow}">Extend your borrowing</a>
                            </li>
                            <li class="badge badge-pill badge-light list-unstyled">
                                <a href="${pageContext.request.contextPath}/borrowinglist/return/${borrow.idborrow}">Return this book</a></li>
                        </c:when>
                        <c:otherwise>
                            <br>
                            <span class="alert alert-primary" role="alert"> --This book is already returned--</span>
                        </c:otherwise>
                    </c:choose>

                </ul>
            </c:forEach>

            <a href="${pageContext.request.contextPath}/profile"> back to profile</a>
        </c:when>
        <c:otherwise>
            <h5>You haven't borrowed any book from the library</h5>
            <a href="${pageContext.request.contextPath}/profile"> back to profile</a>
            <br>
            <a href="${pageContext.request.contextPath}/browse"> browse books </a>
        </c:otherwise>
    </c:choose>

</main>

</body>
