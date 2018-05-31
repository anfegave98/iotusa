
$(document).ready(function () {

    //curso
    $.ajax({
        type: 'GET',
        url: "CursoMateriaS",
        //force to handle it as text
        data: {
            'opcion': "1",
            'var': "0"
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

        },
        async: false
    });
    //materia
    $.ajax({
        type: 'GET',
        url: "CursoMateriaS",
        //force to handle it as text
        data: {
            'opcion': "1",
            'var': "1"
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#materia');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione una materia</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idMateria + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }

        },
        async: false
    });
    //profesor
    $.ajax({
        type: 'GET',
        url: "CursoMateriaS",
        //force to handle it as text
        data: {
            'opcion': "1",
            'var': "2"
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


    $.ajax({
        type: 'GET',
        url: "CursoMateriaS",
        //force to handle it as text
        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#tablaCM');
            selectForm.empty();
            selectForm.append('<tr><th>Curso</th><th >Materia</th><th >Profesor</th> </tr>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"\" >" + json[i].curso + "</td><td style=\"\" >" + json[i].materia + "</td><td style=\"\" >" + json[i].profesor + "</td> </tr>";
                selectForm.append(opcion);
            }

        },
        async: false
    });
});


$('#SelectCM').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "CursoMateriaS",
        data: {
            'opcion':"crear",
            'curso': $('#curso').val(),
            'materia': $('#materia').val(),
            'profesor': $('#profesor').val(),
            'fechainicio': $('#fecha').val()

        },
        dataType: "text",
        success: function (data) {
            alert('Se ha asignado la Materia exitosamente');
            location.reload();
        },
        async: false
    });
});
