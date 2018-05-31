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
    $.ajax({
        type: 'GET',
        url: "DirectorCursoS",
        //force to handle it as text
        data: {
            'opc': "0"
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#profesor');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un profesor</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idProfesor + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }

        },
        async: false
    });
});

$('#ubicarPro').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "DirectorCursoS",        
        data: {
            'opc': "1",
            'cedula': $('#profesor').val(),
            'idCurso': $('#curso').val(),
            'fechaInicio': $('#fecha').val()
        },
        dataType: "text",
        success: function (data) {
        alert('Se ha ubicado al Director exitosamente');
        location.reload();
        },
        async: false
    });
});
 