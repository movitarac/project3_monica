
<body>
<h1 class="aboutwho">Who are we?</h1>

<p>

    This web application can help to manage and store works - book information electronically according to users needs.
    It helps both member and librarian to check and keep a constant track of all the works - book available in the library
    as well as check the returned date of the loan.
</p>
<%@ include file="../_include/header.jsp" %>

<div class="container">
    <ul>
        <li>Application : ${application.name}</li>
        <li>Version : ${project.version}</li>
        <li>Creation date : ${maven.build.timestamp}</li>
    </ul>
</div>

<%@ include file="../_include/footer.jsp" %>
</body>
