var apiURL = 'users';
function addLine(user) {
    var line = '<tr>';
    for (var key in user) {
        line = line + '<td class="col-sm-3">' + user[key] + '</td>';
    }
    line = line + '</tr>';
    $('tbody').append(line);
}

function requestUsers() {
    $.getJSON(apiURL, function (data) {
        for (var user of data) {
            addLine(user);
        }
    });
}

function sendData(e) {
    e.preventDefault();
    $('#successStatus').hide();
    $('#errorStatus').hide();
    var dataSend = {
        name: $('input[name=nameLogin').val(),
        login: $('input[name=userLogin').val(),
        password: $('input[name=userPass').val()
    };

    $.post(apiURL, dataSend).then(function(response) {
        addLine(response.user);
        $('input[name=nameLogin').val('');
        $('input[name=userLogin').val('');
        $('input[name=userPass').val('');
        $('input[name=nameLogin').focus();
        $('#successStatus').fadeTo(2000, 500).slideUp(500, function () {
            $('#successStatus').slideUp(500);
        });
    }).catch(function (response) {
        var erros = response.responseJSON.messages;
        var alert = $('#errorStatus');
        alert.html("");
        for (var er of erros) {
            alert.html(alert.html() + er + "<br/>");
        }
        alert.fadeTo(2000, 500).slideUp(500, function() {
            alert.slideUp(500);
        });
    });
}

$(document).ready(function () {
    $("#fundoMain").hide().fadeIn(1000);
    $("#titulo").hide().fadeIn(1500);
    $("#formularioMain").hide().fadeIn(1800);
    requestUsers();
    $('form').submit(sendData);
});
