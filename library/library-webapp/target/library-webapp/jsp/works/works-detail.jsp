
<body>
<%@ include file="../_include/header.jsp" %>
<form:form action="/library/browse/borrow/" method="POST">
<div class="browsebook">

    <p class="worksdesc">

        <h1>${work.title}</h1> <br>
        <span class="worksDetail">Author: </span> <span class="worksInfo">${work.author}</span> <br>
        <span class="worksDetail">Publication Year:</span> <span class="worksInfo">${work.publicationYear}</span> <br>
        <span class="worksDetail">Description: </span> <span class="worksInfo">${work.bookDescription}</span> <br>

        <button class="butBorrow" type="submit">Borrow</button>
       <br>

    </p>

</div>
</form:form>
<%@ include file="../_include/footer.jsp" %>
</body>
