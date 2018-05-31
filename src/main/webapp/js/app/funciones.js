//$('#verPerfil').click(function () {
//    $.ajax({
//        type: 'GET',
//        url: "ProfesorS",
//        //force to handle it as text
//        data: {
//            
//
//        },
//        dataType: "text",
//        success: function (data) {
//            var json = $.parseJSON(data);
//            $('#nombre').attr('value', json.nombre);
//            $('#usuario').attr('value', json.usuario);
//            $('#fechanacimiento').attr('value', json.fechaNacimiento);
//            $('#tiposangre').attr('value', json.tipoSangre);
//            $('#rh').attr('value', json.rh);
//            $('#correo').attr('value', json.correo);
//            $('#celular').attr('value', json.celular);
//            $('#direccion').attr('value', json.direccion);
//            $('#estudios').attr('value', json.estudios);
//            $('#experiencia').attr('value', json.experiencia);
//
//        },
//        async: false
//    });
//});
$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "CursoS",
        data: {
            'op' : "0"
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#curso');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un curso</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idCurso + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
    $('#CrearE').on('submit', function () {
        $.ajax({
            type: 'POST',
            url: "EstudianteS",
            data: {
                'documento': $('#documento').val(),
                'nombre': $('#nombre').val(),
                'fechanacimiento': $('#fechanacimiento').val(),
                'direccion': $('#direccion').val(),
                'celularcontacto': $('#celularcontacto').val(),
                'tiposangre': $('#tiposangre').val(),
                'curso': $('#curso').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se ha creado el Estudiante exitosamente');
                location.reload();

            },
            async: false
        });
    });

});

$('#botonVerE').click(function () {
    $.ajax({
        type: 'GET',
        url: "EstudianteS",
        //force to handle it as text
        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
            $('#idE').removeAttr('style');
            $('#datos').removeAttr('style');

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
        },
        async: false
    });
    $('#curso').on('change', function () {
        $.ajax({
            type: 'GET',
            url: "EstudianteS",
            //force to handle it as text
            data: {
                'opcion': "1",
                'curso': $('#curso').val()
            },
            dataType: "text",
            success: function (data) {

                var selectForm = $('#estudiante');
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled>Seleccione un estudiante</option>');
                var json = $.parseJSON(data);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<option value=\"" + json[i].idEstudiante + "\">" + json[i].nombre + "</option>";
                    selectForm.append(opcion);
                }
                selectForm.attr('required', false);
            },
            async: false
        });
    });

    $('#estudiante').on('change', function () {
        $.ajax({
            type: 'GET',
            url: "EstudianteS",
            //force to handle it as text

            data: {
                'opcion': "2",
                'estudiante': $('#estudiante').val()
            },
            dataType: "text",
            success: function (data) {
                var json = $.parseJSON(data);
                $('#documento').attr('value', json.idEstudiante);
                $('#nombre').attr('value', json.nombre);
                $('#idcurso').attr('value', json.idCurso);
                $('#fechanacimiento').attr('value', json.fechaNacimiento);
                $('#direccion').attr('value', json.direccion);
                $('#celularcontacto').attr('value', json.celularContacto);
                $('#tiposangre').attr('value', json.tipoSangre);
                $('#rh').attr('value', json.rh);


            },
            async: false
        });
    });

});

