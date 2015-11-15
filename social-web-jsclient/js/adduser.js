// The root URL for the RESTful services
var PREFIX_URL = "http://localhost:8082/social-rest-1.0-SNAPSHOT"
var USER_URL = "/user";

// Register listeners
$('#addUser').click(function () {
        addUser();
        goHome();
});

render();

function render() {
    $('#addUser span').remove();
    $('#addUser').append($("<span>Добавить</span>"));
}

function goHome() {
    window.location="index.html";
}

function addUser() {
    console.log('addUser');
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: PREFIX_URL + USER_URL,
        dataType: "json",
        data: formToJSON(),
        success: function (data, textStatus, jqXHR) {
            alert('User created successfully');
            goHome();
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