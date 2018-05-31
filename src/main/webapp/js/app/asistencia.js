$(document).ready(function () {
    $
        $.ajax({
            type: 'GET',
            url: "AsistenciaS",
            //force to handle it as text
            data: {
                'op':"0"

            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#cursosProfesor');
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled>Seleccione un Curso</option>');
                var json = $.parseJSON(data);
                console.log(json);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<option class='idCursos' value=\"" + json[i].idCurso + "\">" + json[i].nombre + "</option>";
                    selectForm.append(opcion);
                }
                selectForm.attr('required', false);
            },
            async: false
        });
    });
    
     
    
    




 $('#cursosProfesor').on('change' , function () {
        $.ajax({
            type: 'GET',
            url: "AsistenciaS",
            //force to handle it as text
            data: {
                'op':"2",
                'curso':$('#cursosProfesor').val()
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#tabla');
               
                selectForm.empty();
                selectForm.append('<option selected  value="" disabled></option>');
                var json = $.parseJSON(data);
                var ok = 'ok';
                var NO = 'no';
                console.log(json);
                for (var i = 0; i < json.length; ++i)
                {
                    var opcion = "<tr><td class='idEstudiantes' values="+ json[i].idEstudiante + ">" + json[i].idEstudiante + "</td> <td>" + json[i].nombre + " </td> <td>  <select class='vino'> <option value= 'Presente' > Presente </option><option value= 'Ausente' > Ausente </option> </select> </tr>";
                    selectForm.append(opcion);
                }
                selectForm.attr('required', false);
            },
            async: false
        });
    });

  
  
  
$('#guardarAsistencia').on('click', function () {
    var idEstudiante = Array();
    var vino = Array();
      $('#tabla tbody tr').each(function(i, x) {
       
        idEstudiante[i]=$(this).children('td').eq(0).attr('values');
        
        vino[i]=$(this).children('td').eq(2).children("select").children("option:selected").val();
    });      
      
      console.log(idEstudiante);
      console.log(vino);
      


    $.ajax({
        type: 'POST',
        url: "AsistenciaS",
        data: {
            'idEstudiante': idEstudiante,
            'vino': vino
            
       
        },
        dataType: "text",
        success: function (data) {
            alert('Se ha guardado la Asistencia exitosamente');
            location.reload();
        },
        async: false
    });
});
  
  
  
//
//$('#cursosProfesor').on('change', function () {
//    $.ajax({
//        type: 'POST',
//        url: "S",
//        //force to handle it as text
//        data: {
//         
//        },
//        dataType: "text",
//        success: function (data) {
//
//            var selectForm = $('#estudiante');
//            selectForm.empty();
//            selectForm.append('<option selected  value="" disabled>Seleccion un estudiante</option>');
//            var json = $.parseJSON(data);
//            for (var i = 0; i < json.length; ++i)
//            {
//                var opcion = "<option value=\"" + json[i].idEstudiante + "\">" + json[i].nombre + "</option>";
//                selectForm.append(opcion);
//            }
//            selectForm.attr('required', false);
//        },
//        async: false
//    });
//});


