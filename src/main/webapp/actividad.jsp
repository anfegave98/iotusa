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

        <title>Gestion Actividad</title>

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
                        <div id="parteArriba">
                        <form id="SelectCM" style="display: none;">                                
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
                            </div> 
                        </form>

                        <p id="actividades">

                        </p>

                        <form id="SelectCM2" style="display: none;"> 
                            <div id="nombreaparece" style="display: none;">
                                <label  for="detalle">Nombre: </label>
                                <input type="text" class="form-control form-control-success" name="nombre" id="nombre"> 
                                <br>
                                <button type="submit" class="btn btn-neutral" id="botonsito" name="Enviar" style="display: none;">Agregar</button>
                            </div>  

                        </form>
                        <table id="tablaCM" class="table table-hover" style="display: none;">

                        </table>  
                        </div>
                        <div id="parteAbajo" style="display: none;">
                        <form id="EditarA">
                            <div  class="form-group" style="display: none;" >
                                <label >Id:</label>
                                <input  class="form-control form-control-success" id="idactividad2" value="">
                            </div>
                            <div  class="form-group" style="display: none;" >
                                <label >IdTema:</label>
                                <input  class="form-control form-control-success" id="tema2" value="">
                            </div>
                            <div  class="form-group" >
                                <label >Actividad:</label>
                                <input  class="form-control form-control-success" id="actividad2" value="">
                            </div>
                            <div class="form-inline">
                                <button   type="submit" class="btn btn-outline-info btn-sm btn-round" name="Enviar">Guardar Cambios</button>
                                &nbsp;
                                &nbsp;
                                
                               <button  id="boton3" type="button" class="btn btn-outline-danger btn-sm btn-round" name="Enviar">Volver</button>
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
    <script src="js/app/actividad.js"></script>
</html>
