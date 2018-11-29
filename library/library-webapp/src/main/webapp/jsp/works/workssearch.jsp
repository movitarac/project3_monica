<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="searchbook">Find your book</h2>
<hr>
<form:form name="searchWork" method="GET">

    <table class="searchbook">
    <tr>
    <label for="inputAuthor" class="sr-only"><td>Author</td></label>
    <td><input type="text" id="inputAuthor"
    class="form-control" placeholder="author" name="author" /></td>
    </tr>
    <tr>
    <label for="inputTitle" class="sr-only"><td>Title</td></label>
    <td> <input type="password" id="inputTitle" placeholder="title"
    class="form-control" name="title" /></td>
    </tr>
    <tr>
    <td><input type="submit" value="Search" /></td>
    <td><input type="reset" value="Clear the Form"></td>
    </tr>
    </table>

</form:form>
