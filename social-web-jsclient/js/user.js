// The root URL for the RESTful services
var PREFIX_URL = "http://localhost:8082/social-rest-1.0-SNAPSHOT"
var USER_URL = "/user";
var USERDTO_URL = "/userdto";
var USERS_URL = "/users";
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
    row.append($("<td>" + user.updatedDate + "</td>"));
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
    $('#userH2 span').remove();
    $('#userH2').append($("<span>" + data.user.firstName + " " + data.user.lastName + ":</span>"));
    $('#login span').remove();
    $('#login').append($("<span>" + data.user.login + "</span>"));
    $('#password span').remove();
    $('#password').append($("<span>" + data.user.password + "</span>"));
    $('#firstname span').remove();
    $('#firstname').append($("<span>" + data.user.firstName + "</span>"));
    $('#lastname span').remove();
    $('#lastname').append($("<span>" + data.user.lastName + "</span>"));
    $('#age span').remove();
    $('#age').append($("<span>" + data.user.age + "</span>"));
}

function changePassword() {
    console.log('changePassword');
    var newPassword = prompt("Введите новый пароль", '');
    var url = PREFIX_URL + USER_URL + "/password?id=" + id + "&password=" + newPassword;
    if (newPassword != "") {
    $.ajax({
        type: 'PUT',
        url: url,
        success: function (data, textStatus, jqXHR) {
                                     alert('Пароль успешно изменён.');
                                     findAll();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('updateUser: ' + textStatus + "пароль " + newPassword + "пользователь " + id);
                       }

    })
    } else {
        alert('Пароль не может быть пустым');
    }

}

function changeLogin() {
    console.log('changeLogin');
    var newLogin = prompt("Введите новый логин", '');
    var url = PREFIX_URL + USER_URL + "/login?id=" + id + "&login=" + newLogin;
    if (newLogin != "") {
    $.ajax({
        type: 'PUT',
        url: url,
        success: function (data, textStatus, jqXHR) {
                                     alert('Логин успешно изменён.');
                                     findAll();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('changeLogin: ' + textStatus + "логин " + newLogin + "пользователь " + id);
                       }

    })
    } else {
        alert('Логин не может быть пустым');
    }

}

function changeFirstName() {
    console.log('changeFirstName');
    var newFirstName = prompt("Введите новое имя", '');
    var url = PREFIX_URL + USER_URL + "/firstname?id=" + id + "&firstname=" + newFirstName;
    if (newFirstName != "") {
    $.ajax({
        type: 'PUT',
        url: url,
        success: function (data, textStatus, jqXHR) {
                                     alert('Имя успешно изменено.');
                                     findAll();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('changeFirstName: ' + textStatus + "имя " + newFirstName + "пользователь " + id);
                       }

    })
    } else {
        alert('Имя не может быть пустым');
    }

}

function changeLastName() {
    console.log('changeLastName');
    var newLastName = prompt("Введите новую фамилию", '');
    var url = PREFIX_URL + USER_URL + "/lastname?id=" + id + "&lastname=" + newLastName;
    if (newLastName != "") {
    $.ajax({
        type: 'PUT',
        url: url,
        success: function (data, textStatus, jqXHR) {
                                     alert('Фамилия успешно изменена.');
                                     findAll();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('changeLastName: ' + textStatus + "фамилия " + newLastName + "пользователь " + id);
                       }

    })
    } else {
        alert('Фамилия не может быть пустой');
    }

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