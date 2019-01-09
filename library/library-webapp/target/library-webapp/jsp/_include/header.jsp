<%@ include file="../_include/taglib.jsp" %>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand"><span class="citylibrary">City Library</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" id="menuS0" href="${pageContext.request.contextPath}">Home</a>
                </li>

                </li>
                <li class="nav-item">
                    <a class="nav-link" id="menuS3" href="${pageContext.request.contextPath}/browse">Browse</a>
                </li>
                <c:if test="${not empty memberConnected}">
                <li class="nav-item">
                    <a class="nav-link" id="menuS4" href="${pageContext.request.contextPath}/profile">Profile</a>
                </li>
                    <li class="nav-item">
                        <a class="nav-link" id="menuS5" href="${pageContext.request.contextPath}/borrowinglist">Borrowing List</a>
                    </li>



                </c:if>
            </ul>
            <a class="nav-link" href="${pageContext.request.contextPath}/profile"> ${memberConnected.firstName} ${memberConnected.lastName}</a>
            <c:choose>
                <c:when test="${empty memberConnected}">
                    <form class="form-inline mt-2 mt-md-0">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="l"><a href="${pageContext.request.contextPath}/login">Log in</a>
                        </button>
                    </form>
                </c:when>
                <c:otherwise>
            <button class="btn btn-outline-success my-2 my-sm-0" type="l"><a href="${pageContext.request.contextPath}/logout">Log out</a>
                </c:otherwise>
            </c:choose>


        </div>
    </nav>
</header>
