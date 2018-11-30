
<body>

<%@ include file="../_include/header.jsp"%>
    <div class="browsebook">


            <c:forEach items="${worksList}" var="work">
                <ul>
                <li>${work.title} by ${work.author}
                    <li id="borrowbutton"><input type="submit" value="Borrow" /></li>
                </ul>
            </c:forEach>



    </div>




</body>