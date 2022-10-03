<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>

<%@ attribute name="field" required="true" %>

<c:set var="upperArrow" value="&#x25B2;"/>
<c:set var="downArrow" value="&#x25BC;"/>
<c:url var="sortUrl" value="/phones"/>

<c:set var="queryParam" value="${not empty param.query ? 'query='.concat(param.query) : ''}"/>
<c:set var="fromPriceParam" value="${not empty param.fromPrice ? (not empty queryParam ? '&fromPrice='.concat(param.fromPrice) : 'fromPrice='.concat(param.fromPrice)) : ''}"/>
<c:set var="toPriceParam" value="${not empty param.toPrice ? (not empty fromPriceParam or not empty queryParam ? '&toPrice='.concat(param.toPrice) : 'toPrice='.concat(param.toPrice)) : ''}"/>

<c:set var="ascSort" value="${not empty param.query? '&sort='.concat(field).concat(',asc') : 'sort='.concat(field).concat(',asc')}" />
<c:set var="descSort" value="${not empty param.query? '&sort='.concat(field).concat(',desc') : 'sort='.concat(field).concat(',desc')}" />

<a href="${sortUrl}?${queryParam}${ascSort}${fromPriceParam}${toPriceParam}"><c:out value="${upperArrow}" escapeXml="false"/></a>
<a href="${sortUrl}?${queryParam}${descSort}${fromPriceParam}${toPriceParam}"><c:out value="${downArrow}" escapeXml="false"/></a>