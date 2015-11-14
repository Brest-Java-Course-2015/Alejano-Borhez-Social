// The root URL for the RESTful services
var PREFIX_URL = "http://localhost:8081/rest"
var USER_URL = "/user";

// Register listeners


function goHome() {
    window.location="index.html";
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
            alert('addUser error: ' + textStatus + errorThrown);
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