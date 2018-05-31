$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "CursoS",
        //force to handle it as text
        data: {
            'op': "0"
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#cursos');
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

    $.ajax({
        type: 'GET',
        url: "EstudianteS",
        //force to handle it as text
        data: {
            'opcion': "7"
        },
        dataType: "text",
        success: function (data) {
            $('#SelectCM').removeAttr('style');
            var selectForm = $('#estudiantes');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un estudiante</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idEstudiante + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }

        },
        async: false
    });


    $('#ubicar').on('click', function () {
        $.ajax({
            type: 'POST',
            url: "CursoEstudianteS",

            data: {
                'opcion': "crear",
                'curso': $('#cursos').val(),
                'fecha': $('#fecha').val(),
                'estudiante': $('#estudiantes').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se ha ubicado al Estudiante exitosamente');
                location.reload();
            },
            async: false
        });
    });

});









