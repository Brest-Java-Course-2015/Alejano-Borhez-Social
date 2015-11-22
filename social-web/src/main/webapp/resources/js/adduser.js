// The root URL for the RESTful services
var url = '${contextPath}';
var PREFIX_URL = "http://localhost:8082/social-rest-1.0-SNAPSHOT"
var USER_URL = "/user";

// Register listeners
$('#addUser').click(function () {
        addUser();
});


function goHome() {
    window.location="index.html";
}

function addUser() {
    console.log('addUser');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: "addusersubmit",
        dataType: "json",
        data: formToJSON(),
        success: function (data, textStatus, jqXHR) {
            alert('User created successfully');
            if (confirm("Хотите добавить ещё одного пользователя?")) {

            } else {
            goHome();
            }
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