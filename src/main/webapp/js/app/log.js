$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "DirectorCursoS",
        //force to handle it as text
        data: {
            'opc': "1"
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#curso');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un curso</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idCurso + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
            selectForm.attr('required', false);
        },
        async: false
    });
    $('#crearProfesor').on('submit', function () {
        $.ajax({
            type: 'POST',
            url: "ProfesorS",
            data: {
                'cedula': $('#cedula').val(),
                'nombre': $('#nombre').val(),
                'tipoU': $('#tipoU').val(),
                'correo': $('#correo').val(),
                'celular': $('#celular').val(),
                'direccion': $('#direccion').val(),
                'estudios': $('#estudios').val(),
                'experiencia': $('#experiencia').val(),
                'fechanacimiento': $('#fechanacimiento').val(),
                'tiposangre': $('#tiposangre').val(),
                'rh': $('#rh').val(),
                'usuario': $('#usuario').val(),
                'contra': $('#contra').val(),
                'curso': $('#curso').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se ha creado al Profesor exitosamente');
                location.reload();
            },
            async: false
        });
    });
});
 