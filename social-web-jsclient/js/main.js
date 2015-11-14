// The root URL for the RESTful services
var PREFIX_URL = "http://localhost:8081/rest"
var USER_URL = "/user";
var USERDTO_URL = "/userdto"
var USERS_URL = "/users";
var FRIENDS_URL = "/friends";
var FRIENDSHIP_URL = "/friendship";

findAll();

// Register listeners
$('#btnSave').click(function () {
        addUser();
});


function deleteUser(userId) {

    if (confirm("Вы уверены, что хотите удалить пользователя № " + userId + "?"))
    {
    console.log('deleteUser' + userId);
    var url = PREFIX_URL + USER_URL + "?id=" + userId;
    $.ajax({
        type: 'DELETE',
        url: url,
        success: function (data, textStatus, jqXHR) {
                    alert('User deleted successfully');
                    findAll();
                    findAll();
                },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('deleteUser error: ' + textStatus + userId);
        }
    })
    }
}

function updateUserPassword(userId) {
    console.log('updateUser' + userId);
    var newPassword = prompt("Введите новый пароль", '');
    var url = PREFIX_URL + USER_URL + "?id=" + userId + "&password=" + newPassword;
    $.ajax({
        type: 'PUT',
        url: url,
        success: function() {
        alert('Пароль успешно изменён.');
        findAll();
        },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('updateUser: ' + textStatus);
                       }

    })

}

function findAll() {
    console.log('findAll');
    var url = PREFIX_URL + USERDTO_URL;
    $.ajax({
        type: 'GET',
        url: url,
        dataType: "json", // data type of response
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
    row.append($("<td>" + '<button onclick="deleteUser('+ user.userId +')">Удалить</button>' + '<button onclick="updateUserPassword('+ user.userId +')">Изменить</button>' + "</td>"));
}

function renderList(data) {
    var dto = data.users == null ? [] : (data.users instanceof Array ? data.users : [data.users]);
    var total = data.totalUsers;
    $('#userList tr').remove();
    $.each(dto, function (index, user) {
        drawRow(user);
    });
    $('#userTotal p').remove();
    $('#userTotal').append($("<p>Всего пользователей: " + total + "</p>"));

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
            findAll();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('addUser error: ' + textStatus);
        }
    });
}

/*function updateUser() {
    console.log('updateUser');
    var url = PREFIX_URL + USER_URL + "";
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: url,
        data: formToJSON(),
        success: function (data, textStatus, jqXHR) {
            alert('User updated successfully');
            findAll();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('updateUser error: ' + textStatus);
        }
    });
}*/

function formToJSON() {
    return JSON.stringify({
        "login": $('#login').val(),
        "password": $('#password').val(),
        "firstName": $('#firstName').val(),
        "lastName": $('#lastName').val(),
        "age": $('#age').val()
    });
}