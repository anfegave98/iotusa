$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "ActividadS",
        //force to handle it as text
        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
            $('#SelectCM').removeAttr('style');
            $('#SelectCM2').removeAttr('style');
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
        url: "ActividadS",
        //force to handle it as text
        data: {
            'opcion': "1",
            'idcm': $('#cm').val()
        },
        dataType: "text",
        success: function (data) {
            $('#actividades').attr('style', 'display: none;');
            $('#botonsito').attr('style', 'display: none;');
            var selectForm = $('#tema');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un tema</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idTema + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});


$('#tema').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "ActividadS",
        //force to handle it as text
        data: {
            'opcion': "2",
            'tema': $('#tema').val()
        },
        dataType: "text",
        success: function (data) {
            $('#nombreaparece').removeAttr('style');
            var selectForm = $('#actividades');
            var boton= $('#botonsito');
            boton.removeAttr('style');
            $('#actividades').removeAttr('style');
            selectForm.empty();
            selectForm.append('<p style=\"\" >Actividades: </p>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var j=i+1;
                var opcion = "<p style=\"\" >"+j+". "+json[i].nombre+"<button type=\"button\" onclick=\"editarActividad(" + json[i].id + ")\" value=" + json[i].id + "\"  class=\"btn btn-link btn-success btn-lg\"><i class=\"nc-icon nc-settings-gear-65\"></i></button></td><td><button type=\"submit\" onclick=\"eliminarActividad(" + json[i].id + ")\" class=\"btn btn-link btn-warning btn-lg\"><i class=\"nc-icon nc-simple-remove\"></i></button></p>";
                selectForm.append(opcion);
            }
            selectForm.append("<br><p style=\"\" >Quiere agregar otro?</p>");
        },
        async: false
    });
});

$('#SelectCM2').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "ActividadS",        
        data: {
            'tema': $('#tema').val(),
            'nombre': $('#nombre').val()
        },
        dataType: "text",
        success: function (data) {
        alert('Actividad agregada exitosamente');
        location.reload();
        },
        async: false
    });
    
});
function eliminarActividad(id) {
    $.ajax({
        type: 'GET',
        url: "ActividadS",
        data: {
            'opcion': "5",
            'id': id
        },
        dataType: "text",
        success: function (data) {   
             alert('Se ha eliminado el exitosamente');
             location.reload();
        },
        async: false
    });
}

function editarActividad(id) {
    $.ajax({
        type: 'GET',
        url: "ActividadS",
        data: {
            'opcion': "4",
            'id': id
        },
        dataType: "text",
        success: function (data) {
            var json = $.parseJSON(data);
            $('#parteArriba').attr('style', 'display: none;');
            $('#parteAbajo').removeAttr('style');
            $('#idactividad2').attr('value', json.id);
            $('#actividad2').attr('value', json.nombre);
            $('#tema2').attr('value', json.idTema);

        },
        async: false
    });
}

$('#boton3').on('click', function () {
    $('#parteAbajo').attr('style', 'display: none;');
    $('#parteArriba').removeAttr('style');
});
 $('#EditarA').on('submit', function () {
        $.ajax({
            type: 'GET',
            url: "ActividadS",
            data: {
                'opcion': "3",
                'id': $('#idactividad2').val(),
                'nombre': $('#actividad2').val(),
                'tema2': $('#tema2').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se han guardado los cambios exitosamente');

            },
            async: false
        });
    });

