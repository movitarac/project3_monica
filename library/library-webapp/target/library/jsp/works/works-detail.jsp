
<body>
<%@ include file="../_include/header.jsp" %>
<main role="main" class="inner cover">
    <h1 class="cover-heading">Works detail</h1>
    <p class="worksdesc">

        <span class="worksDetail">Title: </span> <span class="worksInfo">${title}</span> <br>
        <span class="worksDetail">Author: </span> <span class="worksInfo">${author}</span> <br>
        <span class="worksDetail">Publication Year: </span> <span class="worksInfo">${publicationyear}</span> <br>
        <span class="worksDetail">Description: </span> <span class="worksInfo">${description}</span> <br>
        <span class="worksDetail">Copies: </span> <span class="worksInfo">${copies}</span> <br>
        <span class="worksDetail"></span>
        <button class="btn btn-lg btn-primary btn-block butBook" type="submit">Borrowing list</button>
        <span class="worksInfo"></span> <br>

    </p>

</main>
<%@ include file="../_include/footer.jsp" %>
</body>
