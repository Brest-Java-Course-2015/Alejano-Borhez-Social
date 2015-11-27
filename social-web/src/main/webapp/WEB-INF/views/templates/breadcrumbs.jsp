<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="mapping" value="${pageContext.request.requestURI}"/>
<c:set var="usertab" value="${contextPath}${'/WEB-INF/views/user.jsp'}"/>
<c:set var="friends" value="${contextPath}${'/WEB-INF/views/friends.jsp'}"/>
<c:set var="nofriends" value="${contextPath}${'/WEB-INF/views/nofriends.jsp'}"/>

<div id="breadcrumbs">
    <span id="bc_header">
        <a href="${contextPath}/users">
            <spring:message code="users.list"/>
        </a>
        >>
    </span>
    <span id="bc_username_href">
            <a href ="${contextPath}/user?id=${dto.user.userId}">
                ${dto.user.lastName}, ${dto.user.firstName}
            </a>
    </span>
    <span id="bc_delimiter">
        >>
    </span>
    <span id="bc_subheader">
        <c:choose>
            <c:when test="${mapping == friends}">
                <spring:message code="user.friends"/>
            </c:when>
            <c:when test="${mapping == usertab}">
                <spring:message code="user.get"/>
            </c:when>
            <c:when test="${mapping == nofriends}">
                            <spring:message code="user.addfriends"/>
            </c:when>
            <c:otherwise>
                <td>${mapping} ${users}</td>
            </c:otherwise>
        </c:choose>

    </span>
    <span id="bc_username">
        ${dto.user.firstName} ${dto.user.lastName}
    </span>
</div>