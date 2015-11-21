<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title><spring:message code="users.list"/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Социальная сеть - список пользователей</title>

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

<h1><spring:message code="users.list"/></h1>

<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>UserId</th>
            <th>Логин</th>
            <th>Фамилия, Имя</th>
            <th>Возраст</th>
            <th>Друзья</th>
            <th>Пароль</th>
            <th>Дата создания</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody id="userList">
        <c:forEach items="${dto.users}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.login}</td>
                    <td>${user.lastName}, ${user.firstName}</td>
                    <td>${user.age}</td>
                    <td>${user.totalFriends}</td>
                    <td>${user.password}</td>
                    <td>${user.createdDate}</td>
                    <td><button>Удалить</button><button>Изменить</button></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div id="userTotal">
    <h3><spring:message code="users.total"/>: ${dto.totalUsers}</h3>
    <button id="addUser" style="float: right; position:relative; right: 50px" onclick="gotoAddUser()">Добавить пользователя</button>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>