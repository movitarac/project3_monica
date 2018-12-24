<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<body>
<%@ include file="../_include/header.jsp" %>



<div class="browsebook">
    <h1>${work.title}</h1>
    <ul class="workdetail">
        <li> <img src="${work.imageUrl}" class="bookcover"/> </li>
        <li id="bookdetail"> Author: ${work.author} <br>
        Publication Year : ${work.publicationYear}<br>
        Description : ${work.bookDescription}<br>

       <a href="/borrow/${work.worksId}" class="badge badge-secondary">Borrow </a>

    </ul>

</div>
<%@ include file="../_include/footer.jsp" %>
</body>
