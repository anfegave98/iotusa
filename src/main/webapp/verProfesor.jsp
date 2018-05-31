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

        <title>Gestion Profesor</title>

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
                <div class="col-sm-2 text-left"> 
                    <br>
                    <br>
                    <br>
                    <br>


                    <div class="container">

                        <br>



                    </div>

                    <div id="parteArriba">

                        <div  class="form-group"  >
                            <label >Buscar Profesor:</label>
                            <select class="form-control" required name="cedula" id="cedula">
                                <option value="" selected disabled>Seleccione la cedula</option>
                            </select> 
                        </div>

                        <p id="pa">

                        </p>
                        <br>
                        <button id="boton" type="button" class="btn btn-default" name="Enviar" style="display: none;"  >Editar Perfil</button>

                    </div>


                    <div id="parteAbajo" style="display: none;">
                        <form id="EditarP" >
                            <br>
                            <div class="form-group">
                                <label >Cedula:</label>
                                <input  class="form-control form-control-success" id="cedula2" readonly="readonly" >
                            </div>
                            <div class="form-group">
                                <label >Nombre:</label>
                                <input  class="form-control form-control-success" id="nombre" >
                            </div>
                            <div class="form-group">
                                <label  >Usuario:</label>
                                <input  class="form-control form-control-success" id="usuario">
                            </div>


                            <div class="form-group">
                                <label >Fecha de Nacimiento:</label>
                                <div class="col-md-12">
                                    <div class="row">
                                        <div class='col-sm-10'>
                                            <div class="form-group">
                                                <div class='input-group date'  id='datetimepicker' >
                                                    <input  id="fechanacimiento" name="fecha" type='text' class="form-control datetimepicker" placeholder="MM/DD/AAAA" />
                                                    <span class="input-group-addon">
                                                        <span class="glyphicon glyphicon-calendar"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            <div class="form-group">
                                <label >Tipo de Sangre:</label>
                                <input  class="form-control form-control-success" id="tiposangre" >
                            </div> 
                            <div class="form-group">
                                <label >Correo:</label>
                                <input  class="form-control form-control-success" id="correo"  >
                            </div>
                            <div class="form-group">
                                <label >Celular:</label>
                                <input  class="form-control form-control-success" id="celular" >
                            </div> 
                            <div class="form-group">
                                <label >Direccion:</label>
                                <input  class="form-control form-control-success" id="direccion" >
                            </div> 

                            <div class="form-group">
                                <label >Experiencia:</label>
                                <input  class="form-control form-control-success" id="experiencia"  >
                            </div> 
                            <div class="form-inline">
                                <button type="submit" class="btn btn-sm" name="Enviar">Guardar Cambios</button>
                                &nbsp;
                                &nbsp;
                                <br>
                                <br>


                                <button  id="boton2" type="button" class="btn btn-sm" name="Enviar">Volver</button>
                            </div>
                        </form>




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
    <script src="js/app/verP.js"></script>
    <script src="js/app/myfunctions.js"></script>

</html>
