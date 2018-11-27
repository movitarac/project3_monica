
<body>
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">
    <h1 class="cover-heading">Works detail</h1>
    <p class="borrow">
        <span class="borrowDetail">Title </span> <span class="borrowInfo">${workstitle}</span> <br>
        <span class="borrowDetail">Issue date: </span> <span class="borrowInfo">${issuedate}</span> <br>
        <span class="borrowDetail">Return date: </span> <span class="borrowInfo">${returndate}</span> <br>
        <span class="borrowDetail">Status: </span> <span class="borrowInfo">${status}</span> <br>
        <span class="borrowDetail">Extended: </span> <span class="borrowInfo">${isextended}</span> <br>
        <span class="borrowDetail"></span>
        <button class="btn btn-lg btn-primary btn-block butBorrow" type="submit">Add borrow/button>
        <span class="borrowInfo"></span> <br>

    </p>

</main>
<%@ include file="../_include/footer.jsp" %>
</body>
