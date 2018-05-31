$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "TemaS",
        //force to handle it as text
        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
            $('#SelectCM1').removeAttr('style');
            var selectForm = $('#cm');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione uno</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idcm + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});



$('#cm').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "TemaS",
        //force to handle it as text
        data: {
            'opcion': "2",
            'idcm': $('#cm').val()
        },
        dataType: "text",
        success: function (data) {

            var selectForm = $('#temas');
            var boton = $('#botonsito');
            boton.removeAttr('style');
            $('#nombreaparece').removeAttr('style');
            $('#texto2').empty();
            $('#texto2').append('<p>Temas:</p>');
            $('#botonE').removeAttr('style');
            selectForm.empty();
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var j = i + 1;
                var opcion = "<tr><td>" + j + ". " + json[i].nombre + "</td><td>" + "<button type=\"button\" data-toggle=\"tooltip\" data-placement=\"right\" title=\"Eliminar\" class=\"btn btn-link btn-warning\" onclick=\"eliminarTema(" + json[i].idTema + ")\"><i class=\"nc-icon nc-simple-remove\"></i></button>" + "</td> </tr>";
                selectForm.append(opcion);
            }
            var selectForm2 = $('#texto');
            selectForm2.empty();
            selectForm2.append("<br><p style=\"\" >Quiere agregar otro?</p>");
        },
        async: false
    });
});

function eliminarTema(idTema) {
    $.ajax({
        type: 'POST',
        url: "TemaS",
        data: {
            'opcion': "eliminar",
            'idTema': idTema
        },
        dataType: "text",
        success: function (data) {
            window.location.reload();
        },
        async: false
    });
}

$('#botonE').on('click', function () {
    $.ajax({
        type: 'GET',
        url: "TemaS",
        //force to handle it as text
        data: {
            'opcion': "2",
            'idcm': $('#cm').val()
        },
        dataType: "text",
        success: function (data) {
            var es=$('#megaescondido');
            es.removeAttr('style');
            $('#texto2').attr('style','display: none;');
            $('#temas').attr('style','display: none;');
            $('#botonE').attr('style','display: none;');
            $('#SelectCM').attr('style','display: none;');
            $('#texto').attr('style','display: none;');
            $('#editar').removeAttr('style');
            var escondido=$('#temasS');
            escondido.empty();
            escondido.append('<option selected  value="" disabled>Seleccione uno</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idTema + "\">" + json[i].nombre + "</option>";
                escondido.append(opcion);
            }
        }
    });
});

$('#editar').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "TemaS",
        data: {
            'opcion': "editar",
            'nombre': $('#nombre2').val(),
            'idTema': $('#temasS').val(),
            'idcm': $('#cm').val()
        },
        dataType: "text",
        success: function (data) {
            
        },
        async: false
    });
});



$('#SelectCM').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "TemaS",
        data: {
            'opcion': "crear",
            'idcm': $('#cm').val(),
            'nombre': $('#nombre').val()
        },
        dataType: "text",
        success: function (data) {

        },
        async: false
    });
});