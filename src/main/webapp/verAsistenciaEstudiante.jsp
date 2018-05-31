<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
     <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/colegio.ico">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Ver Asistencia Estudiante</title>
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
                    <br>
                    <form id="formulario" class="form-inline" >
                        <div class="form-group">
                            <SELECT  id="cursosProfesor" class="form-control">
                                <OPTION></OPTION>

                            </SELECT>
                        </div> 
                        
                        <div class="form-group">
                            <SELECT  id="nombre" class="form-control">
                                <OPTION></OPTION>

                            </SELECT>
                        </div>

                          
                        <input type="button" value="Buscar" class="btn btn-default btn-round"  id="Buscar"><br> <br>
                        
                        <table class="table table-striped" id="tablaEstudiante" style="color: white"  >
                            <thead>
                                <tr>
                                    <th>Nombre Estudiante</th>
                                    <th>Fechas de Ausencia</th>

                                </tr>
                            </thead>

                            <tbody>

                                <tr>

                                    
                                    <td id="nombre_estudiante"></td>
                                    <td id="fechaAusencia" ></td>


                                </tr>


                            </tbody>
                        </table>


                    </form>




                </div>

            </div>
        </div>

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

        <!--  <script src="js/jquery-1.7.1.min.js"></script>-->
        <script src="js/app/verasistenciaestudiante.js"></script>
    </body>
</html>