<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="datemax" value="<%=new Date()%>"/>
<html>
<head>
    <title><spring:message code="users.list"/></title>
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

<h1><spring:message code="users.list"/></h1

<form>
    <label>C</label>
    <input id="dateBegin" name="dateBegin" type="date" min="2015-10-24" placeholder="yyyy-MM-dd"/>
    <label>По</label>
    <input id="dateEnd" name="dateEnd" type="date" min="2015-10-24" placeholder="yyyy-MM-dd"/>
    <button type="button" onclick="sortUsers()">Найти</button>

</form>


<jsp:include page="templates/table.jsp"/>

<div id="userTotal">
    <h3><spring:message code="users.total"/>: ${dto.totalUsers}</h3>
    <button id="addUser" style="float: right; position:relative; right: 50px" onclick="gotoAddUser()"><spring:message code="user.create"/></button>
</div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="resources/js/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/main.js"></script>
<script>
    function sortUsers() {
        var dateMin = $('#dateBegin').val();
        var dateMax = $('#dateEnd').val();
        window.location = '<c:url value="/usersbydate"/> ' + '?datemin=' + dateMin + '&datemax=' + dateMax;
    }
</script>
<script>
      var wsUri = "http://localhost:8081/rest/websocket/endpoint";
      var output;
      var realSocket;

      function getSocket()
      {
        var websocket = new SockJS(wsUri);
        realSocket = Stomp.over(websocket);

        return realSocket.connect('guest', 'guest', function() {
          realSocket.subscribe("/topic/addeduser", function(message){
            if (message.body) {
                  alert("New user added" + message.body);
                  var user = JSON.parse(message.body);
                  drawRow(user);
                } else {
                  alert("got empty message");
                }
          });
          realSocket.subscribe("/topic/totalusers", function(message){
            if (message.body) {
                  alert("New user added" + message.body);
                  var totalUsers = JSON.parse(message.body);
                  drawTotal(totalUsers);
                } else {
                  alert("got empty message");
                }
          });
        })};

        window.addEventListener("load", getSocket, false);

        function drawRow(user) {
            var row = $("<tr />")
            $("#userList").append(row);
            row.append($("<td>" + '<a href="user.html?id=' + user.userId + '">' + user.firstName + '</a></td>'));
            row.append($("<td>" + '<a href="user.html?id=' + user.userId + '">' + user.lastName + '</a></td>'));
            row.append($("<td>" + user.age + "</td>"));
            row.append($("<td>" + '<a href="friends.html?id=' + user.userId + '">' + user.totalFriends + '</a></td>'));
            row.append($("<td>" + '<button onclick="deleteUser('+ user.userId +')">Удалить пользователя</button> ' + '<button onclick="gotoUser('+ user.userId +')">Изменить</button>' + "</td>"));
        }

        function drawTotal(totalUsers) {
            $('#userTotal h3').remove();
            $('#userTotal').append($("<h3>Всего пользователей: " + totalUsers + "</h3>"));

        }


</script>
<script src="//cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script src="//cdn.jsdelivr.net/sockjs/1.0.3/sockjs.min.js"></script>

</body>
</html>