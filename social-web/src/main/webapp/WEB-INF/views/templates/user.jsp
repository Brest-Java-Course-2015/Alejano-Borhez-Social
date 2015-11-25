<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<h3><spring:message code="user.user"/></h3>

<div id="user" class="table-responsive" style="width: 33%">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Характеристика</th>
            <th>Значение</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Логин</td>
            <td id="login"><span>${dto.user.login}</span></td>
            <td>
                    <button id="change_login" onclick="changeLogin()"><spring:message code="user.change"/></button>
            </td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td id="password"><span>${dto.user.password}</span></td>
            <td>
                    <button id="change_password" onclick="changePassword()"><spring:message code="user.change"/></button>
            </td>
        </tr>
        <tr>
            <td>Имя</td>
            <td id="firstname"><span>${dto.user.firstName}</span></td>
            <td>
                    <button id="change_firstname" onclick="changeFirstName()"><spring:message code="user.change"/></button>
            </td>
        </tr>
        <tr>
            <td>Фамилия</td>
            <td id="lastname"><span>${dto.user.lastName}</span></td>
            <td>
                    <button id="change_lastname" onclick="changeLastName()"><spring:message code="user.change"/></button>
            </td>
        </tr>
        <tr>
            <td>Возраст</td>
            <td id="age"><span>${dto.user.age}</span></td>
            <td><span></span></td>
        </tr>
        </tbody>
    </table>
</div>

<script>
function changeLogin() {
    console.log('changeLogin');
    var newLogin = prompt("Введите новый логин", '');
    if (newLogin != "") {
        var url = "${contextPath}/user/login?id=" + id + "&login=" + newLogin;
    $.ajax({
        type: 'PUT',
        url: url,
        success: function (data, textStatus, jqXHR) {
                                     alert('Логин успешно изменён.');
                                     location.reload();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('updateUser: ' + textStatus + " логин " + newLogin + ", пользователь " + id + "'" + url + "'");
                       }

    })
    } else {
        alert('Логин не может быть пустым');
    }

}

function changePassword() {
    console.log('changePassword');
    var newPassword = prompt("Введите новый пароль", '');
    if (newPassword != "") {
        var url = '<c:url value="/user/password?id="/>' + id + "&password=" + newPassword;
    $.ajax({
        type: 'PUT',
        url: url,
        success: function (data, textStatus, jqXHR) {
                                     alert('Пароль успешно изменён.');
                                     location.reload();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('updateUser: ' + textStatus + " пароль " + newPassword + ", пользователь " + id + "'" + url + "'");
                       }

    })
    } else {
        alert('Пароль не может быть пустым');
    }

}

function changeFirstName() {
    console.log('changeFirstName');
    var newName = prompt("Введите новое имя", '');
    if (newName != "") {
    $.ajax({
        type: 'GET',
        url: '<c:url value="/user/firstname?id="/>' + id + "&firstname=" + newName,
        success: function (data, textStatus, jqXHR) {
                                     alert('Имя успешно изменено.');
                                     location.reload();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('updateUser: ' + textStatus + " имя " + newName + ", пользователь " + id + "'" + url + "'");
                       }

    })
    } else {
        alert('Имя не может быть пустым');
    }

}

function changeLastName() {
    console.log('changeLastName');
    var newName = prompt("Введите новую фамилию", '');
    if (newName != "") {
    $.ajax({
        type: 'GET',
        url: '<c:url value="/user/lastname?id="/>' + id + "&lastname=" + newName,
        success: function (data, textStatus, jqXHR) {
                                     alert('Имя успешно изменено.');
                                     location.reload();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('updateUser: ' + textStatus + " фамилия " + newName + ", пользователь " + id + "'" + url + "'");
                       }

    })
    } else {
        alert('Фамилия не может быть пустой');
    }

}

var id = getQueryVariable("id");

function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}



</script>