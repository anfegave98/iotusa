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

        <title>Observador</title>

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
        <div class=" text-center">    
            <div class="">
                <div class="col-sm-2 sidenav">

                </div>
                <div class="col-sm-12 text-left"> 
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <div class="">
                       
                        <form id="SelectCurso" >                                
                            <div >
                                <div class="form-inline" >
                                    <label >Profesor: </label>
                                    <select class="form-control" required name="profe" id="profe">
                                        <option value="" selected disabled>Seleccione el profesor</option>
                                        <option value="0" >Director</option>
                                        <option value="1" >Profesor</option>
                                    </select> 
                                    <label >Curso: </label>
                                    <select class="form-control" required name="curso" id="curso">
                                        <option value="" selected disabled>Seleccione un curso</option>
                                    </select> 
                                   
                                    <label  >Estudiante:</label>
                                    <select required name="estudiante" id="estudiante" class="form-control">
                                        <option value="" selected  disabled>Seleccione un estudiante</option>
                                    </select>   
                                    
                                </div>
                            </div>
                            <br>
                            <br>
                            <table id="tablaObs" class="table table-hover" style="display: none;">

                            </table>

                        </form>
                        <form id="AddObs" style="display: none;">
                            <div class="form-group" >
                                <label  for="detalle">Detalle:</label>
                                <input type="text" class="form-control form-control-success col-8" name="detalle" id="detalles">                               
                                <br> 
                                <label for="calificacion" >Calificacion: </label>
                                <div class="col-1">
                                    <select required name="calificacion" id="calificacion" class="form-control">
                                        <option value="" selected disabled >Seleccione una opcion</option>
                                        <option value="5" style="color:green">5</option>  
                                        <option value="4" style="color:yellowgreen">4</option> 
                                        <option value="3"style="color:yellow">3</option>
                                        <option value="2" style="color:orange">2</option>
                                        <option value="1" style="color:red">1</option>
                                    </select> 
                                </div>
                            </div>
                            <button type="submit" class="btn btn-default" name="Enviar">Enviar</button>
                        </form>                                                               
                    </div>
                </div>

            </div>

    </body>
    <script src="assets/js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="assets/js/jquery-ui-1.12.1.custom.min.js" type="text/javascript"></script>
    <script src="assets/js/popper.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Plugins for Slider -->
    <script src="assets/js/nouislider.js"></script>
    <script src="js/app/observador.js"></script>
    <script src="js/app/log.js"></script>
</html>
