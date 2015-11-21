<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="mapping" value="${pageContext.request.requestURI}"/>
<c:set var="users" value="${contextPath}${'/WEB-INF/views/users.jsp'}"/>
<c:set var="friends" value="${contextPath}${'/WEB-INF/views/friends.jsp'}"/>
<c:set var="usertab" value="${contextPath}${'/WEB-INF/views/user.jsp'}"/>
<c:set var="nofriends" value="${contextPath}${'/WEB-INF/views/nofriends.jsp'}"/>
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
                    <td><a href ="${contextPath}/user?id=${user.userId}">${user.lastName}, ${user.firstName}</a></td>
                    <td>${user.age}</td>
                    <td><a href="${contextPath}/friends?id=${user.userId}">${user.totalFriends}</a></td>
                    <td>${user.password}</td>
                    <td>${user.createdDate}</td>
                    <c:choose>
                         <c:when test="${mapping == users}">
                            <jsp:include page="usersactions.jsp"/>
                         </c:when>
                        <c:when test="${mapping == friends}">
                            <jsp:include page="friendsactions.jsp"/>
                        </c:when>
                        <c:when test="${mapping == usertab}">
                            <jsp:include page="friendsactions.jsp">
                                <jsp:param name="userId" value="${user.userId}"/>
                            </jsp:include>
                        </c:when>
                        <c:when test="${mapping == nofriends}">
                            <jsp:include page="nofriendsactions.jsp">
                                <jsp:param name="userId" value="${user.userId}"/>
                            </jsp:include>
                        </c:when>
                        <c:otherwise>
                            <td>${mapping} ${user}</td>
                        </c:otherwise>
                    </c:choose>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
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


function deleteFriend(userId)
{
    if (confirm("Вы уверены, что хотите убрать пользователя № " + userId + " из друзей пользователя № " + id + "?"))
    {
    console.log('deleteFriendship' + id + ', ' + userId);
    ;
    $.ajax({
        type: 'DELETE',
        url: '<c:url value="/user/friendship/del"/>' +  "?id1=" + id + "&id2=" + userId,
        success: function (data, textStatus, jqXHR) {
                    alert('Friendship deleted successfully');
                    location.reload();
                },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('deleteFriend error: ' + textStatus + userId);
        }
    })
    }
    }

function addFriend(userId)
{
    if (confirm("Вы уверены, что хотите добавить пользователя № " + userId + " в друзья к пользователю № " + id + "?"))
    {
    console.log('addFriendship' + id + ', ' + userId);
    ;
    $.ajax({
        type: 'POST',
        url: '<c:url value="/user/friendship/add"/>' +  "?id1=" + id + "&id2=" + userId,
        success: function (data, textStatus, jqXHR) {
                    alert('Friendship added successfully');
                    location.reload();
                },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('addFriend error: ' + textStatus + userId);
        }
    })
    }
    }

</script>