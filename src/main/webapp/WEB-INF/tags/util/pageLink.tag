<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="pageText" required="true"%>
<%@ attribute name="pageNumber" required="true" %>

<c:set var="queryParam" value="${not empty param.query ? 'query='.concat(param.query) : ''}"/>
<c:set var="pageParam" value="${not empty pageNumber ? (not empty queryParam ? '&page='.concat(pageNumber) : 'page='.concat(pageNumber)) : ''}"/>
<c:set var="sortParam" value="${not empty param.sort ? (not empty pageParam or not empty queryParam ? '&sort='.concat(param.sort) : 'sort='.concat(param.sort)) : ''}"/>
<c:set var="fromPriceParam" value="${not empty param.fromPrice ? (not empty sortParam or not empty pageParam or not empty queryParam ? '&fromPrice='.concat(param.fromPrice) : 'fromPrice='.concat(param.fromPrice)) : ''}"/>
<c:set var="toPriceParam" value="${not empty param.toPrice ? (not empty fromPriceParam or not empty sortParam or not empty pageParam or not empty queryParam ? '&toPrice='.concat(param.toPrice) : 'toPrice='.concat(param.toPrice)) : ''}"/>

<a href="<c:url value="/phones?${queryParam}${pageParam}${sortParam}${fromPriceParam}${toPriceParam}"/>" class="page-link" >
    <c:out value="${pageText}" />
</a>