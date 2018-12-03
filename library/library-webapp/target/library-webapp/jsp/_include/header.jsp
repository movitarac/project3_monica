<%@ include file="../_include/taglib.jsp" %>
<style> <%@include file="/resources/style/style.css" %>
<%@include file="/resources/style/bootstrap.min.css" %>

</style>
<header class="header">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand"><span class="citylibrary">City Library</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" id="menuS0" href="/library">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" id="menuS" href="/library/condition">Condition</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="menuS1" href="/library/registration">Registration</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="menuS2" href="/library/information">How to?</a>
                </li>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="menuS3" href="/library/browse">Browse</a>
                </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0">



                        <button class="btn btn-outline-success my-2 my-sm-0" type="l"><a href="/library/login">Log in</a></button>


            </form>

        </div>
    </nav>
</header>