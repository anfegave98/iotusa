
$(document).ready(function () {
     $.ajax({
            type: 'GET',
            url: "VerListaAsistenciaS",
            //force to handle it as text
            data: {
                'opcion': "0"
                

            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#cursosProfesor');
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled>Seleccione una curso</option>');
                var json = $.parseJSON(data);
                console.log(json);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<option value=\"" + json[i].idCurso+ "\">" + json[i].nombre + "</option>";
                    selectForm.append(opcion);
                }
                selectForm.attr('required', false);
            },
            async: false
        });
        
        
    });
    
    $('#cursosProfesor').on('change', function () {
        
        $.ajax({
            type: 'GET',
            url: "VerListaAsistenciaS",
            //force to handle it as text
            data: {
                'opcion': "3",
                'curso': $('#cursosProfesor').val()

            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#nombre');
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled>Seleccione un estudiante</option>');
                var json = $.parseJSON(data);
                console.log(json);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<option value=\"" + json[i].nombre+ "\">" + json[i].nombre + "</option>";
                    selectForm.append(opcion);
                }
                selectForm.attr('required', false);
            },
            async: false
        });
        
    });

$('#Buscar').on('click', function () {
    $.ajax({
        type: 'GET',
        url: "VerListaAsistenciaS",
        //force to handle it as text
        
        data: {
            'opcion': "4",
            'curso':$('#cursosProfesor').val(),
            'nombre':$('#nombre').val()            
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#tablaEstudiante');
            selectForm.empty();
            selectForm.append('<tr><td style="color:white" >Nombre</td><td style="color:white" >Fechas de Ausencia</td> </tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"color:white\" >" + json[i].nombre + "</td><td style=\"color:white\" >" + json[i].fecha + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});


