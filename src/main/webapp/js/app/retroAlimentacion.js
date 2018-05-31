$(document).ready(function () {

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
            url: "ObservadorS",
            //force to handle it as text

            data: {
                'opcion': "5",
                'estudiante': $('#estudiante').val()
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#Observador');
                selectForm.empty();
                $('#ObservadorShow').removeAttr('style');
                var json = $.parseJSON(data);
                var opcion = "<p style=\"color:black\" >" + json + ".</p>";
                selectForm.append(opcion);

            },
            async: false
        });
        $.ajax({
            type: 'GET',
            url: "ObservadorS",
            //force to handle it as text

            data: {
                "opcion": '4',
                "idEst": $('#estudiante').val()
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#Nota');
                selectForm.empty();
                var json = $.parseJSON(data);
                var opcion = "<p style=\"color:black\" >" + json + ".</p>";
                selectForm.append(opcion);
                
            },
            async: false
        });
        $.ajax({
            type: 'GET',
            url: "AsistenciaS",
            //force to handle it as text

            data: {
                "op": '4',
                "idEst": $('#estudiante').val()
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#Asistencia');
                selectForm.empty();
                var json = $.parseJSON(data);
                var opcion = "<p style=\"color:black\" >" + json + "</p>";
                selectForm.append(opcion);
            },
            async: false
        });
    });
});

 