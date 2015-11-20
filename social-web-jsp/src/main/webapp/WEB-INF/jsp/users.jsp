<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title><spring:message code="user.list"/></title>
</head>
<body>

<h1>Hello!</h1>

<span>${dto.totalUsers}</span>

</body>
</html>