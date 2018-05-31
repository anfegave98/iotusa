$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "DirectorCursoS",
        //force to handle it as text
        data: {
            'opc': "3"
        },
        dataType: "text",
        success: function (data) {
            $('#SelectDirector').removeAttr('style');
            var selectForm = $('#directores');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione uno</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].cedula + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});



$('#directores').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "DirectorCursoS",
        //force to handle it as text
        data: {
            'opc': "4",
            'cedula': $('#directores').val()
        },
        dataType: "text",
        success: function (data) {
            
            
            $('#texto2').empty();
            $('#texto2').append('<p>Informacion:</p>');
            $('#botonE').removeAttr('style');
            var selectForm= $('#texto2');
            console.log(json);
            var json = $.parseJSON(data);
             
                var opcion = "<p>" + json.cedula + "</p> <p>" + json.nombre + "</p> <p>" + json.fechainicio + "</p> <p>" + json.nombreCurso + "</p>";
                selectForm.append(opcion);
            
           
        },
        async: false
    });
});


$('#botonE').on('click', function () {
    $.ajax({
        type: 'GET',
        url: "DirectorCursoS",
        //force to handle it as text
        data: {
            'opc': "5",
            'cedula': $('#directores').val()
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
            escondido.append('<option selected  value="" disabled>Seleccione curso nuevo</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idCurso + "\">" + json[i].nombre + "</option>";
                escondido.append(opcion);
            }
        }
    });
});

$('#editarCurso').on('click', function () {
    $.ajax({
        type: 'POST',
        url: "DirectorCursoS",
        //force to handle it as text
        data: {
            'opc': "2",
            'idCurso': $('#temasS').val(),
            'cedula': $('#directores').val()
        },
        dataType: "text",
        success: function (data) {
          alert('Se ha actualizado el curso exitosamente');
        }
    });
});



$('#eliminarDirector').on('click', function () {
    $.ajax({
        type: 'POST',
        url: "DirectorCursoS",
        //force to handle it as text
        data: {
            'opc': "3",
            'cedula': $('#directores').val()
        },
        dataType: "text",
        success: function (data) {
          alert('Se ha actualizado el curso exitosamente');
        }
    });
});