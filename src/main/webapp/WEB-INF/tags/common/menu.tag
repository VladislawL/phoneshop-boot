<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row">
    <div class="col-4 offset-9">
        <sec:authorize access="!isAuthenticated()">
            <a href="<c:url value="/login"/>">
                <button type="button" class="btn btn-primary">Login</button>
            </a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            Hello, <sec:authentication property="name" />
            <form method="post" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-primary">Logout</button>
            </form>
        </sec:authorize>
    </div>
    <div class="col-4 offset-9">
        <a href="<c:url value="/admin"/>">
            <p>Admin panel</p>
        </a>
    </div>
</div>