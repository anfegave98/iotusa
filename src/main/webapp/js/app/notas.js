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
            $('#SelectCM').removeAttr('style');
            var selectForm = $('#cm');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione uno</option>');
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

$('#cm').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as text
        data: {
            'opcion': "1",
            'idcm': $('#cm').val()
        },
        dataType: "text",
        success: function (data) {
            $('#actividades').removeAttr('style');
            $('#botonsito').attr('style', 'display: none;');
            var selectForm = $('#tema');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un tema</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idTema + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});


$('#tema').on('change', function () {
    $.ajax({
        type: 'GET',
        url: "NotaS",
        //force to handle it as te
        data: {
            'opcion': "2",
            'tema': $('#tema').val()
        },
        dataType: "text",
        success: function (data) {

            var selectForm = $('#actividades');
            var boton= $('#botonsito');
            boton.removeAttr('style');
            $('#actividades').removeAttr('style');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione una actividad</option>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
            
                var opcion = "<option value=\"" + json[i].id + "\">" + json[i].nombre + "</option>";
                selectForm.append(opcion);
            }
            },
        async: false
    });
});
$('#actividades').on('change', function () {
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
            $('#tablaNota').removeAttr('style');
            $('#AddNota').removeAttr('style');
            var selectForm = $('#tablaNota');
            selectForm.empty();
            selectForm.append('<tr><td>Estudiante</td><td>Ingrese Nota</td> <td>Detalles</td></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td class='idEstudiante' values="+ json[i].idEstudiante+ ">"+ json[i].nombre + " </td> <td>  <select class='nota'> <option value= '1' > 1 </option><option value= '2' > 2 </option><option value= '3' > 3 </option><option value= '4' > 4 </option><option value= '5' > 5 </option></select></td> <td>  <select class='detalle'> <option value= 'no retiene' > no retiene </option><option value= 'no cumple con las actividades' > no cumple con las actividades </option><option value= 'cumple con lo requerido' > cumple con lo requerido </option><option value= 'cumple las expectativas' > cumple las expectativas </option><option value= 'supera las expectativas' > supera las expectativas </option></select></td></tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
});

/*$('#AddNota').on('submit', function () {
    $.ajax({
        type: 'POST',
        url: "NotaS",
        data: {
            'nota': $('#nota').val(),
            'idEstudiante': $('#estudiante').val(),
            'id':$('#actividad').val()
        },
        dataType: "text",
        success: function (data) {
        },
        async: false
    });
});*/

$('#botonsito').on('click', function () {
    var idEstudiante = Array();
    var nota = Array();
    var detalles = Array();
    var idActividad = $('#actividades').val();
      $('#tablaNota tbody tr').each(function(i, x) {
       
        idEstudiante[i]=$(this).children('td').eq(0).attr('values');
        
        nota[i]=$(this).children('td').eq(1).children("select").children("option:selected").val();
        
        detalles[i]=$(this).children('td').eq(2).children("select").children("option:selected").val();
    });      
      
      console.log(idEstudiante);
      console.log(nota);
      console.log(detalles);
      
      
    $.ajax({
        type: 'POST',
        url: "NotaS",
        data: { //envio de datos al servlet
            'nota': nota,
            'idEstudiante': idEstudiante,
            'idActividad': idActividad,
            'detallesextra': detalles
            
        },
        dataType: "text",
        success: function (data) {
            alert('Se ha guardado la Nota exitosamente');
            location.reload();
        },
        async: false
    });
});
