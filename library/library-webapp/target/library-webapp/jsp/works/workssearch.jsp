<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="searchbook">Find your book</h2>
<hr>
<form:form method="GET" name="workssearch" action="/library/search">

    <table class="searchbook">
    <tr>
    <label for="inputAuthor" class="sr-only"><td>Author</td></label>
    <td><input type="text" id="inputAuthor"
    class="form-control" placeholder="author" name="author" /></td>
    </tr>
    <tr>
    <td><input type="submit" value="Search" /></td>
    <td><input type="reset" value="Clear the Form"></td>
    </tr>
    </table>

</form:form>
