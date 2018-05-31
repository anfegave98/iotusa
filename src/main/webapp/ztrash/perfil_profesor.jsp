<%@page import="Model.Profesor"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Perfil Profesor</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->

    </head>
    <body>

        <%--  <%@include file="header.jsp" %> --%>
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <h1>Perfil Profesor</h1>
                    <p></p>

                    <div class="container">  



                     



                        <% if (request.getAttribute("listaProfesorBuscar") != null) {
                                ArrayList<Profesor> list = (ArrayList<Profesor>) request.getAttribute("listaProfesorBuscar");
                                if (list != null)
                                    for (Profesor profesor : list) {
                        %>





                        <div class="form-group">
                            <label for="nombre_profesor">Nombre:</label>
                            <input  class="form-control" name="nombre_profesor" readonly="readonly" value="<%=profesor.getNombre_profesor()%>">
                        </div>
                        <div class="form-group">
                            <label for="descripcion">Usuario:</label>
                            <input  class="form-control" name="descripcion_profesor" readonly="readonly" value="<%=profesor.getUsuario_profesor()%>">
                        </div>
                        <div class="form-group">
                            <label for="descripcion_profesor">Descripcion:</label>
                            <input  class="form-control" name="descripcion_profesor" readonly="readonly" value="<%=profesor.getDescripcion_profesor()%>">
                        </div>
                        <div class="form-group">
                            <label for="contato_profesor">Contacto:</label>
                            <input  class="form-control" name="contacto_profesor" readonly="readonly" value="<%=profesor.getContacto_profesor()%>">
                        </div>
                        <% }
                                }
                        %>


                        <br>
                <br>
                <a  href="menu.jsp">
                    <button type="button" class="btn tm-bordered-btn pull-xs-center">Volver</button>
                </a>
                    </div>

                </div>

            </div>
        </div>
        <p></p>
    

    </body>
</html>