// The root URL for the RESTful services
var PREFIX_URL = "http://localhost:8081/rest"
var USER_URL = "/user";
var USERDTO_URL = "/userdto";
var USERS_URL = "/users";
var FRIENDS_URL = "/friends";
var FRIENDSHIP_URL = "/friendship";
var id = getQueryVariable("id");

findAll();

// Register listeners
$('#btnSave').click(function () {
        addUser();
});

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



function deleteFriend(id, userId) {

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
    var url = PREFIX_URL + USER_URL + FRIENDS_URL;
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
    row.append($("<td>" + '<a href="#" data-identity="' + user.userId + '">' + user.firstName + ", " + user.lastName + '</a></td>'));
    row.append($("<td>" + '<a href="#" data-identity="' + user.userId + '">' + user.age + '</a></td>'));
    row.append($("<td>" + '<a href="friends.html?id=' + user.userId + '">' + user.totalFriends + '</a></td>'));
    row.append($("<td>" + user.password + "</td>"));
    row.append($("<td>" + user.createdDate + "</td>"));
    row.append($("<td>" + '<button onclick="deleteFriend('+ id + ',' + user.userId +')">Убрать из друзей</button>' + '<button onclick="updateUserPassword('+ user.userId +')">Изменить</button>' + "</td>"));
}

function renderList(data) {
    var dto = data == null ? [] : (data instanceof Array ? data : [data]);
    $('#userList tr').remove();
    $.each(dto, function (index, user) {
        drawRow(user);
    });
    $('#userTotal p').remove();

}

function addUser() {
    console.log('addUser');
    var url = PREFIX_URL + USER_URL;
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: url,
        dataType: "json",
        data: formToJSON(),
        success: function (data, textStatus, jqXHR) {
            alert('User created successfully');
            $('#userId').val(data.userId);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('addUser error: ' + textStatus);
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