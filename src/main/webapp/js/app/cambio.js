   
$('#hacerCambio').on('click', function () {
    var mensaje;
    var opcion = confirm("AVISO... Esto Eliminará las asistencias, actividades, alumnos y profesores asignados a un curso. ¿Seguro que desea continuar?");
    if (opcion == true) {
        $.ajax({
        type: 'POST',
        url: "CambioS",
        data: {
          
        },
        dataType: "text",
        success: function (data) {
            alert('Se han efectuado los cambios');
            location.reload();
        },
        async: false
         });
	} else {
	    
	}
   
});



    
	
  
  
  



