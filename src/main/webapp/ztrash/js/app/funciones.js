
  function Listar(){
    $.ajax({
        url: "BuscarProfesor",
        type: "POST",
        success: function (data) {
            var lista = $.parseJSON(data);
            $("#profesor").append('<div class="form-group"><label for="nombre_profesor">Nombre:</label>'
                    + '<input  class="form-control" name="nombre_profesor" readonly="readonly" value="' + lista[0].nombre_profesor + '"></div>'
                    + '<div class="form-group"><label for="descripcion">Usuario:</label><input  class="form-control" name="usuario_profesor" readonly="readonly" value="' + lista[0].usuario_profesor + '">'
                    + '</div>'
                    + '<div class="form-group">'
                    + '<label for="descripcion_profesor">Descripcion:</label>'
                    + '<input  class="form-control" name="descripcion_profesor" readonly="readonly" value="' + lista[0].descripcion_profesor + '">'
                    + '</div>'
                    + '<div class="form-group">'
                    + '<label for="contato_profesor">Contacto:</label>'
                    + '<input  class="form-control" name="contacto_profesor" readonly="readonly" value="' + lista[0].contacto_profesor + '">'
                    + '</div>')
            
              }
                
      }
      );
  }       
        
    

 