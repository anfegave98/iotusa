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
            var selectForm2 = $('#cursos2');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un curso</option>');
            selectForm2.empty();
            selectForm2.append('<option selected  value="" disabled>Seleccione un curso</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idCurso + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
                selectForm2.append(opcion);
            }
            selectForm.attr('required', false);
        },
        async: false
    });
});
$('#cursos').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "CursoS",
        //force to handle it as text

        data: {
            'op': "1",
            'curso': $('#cursos').val()
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#tabla');
            selectForm.empty();
            selectForm.append('<tr><th>Documento Estudiante</th><th>Nombre Estudiante</th> </tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"\" >" + json[i].idEstudiante + "</td><td style=\"\" >" + json[i].nombre + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});
$('#cursos2').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "CursoS",
        //force to handle it as text

        data: {
            'op': "1",
            'curso': $('#cursos2').val()
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#tabla');
            selectForm.empty();
            selectForm.append('<tr><th>Documento Estudiante</th><th>Nombre Estudiante</th> </tr>');
            var selectForm2 = $('#estudiante');
            selectForm2.empty();
            selectForm2.append('<option selected  value="" disabled>Seleccione un curso</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"\" >" + json[i].idEstudiante + "</td><td style=\"\" >" + json[i].nombre + "</td> </tr>";
                var opcion2 = "<option value=\"" + json[i].idEstudiante + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
                selectForm2.append(opcion2);
            }
        },
        async: false
    });
});
$('#EditarE').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "CursoEstudianteS",
        data: {

            'opcion': "editar",
            'documento': $('#documento').val(),
            'curso': $('#cursos').val()
        },
        dataType: "text",
        success: function (data) {
            alert('Se ha cambiado el estudiante de curso exitosamente');
            location.reload();
        },
        async: false
    });
});
$('#EliminarE').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "CursoEstudianteS",
        data: {

            'opcion': "eliminar",
            'documento': $('#estudiante').val(),
            'curso': $('#cursos2').val()
        },
        dataType: "text",
        success: function (data) {
            alert('Se ha eliminado el estudiante del curso exitosamente');
            location.reload();
        },
        async: false
    });
});










