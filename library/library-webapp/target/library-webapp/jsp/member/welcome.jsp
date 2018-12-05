<body class="profile">
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">

<c:if test="${not empty member}">
    <h1>Welcome ${member.firstname} ${member.lastname}</h1>
</c:if>
</main>
</body>