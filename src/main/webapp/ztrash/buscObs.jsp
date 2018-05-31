<%@page import="Model.Estudiante"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Observador</title>
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
                    <h1>Observador</h1>
                    <p></p>
                    <div class="container">
                        <form align="center" action="Obs" method="POST" class="tm-contact-form">                                
                            <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-left">
                                <label align="center" for="estudiante">Estudiante: </label>
                                <select name="estudiante" class="form-control form-control-lg" id="Seleccion">
                                    <%
                                        if (request.getAttribute("respuesta") != null) {
                                            ArrayList<Estudiante> array = (ArrayList<Estudiante>) request.getAttribute("respuesta");
                                            for (Estudiante t : array) {
                                    %>
                                    <option value="<%=t.getId_estudiante()%>"><%=t.getNombre_estudiante()%></option>
                                    <%      }
                                        }
                                    %>
                                </select>   
                                <br>
                                <button type="submit" class="btn tm-bordered-btn pull-xs-center">Buscar</button>
                                <a class="btn tm-bordered-btn pull-xs-center" href="menu.jsp" role="button">Volver</a>
                            </div>                         
                        </form>
                    </div>

                </div>

            </div>
        </div>
        <p></p>


    </body>
</html>