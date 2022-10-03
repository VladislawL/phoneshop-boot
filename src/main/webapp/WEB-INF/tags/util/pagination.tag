<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ attribute name="searchParameter" required="true" type="com.expertsoft.phoneshop.search.SearchParameter" %>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" %>
<%@ attribute name="numberOfPages" required="true" type="java.lang.Integer" %>

<ul class="pagination">
<c:if test="${numberOfPages > 0}">
    <li class="page-item ${page.first ? 'disabled' : ''}"><util:pageLink pageText="<<" pageNumber="${page.number - 1}"/></li>
    <c:forEach begin="0" var="productListPage" end="${numberOfPages - 1}">
        <li class="page-item <c:if test="${productListPage == page.number}">active</c:if>"><util:pageLink pageText="${productListPage}" pageNumber="${productListPage}"/></li>
    </c:forEach>
    <li class="page-item ${page.last ? 'disabled' : ''}"><util:pageLink pageText=">>" pageNumber="${page.number + 1}"/></li>
</c:if>
</ul>
