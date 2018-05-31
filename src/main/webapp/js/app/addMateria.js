$('#guardarMateria').on('click', function (e) {
console.log('in');
e.preventDefault();
    $.ajax({
        type: 'POST',
        url: "MateriaS",

        data: {
            'nombreMateria': $('#nombreMateria').val()
        },
        dataType: "text",
        success: function (data) {
        alert('Se ha guardado la Materia exitosamente');
        location.reload();
        }
         });
});

