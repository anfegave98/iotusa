<%@page import="Modelo.Profesor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        Profesor p = (Profesor) request.getSession().getAttribute("profesor");
        if (p != null) {
            if (p.getTipoU() == 1) {
                response.sendRedirect("menuProfesor.jsp");
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

        <title>Asignar Profesor</title>

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
    <body style="background-color:white">
        <%@include file="headerAdmin.jsp" %>
        <div class="container-fluid text-center">    
            <div class="row content">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-8 text-left"> 
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <form id="ubicarPro">                                
                        <div class="form-group">
                            <label >Curso: </label>
                            <select class="form-control" required name="curso" id="curso">
                                <option value="" selected disabled>Seleccione un curso</option>
                            </select> 
                        </div>
                        <div class="form-group">
                            <label  >Profesor: </label>
                            <select required name="profesor" id="profesor" class="form-control">
                                <option value="" selected  disabled>Seleccione un profesor</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label >Fecha de Inicio:</label>
                            <div class="col-md-6">
                                <div class="row">
                                    <div class='col-sm-6'>
                                        <div class="form-group">
                                            <div class='input-group date'  id='datetimepicker' >
                                                <input  id="fecha" name="fecha" type='text' class="form-control datetimepicker" placeholder="MM/DD/AAAA" />
                                                <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div> 
                        <button type="submit" class="btn btn-default" name="Enviar">Ubicar</button>
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
    <script src="js/app/ubicarDirector.js"></script>
</html>
