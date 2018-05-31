$(document).ready(function () {
        
        $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as text
        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#cursosMateria');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione una materia</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idcm + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
        });

        
        });
        
        
    
    
    /*$.ajax({
        type: 'GET',
        url: "VerListaAsistenciaS",
        //force to handle it as text
        
        data: {
            'opcion': "2",
            'curso':$('#cursosProfesor').val(),
            'fecha':$('#fecha').val()            
        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#tabla');
            selectForm.empty();
            selectForm.append('<tr><td style="color:white" >Nombre</td><td style="color:white" >Nota</td> </tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td style=\"color:white\" >" + json[i].nombre + "</td><td style=\"color:white\" >" + json[i].vino + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });*/
        


$('#BuscarNotasMateria').on('click', function () {

 $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as te
        data: {
            'opcion': "3",
            'curso': $('#cm').val()
        },
        dataType: "text",
        success: function (data) {
            $('#tabla').removeAttr('style');
            
            var selectForm = $('#tabla');
            selectForm.empty();
            selectForm.append('<tr><td style="color:white" >Nombre</td><td style="color:white" >Nota</td><td style="color:white" >Materia</td> </tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td   class='idEstudiante' values="+ json[i].idEstudiante+ ">"+ json[i].nombre + " </td> <td>" +json[i].nota + "</td> </tr>";
                //var opcion = "<tr><td>" + json[i].nombre + " </td><td>" + json[i].nota + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});

