function deleteUser(userId) {

if (confirm("Вы уверены, что хотите удалить пользователя № " + userId + "?"))
{
    console.log('deleteUser' + userId);
    var url = "user/delete" + "?id=" + userId;
    $.ajax({
        type: 'GET',
        url: url,
        success: function (data, textStatus, jqXHR) {
            alert('User deleted successfully ');
            location.reload();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('deleteUser error: ' + textStatus + userId + ": " + errorThrown);
        }
    })
}

}

function deleteFriend(userId)
{
    if (confirm("Вы уверены, что хотите убрать пользователя № " + userId + " из друзей пользователя № " + id + "?"))
    {
    console.log('deleteFriendship' + id + ', ' + userId);
    var url = "user/friendship/del" +  "?id1=" + id + "&id2=" + userId;
    $.ajax({
        type: 'GET',
        url: url,
        success: function (data, textStatus, jqXHR) {
                    alert('Friendship deleted successfully');
                    location.reload();
                },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('deleteFriend error: ' + textStatus + userId + ': ' + url);
        }
    })
    }
}

function addFriend(userId)
{
    var url = "user/friendship/add" +  "?id1=" + id + "&id2=" + userId;
    console.log('addFriendship' + id + ', ' + userId);
    $.ajax({
        type: 'POST',
        url: url,
        success: function (data, textStatus, jqXHR) {
                    alert('Friendship added successfully');
                    location.reload();
                },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('addFriend error: ' + textStatus + ':' + url);
        }
    })
}

function sortUsers() {
        var dateMin = $('#dateBegin').val();
        var dateMax = $('#dateEnd').val();
        window.location = "usersbydate" + "?datemin=" + dateMin + "&datemax=" + dateMax;
}

function addUser() {
    console.log('addUser');

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: "addusersubmit",
        data: formToJSON(),
        success: function () {
            alert('Пользователь успешно добавлен');
            if (confirm("Хотите добавить ещё одного пользователя?")) {

            } else {
            goHome();
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert('addUser error: ' + textStatus + ': ' + errorThrown);
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

function goHome() {
    window.location=".";
}

function gotoadduser() {
    window.location="adduser";
}

function gotoaddfriend(id) {
    window.location="nofriends?id=" + id;
}

function changeLogin() {
    console.log('changeLogin');
    var newLogin = prompt("Введите новый логин", '');
    if (newLogin != "") {
        var url = "user/login?id=" + id + "&login=" + newLogin;
    $.ajax({
        type: 'GET',
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
    if (newPassword != '') {
        var url = "user/password?id=" + id + "&password=" + newPassword;
    $.ajax({
        type: 'GET',
        url: url,
        success: function (data, textStatus, jqXHR) {
                                     alert('Пароль успешно изменён.');
                                     location.reload();
                                 },
        error: function(jqXHR, textStatus, errorThrown) {
                           console.log(jqXHR, textStatus, errorThrown);
                           alert('updateUser: ' + textStatus + " пароль " + newPassword + ", пользователь " + id + "'" + url + "'");
                       }

    })} else {
            alert('Пароль не может быть пустым');
        }

}

function changeFirstName() {
    console.log('changeFirstName');
    var newName = prompt("Введите новое имя", '');
    var url = "user/firstname?id=" + id + "&firstname=" + newName;
    if (newName != "") {
    $.ajax({
        type: 'GET',
        url: url,
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
    var url = "user/lastname?id=" + id + "&lastname=" + newName;
    if (newName != "") {
    $.ajax({
        type: 'GET',
        url: url,
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