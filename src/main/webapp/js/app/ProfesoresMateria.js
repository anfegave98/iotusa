$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "CursoMateriaS",
        //force to handle it as text
        data: {
            'opcion': "2"
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
                var opcion = "<option value=\"" + json[i].idcm + "\">" + json[i].nombre1 + "</option>";
                selectForm.append(opcion);
                var opcion2 = "<option value=\"" + json[i].idcm + "\">" + json[i].nombre1 +", "+ json[i].nombre2+"</option>";
                selectForm2.append(opcion2);
            }
            selectForm.attr('required', false);
        },
        async: false
    });
});
$('#cursos').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "CursoMateriaS",
        //force to handle it as text

        data: {
            'opcion': "3",
            'idcm': $('#cursos').val()
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#profe');
            selectForm.empty();
            var json = $.parseJSON(data);
            selectForm.append(" <span class=\"label label-success\">Profesor actual: "+json+"</span>");
        },
        async: false
    });
});
$('#EditarPM').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "CursoMateriaS",
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
$('#EliminarPM').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "CursoMateriaS",
        data: {
            'opcion': "eliminar",
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










