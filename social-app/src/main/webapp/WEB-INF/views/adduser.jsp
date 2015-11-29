<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="url" value="${contextPath}"/>
<html>
<head>
    <title><spring:message code="users.list"/> - <spring:message code="user.create"/></title>
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

<h1><spring:message code="user.create"/></h1>

<form id="userForm">
    <div class="mainArea">

        <label>Login:</label><br>
        <input type="text" id="login" name="login" required>
        <br>
        <label>Password:</label><br>
        <input type="password" id="password" name="password" required>
        <br>
        <label>FirstName:</label><br>
        <input type="text" id="firstName" name="firstName" required>
        <br>
        <label>LastName:</label><br>
        <input type="text" id="lastName" name="lastName" required>
        <br>
        <label>Age:</label><br>
        <input type="number" id="age" name="age" required>
        <br>
        <button id="addUser" type="reset">Добавить</button>

    </div>
</form>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script>
$('#addUser').click(function () {
        addUser();
});


function goHome() {
    window.location='<c:url value="users"/>';
}

function addUser() {
    console.log('addUser');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: '<c:url value="/addusersubmit"/>',
        data: formToJSON(),
        success: function () {
            alert('Пользователь успешно добавлен');
            if (confirm("Хотите добавить ещё одного пользователя?")) {

            } else {
            goHome();
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('addUser error: ' + textStatus + ': ' + errorThrown);
        }
    });
}

function formToJSON() {
    return JSON.stringify({
        "login": $('#login').val(),
        "password": $('#password').val(),
        "firstName": $('#firstName').val(),
        "lastName": $('#lastName').val(),
        "age": $('#age').val()
    });
}
</script>


</body>
</html>