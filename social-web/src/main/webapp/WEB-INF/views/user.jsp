<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title><spring:message code="users.list"/> - <spring:message code="user.get"/> ${dto.user.firstName} ${dto.user.lastName}</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<h1><spring:message code="user.get"/> ${dto.user.firstName} ${dto.user.lastName}</h1>

<jsp:include page="templates/breadcrumbs.jsp"/>

<jsp:include page="templates/user.jsp"/>

<h2><spring:message code="user.friends"/> ${dto.user.firstName} ${dto.user.lastName}</h2>

<jsp:include page="templates/table.jsp"/>

<div id="userTotal">
    <h3><spring:message code="friends.total"/>: ${dto.totalUsers}</h3>
    <button id="addUser" style="float: right; position:relative; right: 50px" onclick="gotoAddFriends()"><spring:message code="friend.create"/></button>
    <script>
    function gotoAddFriends() {
        window.location = "${contextPath}/nofriends?id=${dto.user.userId}";
    }
    </script>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>


</body>
</html>