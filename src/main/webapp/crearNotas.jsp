<%@page import="Modelo.Profesor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        Profesor p = (Profesor) request.getSession().getAttribute("profesor");
        if (p != null) {
            if (p.getTipoU() == 0) {
                response.sendRedirect("menuAdmin.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    %>
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/colegio.ico">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Gestion Notas</title>

        <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <!-- Bootstrap core CSS     -->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="assets/css/paper-kit.css?v=2.1.0" rel="stylesheet"/>

        <!--  CSS for Demo Purpose, don't include it in your project     -->
        <link href="assets/css/demo.css" rel="stylesheet" />

        <!--     Fonts and icons     -->
        <link href='http://fonts.googleapis.com/css?family=Montserrat:400,300,700' rel='stylesheet' type='text/css'>
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/css/nucleo-icons.css" rel="stylesheet" />

    </head>
    <body style="background-color:#ccccff">
        <%@include file="headerProfesor.jsp" %>
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <br>
                    <br>
                    <br>
                    <br>

                    <div class="container">
                        <br>
                        <form id="SelectCM">                                
                            <div>
                                <label >Curso y Materia: </label>
                                <select class="form-control" required name="cm" id="cm">
                                    <option value="" selected disabled>Seleccione uno</option>
                                </select> 
                                <br>
                                <label >Tema: </label>
                                <select class="form-control" required name="tema" id="tema">
                                    <option value="" selected disabled>Seleccione un tema</option>
                                </select> 
                                <br>
                                
                                <label>Actividad: </label>
                                <select class="form-control" required name="actividades" id="actividades">
                                    <option value="" selected disabled>Seleccione una actividad </option>
                                </select>  
                                <br>
                                
                            </div>  
                        
                        
                        
                        </form>
                        <form id="AddNota" style="display: none;">
                            <div class="form-group" >
                                <table id="tablaNota" class="table table-hover" style="display: none;">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Nota</th>
                                            <th>Detalles</th>
                                        </tr>
                                    </thead>
                                    
                                    <tbody>
                                        <tr>
                                            <td id="Nombre"></td>
                                            <td id="Nota"></td>
                                            <td id="detallesextra"</td>
                                        </tr>
                                    </tbody>     
                                </table> 
                                </div>
                            </div>
                            <button type="submit" class="btn btn-neutral" id="botonsito" name="Enviar" style="display: none;">Agregar Nota</button>
                        </form>                        
                    </div>
                </div>

            </div>

    </body>
    <script src="assets/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="assets/js/jquery-ui-1.12.1.custom.min.js" type="text/javascript"></script>
    <script src="assets/js/popper.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!-- Switches -->
    <script src="assets/js/bootstrap-switch.min.js"></script>

    <!--  Plugins for Slider -->
    <script src="assets/js/nouislider.js"></script>

    <!--  Plugins for DateTimePicker -->
    <script src="assets/js/moment.min.js"></script>
    <script src="assets/js/bootstrap-datetimepicker.min.js"></script>

    <!--  Paper Kit Initialization and functons -->
    <script src="assets/js/paper-kit.js?v=2.1.0"></script>
    <script src="js/app/notas.js"></script>
</html>
