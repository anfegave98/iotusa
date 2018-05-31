
$(document).ready(function () {
    
        $.ajax({
            type: 'GET',
            url: "MateriaS",
            //force to handle it as text

            data: {
                'opcion': "0"

            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#tabla');
                selectForm.empty();
                selectForm.append('<tr><th >Materias</th> </tr>');
                var json = $.parseJSON(data);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<tr><td style=\"\" >" + json[i].nombre + "</td><td><button type=\"button\" onclick=\"editarMateria(" + json[i].idMateria + ")\" value=" + json[i].idMateria + "\"  class=\"btn btn-link btn-success\"><i class=\"nc-icon nc-settings-gear-65\"></i></button></td><td><button onclick=\"eliminarMateria(" + json[i].idMateria + ")\" class=\"btn btn-link btn-warning\"><i class=\"nc-icon nc-simple-remove\"></i></button></td></tr>";
                    selectForm.append(opcion);



                }
            },
            async: false
        });
    
});
function editarMateria(id) {
    $.ajax({
        type: 'GET',
        url: "MateriaS",
        data: {
            'opcion': "1",
            'id': id
        },
        dataType: "text",
        success: function (data) {
            var json = $.parseJSON(data);
            $('#parteArriba').attr('style', 'display: none;');
            $('#parteAbajo').removeAttr('style');
            $('#idmateria2').attr('value', json.idMateria);
            $('#materia2').attr('value', json.nombre);

        },
        async: false
    });
}
function eliminarMateria(id) {
    $.ajax({
        type: 'GET',
        url: "MateriaS",
        data: {
            'opcion': "3",
            'id': id
        },
        dataType: "text",
        success: function (data) {   
             alert('Se ha eliminado el exitosamente');
        },
        async: false
    });
}
$('#boton3').on('click', function () {
    $('#parteAbajo').attr('style', 'display: none;');
    $('#parteArriba').removeAttr('style');
});
 $('#EditarA').on('submit', function () {
        $.ajax({
            type: 'GET',
            url: "MateriaS",
            data: {
                'opcion': "2",
                'id': $('#idmateria2').val(),
                'materia': $('#materia2').val(),
            },
            dataType: "text",
            success: function (data) {
                alert('Se han guardado los cambios exitosamente');

            },
            async: false
        });
    });










