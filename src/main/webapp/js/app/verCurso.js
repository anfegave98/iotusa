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
            $('#boton').removeAttr('style');
            $('#boton2').removeAttr('style');
            $('#tabla').removeAttr('style');
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
    $('#boton').on('click', function () {
        $.ajax({
            type: 'GET',
            url: "CursoS",
            data: {

                'op': "2",
                // 'documento': $('#documento').val(),
                'curso': $('#cursos').val()
            },
            dataType: "text",
            success: function (data) {
                alert('Se ha eliminado el estudiante exitosamente');


            },
            async: false
        });
    });
    $('#boton2').on('click', function () {
        $.ajax({
            type: 'GET',
            url: "CursoS",
            data: {

                'op': "3",
                // 'documento': $('#documento').val(),
                'curso': $('#cursos').val()
            },
            dataType: "text",
            success: function (data) {
                $('#parteArriba').attr('style', 'display: none;');
                $('#parteAbajo').removeAttr('style');
                var json = $.parseJSON(data);
                $('#idcurso').attr('value', json.idCurso);
                $('#cursos2').attr('value', json.nombre);


            },
            async: false
        });
    });
    $('#boton3').on('click',function(){
     $('#parteAbajo').attr('style', 'display: none;');
     $('#parteArriba').removeAttr('style');
 });
 
    $('#EditarC').on('submit', function () {
        $.ajax({
            type: 'GET',
            url: "CursoS",
            data: {
                'op': "4",
                'idCurso': $('#idcurso').val(),
                'nombre': $('#cursos2').val(),
            },
            dataType: "text",
            success: function (data) {
                alert('Se han guardado los cambios exitosamente');

            },
            async: false
        });
    });


});









