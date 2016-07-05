var output;
var realSocket;

var wsUri="";
var url = "restAPI";

$.ajax({
    type: 'GET',
    url: url,
    success: function (data, textStatus, jqXHR) {
                                 wsUri = data;
                                 getSocket();
                               },
    error: function(jqXHR, textStatus, errorThrown) {
                       console.log(jqXHR, textStatus, errorThrown);
                       alert('restAPI: ' + textStatus);
                   }

});


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
