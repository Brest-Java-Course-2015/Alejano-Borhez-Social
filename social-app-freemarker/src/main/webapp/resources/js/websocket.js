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
