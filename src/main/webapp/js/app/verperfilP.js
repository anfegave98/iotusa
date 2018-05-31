$(document).ready(function () {
    $.ajax({
        type: 'GET',
        url: "ProfesorS",
        //force to handle it as text
        data: {

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

            $('#nombre').attr('value', json.nombre);
            $('#usuario').attr('value', json.usuario);
            $('#fechanacimiento').attr('value', json.fechaNacimiento);
            $('#tiposangre').attr('value', json.tipoSangre);
            $('#rh').attr('value', json.rh);
            $('#correo').attr('value', json.correo);
            $('#celular').attr('value', json.celular);
            $('#direccion').attr('value', json.direccion);
            $('#estudios').attr('value', json.estudios);
            $('#experiencia').attr('value', json.experiencia);

        },
        async: false
    });
    
    $.ajax({
        type: 'GET',
        url: "ProfesorS",
        //force to handle it as text
        data: {

        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#b');
            var json = $.parseJSON(data);
            selectForm.empty();
            var opcion = "<h2>Bienvenido/a Profesor/a: " + json.nombre + "</h2>";
            selectForm.append(opcion);
            

        },
        async: false
    });
    
    $.ajax({
        type: 'GET',
        url: "ProfesorS",
        //force to handle it as text
        data: {

        },
        dataType: "text",
        success: function (data) {
            var selectForm = $('#b2');
            var json = $.parseJSON(data);
            selectForm.empty();
            var opcion = "<h2>Bienvenido/a Administrador/a: " + json.nombre + "</h2>";
            selectForm.append(opcion);
            

        },
        async: false
    });
    
    $.ajax({
        type: 'GET',
        url: "ObservadorS",
        //force to handle it as text

        data: {
            'opcion': "0"
        },
        dataType: "text",
        success: function (data) {
          
            var selectForm = $('#tabla');
            selectForm.empty();
            selectForm.append('<tr><td>Curso</td></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].nombre + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
    $.ajax({
        type: 'GET',
        url: "ProfesorGestion",
        //force to handle it as text

        data: {
            'opcion': "4"
        },
        dataType: "text",
        success: function (data) {
          
            var selectForm = $('#tabla2');
            selectForm.empty();
            selectForm.append('<tr><td>Curso</td><td>Materia</td></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].curso + "</td><td>" + json[i].Materia + "</td></tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
    
    $.ajax({
        type: 'GET',
        url: "ProfesorGestion",
        //force to handle it as text

        data: {
            'opcion': "6"
        },
        dataType: "text",
        success: function (data) {
          
            var selectForm = $('#tabla4');
            selectForm.empty();
            selectForm.append('<tr><td>Documento</td><td>Estudiante</td></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].idEstudiante + "</td><td>" + json[i].nombre + "</td> </tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
    $.ajax({
        type: 'GET',
        url: "ProfesorGestion",
        //force to handle it as text

        data: {
            'opcion': "7"
        },
        dataType: "text",
        success: function (data) {
          
            var selectForm = $('#tabla5');
            selectForm.empty();
            selectForm.append('<tr><td>Profesores</td></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].nombre + "</td></tr>";
                selectForm.append(opcion);
            }
        },
        async: false
    });
    $.ajax({
            type: 'GET',
            url: "ProfesorGestion",
            //force to handle it as text

            data: {
                "opcion": '3'
               
            },
            dataType: "text",
            success: function (data) {
                var selectForm = $('#p');
                selectForm.empty();
                var json = $.parseJSON(data);
                var opcion = "<p>" + json + "</p>";
                selectForm.append(opcion);
            },
            async: false
        });
        
        $.ajax({
            type: 'GET',
            url: "ProfesorGestion",
            //force to handle it as text

            data: {
                "opcion": '5'
               
            },
            dataType: "text",
            success: function (data) {
                 var selectForm = $('#tabla3');
            selectForm.empty();
            selectForm.append('<tr><td>Actividad</td></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].nombre + "</td></tr>";
                selectForm.append(opcion);
            }
            },
            async: false
        });
        
        $.ajax({
            type: 'GET',
            url: "ProfesorGestion",
            //force to handle it as text

            data: {
                "opcion": '8'
               
            },
            dataType: "text",
            success: function (data) {
                 var selectForm = $('#tabla6');
            selectForm.empty();
            selectForm.append('<tr><td>Curso</td><td>Materia</td></tr>');
            var json = $.parseJSON(data);
            for (var i = 0; i < json.length; ++i)
            {
                var opcion = "<tr><td>" + json[i].fechaInicio+ "</td><td>" + json[i].idProfesor + "</td></tr>";
                selectForm.append(opcion);
            }
            },
            async: false
        });

});


