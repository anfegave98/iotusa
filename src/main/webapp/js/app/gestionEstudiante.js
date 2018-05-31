$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "EstudianteS",
        //force to handle it as text
        data: {
            'opcion': "6"
        },
        dataType: "text",
        success: function (data) {
            $('#SelectCM').removeAttr('style');
            var selectForm = $('#documento');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un estudiante</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idEstudiante + "\">" + json[i].idEstudiante + "</option>";
                selectForm.append(opcion);
            }

        },
        async: false
    });
    $('#EliminarE').on('submit', function () {
        $.ajax({
            type: 'GET',
            url: "EstudianteS",
            data: {

                'opcion': "3",
                // 'documento': $('#documento').val(),
                'documento': $('#documento').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se ha eliminado el estudiante exitosamente');

            },
            async: false
        });
    });

    $('#EditarE').on('submit', function () {
        $.ajax({
            type: 'GET',
            url: "EstudianteS",
            data: {
                'opcion': "5",
                'documento': $('#documento2').val(),
                'nombre': $('#nombre').val(),
                'fechanacimiento': $('#fechanacimiento').val(),
                'direccion': $('#direccion').val(),
                'celularcontacto': $('#celularcontacto').val(),
                'tiposangre': $('#tiposangre').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se han guardado los cambios exitosamente');

            },
            async: false
        });
    });
});

 $('#boton').on('click',function(){
     $('#parteArriba').attr('style', 'display: none;');
     $('#parteAbajo').removeAttr('style');
 });
 $('#boton2').on('click',function(){
     $('#parteAbajo').attr('style', 'display: none;');
     $('#parteArriba').removeAttr('style');
 });
 
$('#documento').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "EstudianteS",
        //force to handle it as text

        data: {
            'opcion': "2",
            'estudiante': $('#documento').val()
        },
        dataType: "text",
        success: function (data) {
            var json = $.parseJSON(data);
            $('#documento2').attr('value', json.idEstudiante);
            $('#nombre').attr('value', json.nombre);
            $('#fechanacimiento').attr('value', json.fechaNacimiento);
            $('#direccion').attr('value', json.direccion);
            $('#celularcontacto').attr('value', json.celularContacto);
            $('#tiposangre').attr('value', json.tipoSangre);

            var selectForm = $('#verE');
            selectForm.empty();
            var opcion = "<p style=\"\" >Documento: " + json.idEstudiante + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Nombre: " + json.nombre + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Fecha Nacimiento: " + json.fechaNacimiento + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Celular de contacto: " + json.celularContacto + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Direccion: " + json.direccion + ".</p>";
            selectForm.append(opcion);
            opcion = "<p style=\"\" >Tipo Sangre: " + json.tipoSangre + ".</p>";
            selectForm.append(opcion);
            $('#boton').removeAttr('style');
            

        },
        async: false
    });
});