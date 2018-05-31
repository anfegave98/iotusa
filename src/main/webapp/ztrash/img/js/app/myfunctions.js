$(document).ready(function () {
    $.ajax({
        url:'https://ingsoftwusa.herokuapp.com/myApp/MostrarNota',
        dataType: "json",
        success: function (personas) {
            var personas = [personas];
            console.log(personas);
            var personasHTML = $.map(personas, function (persona, index) {
                var listItem = $('<tr></tr>');
                $('<td>' + persona.estudiante + '</td>').appendTo(listItem);
                $('<td>' + persona.tema + '</td>').appendTo(listItem);
                $('<td>' + persona.nota + '</td>').appendTo(listItem);
                return listItem;
            });
            $('.table tbody').detach().html(personasHTML).appendTo('.table');
        },
        error: function () {
            alert("Error");
        },
        timeout: 3000
        
    });
    });