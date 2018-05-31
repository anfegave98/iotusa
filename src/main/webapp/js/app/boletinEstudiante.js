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
            $('#Boletin').removeAttr('style');
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
    $('#VerBoletin').on('click', function () {

        $.ajax({
            type: 'GET',
            url: "NotaS",
            //force to handle it as te
            data: {
                'opcion': "6",
                'curso': $('#curso').val(),
                'idActividad': $('#actividades').val(),
                'estBoletin': $('#estudiante').val()

            },
            dataType: "text",
            success: function (data) {
                $('#tabBoletin').removeAttr('style');

                var selectForm = $('#tabBoletin');
                selectForm.empty();
                selectForm.append('<tr><td style="color:white" >Nombre</td><td style="color:white" >Nota</td> </tr>');
                var json = $.parseJSON(data);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<tr><td style=\"color:black\" >" + json[i].materia + "</td><td style=\"color:black\" >" + json[i].nota + "</td> </tr>";
                    //var opcion = "<tr><td>" + json[i].nombre + " </td><td>" + json[i].nota + "</td> </tr>";
                    selectForm.append(opcion);
                }
            },
            async: false
        });
        $.ajax({
            type: 'GET',
            url: "NotaS",
            //force to handle it as text

            data: {
                "opcion": '7',
                "idEst": $('#estudiante').val()
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#Nota');
                selectForm.empty();
                selectForm.append('<span class="label label-success">Temas</span>');
                var json = $.parseJSON(data);
                var opcion = "<p style=\"color:black\" >" + json + ".</p>";
                selectForm.append(opcion);
                
            },
            async: false
        });
    });

});
