<%@page import="Modelo.Profesor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
     <%
    Profesor p=(Profesor)request.getSession().getAttribute("profesor");
    if(p!=null){
        if(p.getTipoU()==1){
            response.sendRedirect("menuProfesor.jsp");
        }
    }else{
        response.sendRedirect("index.jsp");
    }
    %>
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/colegio.ico">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Perfil Administrador</title>

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
    <body style="background-color:black">
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


                    <div class="container">
                        <a>
                            <button type="button" class="btn btn-default btn-round" id="verPerfil">Ver Perfil</button>
                        </a>
                        <br>
                        <br>
                        <div class="form-group">
                            <label style="color:white">Nombre:</label>
                            <input  class="form-control form-control-success" id="nombre" readonly="readonly" >
                        </div>
                        <div class="form-group">
                            <label style="color:white" >Usuario:</label>
                            <input  class="form-control form-control-success" id="usuario" readonly="readonly" >
                        </div>
                        <div class="form-group">
                            <label style="color:white">Fecha de Nacimiento:</label>
                            <input  class="form-control form-control-success" id="fechanacimiento" readonly="readonly" >
                        </div> 
                        <div class="form-group">
                            <label style="color:white">Tipo de Sangre:</label>
                            <input  class="form-control form-control-success" id="tiposangre" readonly="readonly" >
                        </div> 
                        <div class="form-group">
                            <div class="form-group">
                                <label style="color:white">RH:</label>
                                <input  class="form-control form-control-success" id="rh" readonly="readonly" >
                            </div> 
                            <label style="color:white">Correo:</label>
                            <input  class="form-control form-control-success" id="correo" readonly="readonly" >
                        </div>
                        <div class="form-group">
                            <label style="color:white">Celular:</label>
                            <input  class="form-control form-control-success" id="celular" readonly="readonly" >
                        </div> 
                        <div class="form-group">
                            <label style="color:white">Direccion:</label>
                            <input  class="form-control form-control-success" id="direccion" readonly="readonly" >
                        </div> 
                        <div class="form-group">
                            <label style="color:white">Estudios:</label>
                            <input  class="form-control form-control-success" id="estudios" readonly="readonly" >
                        </div> 
                        <div class="form-group">
                            <label style="color:white">Experiencia:</label>
                            <input  class="form-control form-control-success" id="experiencia" readonly="readonly" >
                        </div> 
                    </div>

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
    <script src="js/app/funciones.js"></script>
</html>
