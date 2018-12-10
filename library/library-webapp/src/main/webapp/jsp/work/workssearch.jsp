<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h2 class="searchbook">Find your book</h2>
<hr>
<form:form method="GET" name="workssearch" action="/library/searchbyauthor">
    <table class="searchbook">
        <tr>
            <label for="inputAuthor" class="sr-only">
                <td>Author</td>
            </label>
            <td><input type="text" id="inputAuthor"
                       class="form-control" placeholder="author" name="author"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Search" class="btn btn-secondary"/></td>
            <td><input type="reset" value="Clear the Form" class="btn btn-secondary"></td>
        </tr>
    </table>
</form:form>