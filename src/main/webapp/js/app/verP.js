
$(document).ready(function () {
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
            $('#VerP').removeAttr('style');
            var selectForm = $('#cedula');
            selectForm.empty();
            selectForm.append('<option selected  value="" disabled>Seleccione un profesor</option>');
            var json = $.parseJSON(data);
            console.log(json);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<option value=\"" + json[i].idProfesor + "\">" + json[i].idProfesor + "</option>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
    $('#cedula').on('change', function () {
        $.ajax({
            type: 'GET',
            url: "ProfesorGestion",
            //force to handle it as text
            data: {
                'opcion': "1",
                'cedula': $('#cedula').val()
                        // 'documento':"144144"
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#pa');
                var json = $.parseJSON(data);
                selectForm.empty();
                var opcion = "<p style=\"\" >Cedula: " + json.idProfesor + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Nombre: " + json.nombre + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Usuario: " + json.usuario + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Fecha Nacimiento: " + json.fechaNacimiento + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Tipo Sangre: " + json.tipoSangre + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Correo: " + json.correo + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Celular: " + json.celular + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Direccion: " + json.direccion + ".</p>";
                selectForm.append(opcion);
                opcion = "<p style=\"\" >Experiencia: " + json.experiencia + ".</p>";
                selectForm.append(opcion);
                $('#cedula2').attr('value', json.idProfesor);
                $('#nombre').attr('value', json.nombre);
                $('#tipousuario').attr('value', json.tipoU);
                $('#password').attr('value', json.password);
                $('#usuario').attr('value', json.usuario);
                $('#fechanacimiento').attr('value', json.fechaNacimiento);
                $('#tiposangre').attr('value', json.tipoSangre);
                $('#rh').attr('value', json.rh);
                $('#correo').attr('value', json.correo);
                $('#celular').attr('value', json.celular);
                $('#direccion').attr('value', json.direccion);
                $('#estudios').attr('value', json.estudios);
                $('#experiencia').attr('value', json.experiencia);
                $('#boton').removeAttr('style');


            },
            async: false
        });
    });
});
$('#boton').on('click',function(){
     $('#parteArriba').attr('style', 'display: none;');
     $('#parteAbajo').removeAttr('style');
 });
 $('#boton2').on('click',function(){
     $('#parteAbajo').attr('style', 'display: none;');
     $('#parteArriba').removeAttr('style');
 });