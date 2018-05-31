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

        <title>Gestion Estudiante</title>

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
                <div class="col-12">
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                </div>
                <div class="col-sm-6 text-left"> 
                    <form id="EditarE"  >
                        <span class="label label-warning">Si se equivoco al ubicar al estudiante por favor ubiquelo de nuevo, escriba su documento y seleccion el curso</span>
                        <br>
                        <br>
                        <div class="form-group">
                            <label  >Estudiante: </label>
                            <input  class="form-control form-control-success" id="documento" >
                        </div>
                        <div class="form-group">
                            <label >Curso: </label>
                            <select class="form-control" required name="cursos" id="cursos">
                                <option value="" selected disabled>Seleccione un curso</option>
                            </select> 
                        </div>
                        <button type="submit" class="btn btn-success btn-round" name="Editar">Editar</button>
                    </form>
                </div>
                <div class="col-sm-6 text-left"> 
                    <form id="EliminarE"  >
                        <span class="label label-danger">Si por el contrario quiere sacar al estudiante del curso para darle fin a su año escolar escoja primero el curso y luego el estudiante</span>
                        <br>
                        <br>
                        <div class="form-group">
                            <label >Curso: </label>
                            <select class="form-control" required name="cursos2" id="cursos2">
                                <option value="" selected disabled>Seleccione un curso</option>
                            </select> 
                        </div>
                        <div class="form-group">
                            <label >Estudiante: </label>
                            <select class="form-control" required name="estudiante" id="estudiante">
                                <option value="" selected disabled>Seleccione un estudiante</option>
                            </select> 
                        </div>
                        <button type="submit" class="btn btn-danger btn-round" name="Eliminar">Eliminar</button>
                        <br>
                        <br>
                        <br>
                        <br>
                    </form>
                </div>
                <div class="col-sm-2 sidenav">
                </div>
                <div class="col-sm-8">
                    <table class="table " id="tabla" style="" >
                        <thead>
                            <tr>
                                <th>Documento Estudiante</th>
                                <th>Nombre Estudiante</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td id="idEstudiante" ></td>
                                <td id="nombreEstudiante"></td>
                            </tr>
                        </tbody>
                    </table>
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
    <script src="js/app/estudianteCurso.js"></script>
</html>

