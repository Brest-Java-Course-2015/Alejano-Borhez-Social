// The root URL for the RESTful services
var PREFIX_URL = "http://localhost:8081/rest"
var USER_URL = "/user";
var FRIENDS_URL = "/friendsdto";
var FRIENDSHIP_URL = "/friendship";
var id = getQueryVariable("id");

findAll();

function gotoAddFriend() {
    window.location="addfriend.html?id=" + id;
}

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

function deleteFriend(id, userId)
{
    if (confirm("Вы уверены, что хотите убрать пользователя № " + userId + "из друзей пользователя № " + id + "?"))
    {
    console.log('deleteFriendship' + id + ', ' + userId);
    var url = PREFIX_URL + USER_URL + FRIENDSHIP_URL + "?id1=" + id + "&id2=" + userId;
    $.ajax({
        type: 'DELETE',
        url: url,
        success: function (data, textStatus, jqXHR) {
                    alert('Friendship deleted successfully');
                    findAll();
                },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('deleteFriend error: ' + textStatus + userId);
        }
    })
    }
}

function findAll() {
    console.log('findAll');
    var url = PREFIX_URL + FRIENDS_URL;
    var data = "id=" + id;
    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json", // data type of response
        data: data,
        success: renderList,
        error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR, textStatus, errorThrown);
            alert('findAll: ' + textStatus);
        }
    });
}

function drawRow(user) {
    var row = $("<tr />")
    $("#userList").append(row);
    row.append($("<td>" + user.userId + "</td>"));
    row.append($("<td>" + user.login + "</td>"));
    row.append($("<td>" + '<a href="user.html?id=' + user.userId + '">' + user.firstName + ", " + user.lastName + '</a></td>'));
    row.append($("<td>" + user.age + "</td>"));
    row.append($("<td>" + '<a href="friends.html?id=' + user.userId + '">' + user.totalFriends + '</a></td>'));
    row.append($("<td>" + user.password + "</td>"));
    row.append($("<td>" + user.createdDate + "</td>"));
    row.append($("<td>" + '<button onclick="deleteFriend('+ id + ',' + user.userId +')">Убрать из друзей</button>' + '<button onclick="updateUserPassword('+ user.userId +')">Изменить</button>' + "</td>"));
}

function renderList(data) {
    var dto = data.users == null ? [] : (data.users instanceof Array ? data.users : [data.users]);
    var total = data.totalUsers;
    $('#userList tr').remove();
    $.each(dto, function (index, user) {
        drawRow(user);
    });
    $('#userTotal p').remove();
    $('#userTotal').append($("<p>Всего друзей: " + total + "</p>"));
    $('#bc_username_href span').remove();
    $('#bc_username span').remove();
    $('#bc_username_href').append($('<span><a href="user.html?id=' + id + '">' + data.user.firstName + " " + data.user.lastName + "</a></span>"));
    $('#bc_username').append($("<span>" + data.user.firstName + " " + data.user.lastName + "</span>"));
}