
      
$('#guardarCurso').on('click', function () {
    $.ajax({
        type: 'POST',
        url: "CursoS",
       
        data: {
            'nombreCurso': $('#nombreCurso').val(),
            'numeroEstudiantes':$('#numeroEstudiantes').val()
        },
        dataType: "text",
        success: function (data) {
        alert('Se ha guardado el curso exitosamente');
        location.reload();
        },
        async: false
    });
});
  
  
  


