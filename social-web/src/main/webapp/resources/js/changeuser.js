// The root URL for the RESTful services
var PREFIX_URL = "http://localhost:8081/web";
var USER_URL = "/user";
var USERDTO_URL = "/userdto";
var USERS_URL = "/users";
var FRIENDS_URL = "/friendsdto";
var FRIENDSHIP_URL = "/friendship";
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

function deleteFriend(id, userId) {

    if (confirm("Вы уверены, что хотите убрать пользователя № " + userId + " из друзей пользователя № " + id + "?"))
    {
    console.log('deleteFriendship' + id + ', ' + userId);
    var url = PREFIX_URL + USER_URL + FRIENDSHIP_URL + "?id1=" + id + "&id2=" + userId;
    $.ajax({
        type: 'DELETE',
        url: url,
        success: function (data, textStatus, jqXHR) {
                    alert('Friendship deleted successfully');
                },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('deleteFriend error: ' + textStatus + userId);
        }
    })
    }
}

function changePassword() {
    console.log('changePassword');
    var newPassword = prompt("Введите новый пароль", '');
    var url = PREFIX_URL + USER_URL + "/password?id=" + id + "&password=" + newPassword;
    if (newPassword != "") {
    $.ajax({
        type: 'GET',
        url: '<c:url value="/user/password?id="/>' + id + "&password=" + newPassword,
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
                           alert('changeLogin: ' + textStatus + "логин " + newLogin + "пользователь " + id + url);
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