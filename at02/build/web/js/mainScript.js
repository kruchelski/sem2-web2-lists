var apiURL = 'users';

function addLine(user) {
    var line = '<tr>';
    for (var key in user) {
        line = line + '<td class="col-sm-4">' + user[key] + '</td>';
    }
    line = line + '</tr>';
    $('tbody').append(line);
}

function requestUsers() {
    $.getJSON(apiURL,function(data){
        console.log(data);
        for (var user of data) {
            addLine(user);
        }
    });
}

function sendData(e) {
    e.preventDefault();
    var dataSend = {
        name: $('input[name=nameLogin').val(),
        login: $('input[name=userLogin').val(),
        password: $('input[name=userPass').val()
    };
  
    $.post(apiURL, dataSend, function(response) { 
        addLine(response);
        $('input[name=nameLogin').val('');
        $('input[name=userLogin').val('');
        $('input[name=userPass').val('');
        $('input[name=nameLogin').focus();
    });
}

$(document).ready(function(){
    $("#fundoMain").hide().fadeIn(1000);
    $("#titulo").hide().fadeIn(1500);
    $("#formularioMain").hide().fadeIn(1800);
    requestUsers();
    $('form').submit(sendData);
});
