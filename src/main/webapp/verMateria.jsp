<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/colegio.ico">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Ver Materia</title>
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

                    <div id="parteArriba" >
                    <form id="formulario"  >




                        <table class="table" id="tabla" >
                            <thead>
                                <tr>

                                    <th>Nombre Materia</th>

                                </tr>
                            </thead>

                            <tbody>

                                <tr>

                                    <td id="nombreMateria"></td>
                                    
                                </tr>


                            </tbody>
                        </table>


                    </form>


                    </div>
                    <div id="parteAbajo" style="display: none;">
                        <form id="EditarM">
                            <div  class="form-group" style="display: none;" >
                                <label >Id:</label>
                                <input  class="form-control form-control-success" id="idmateria2" value="">
                            </div>
                            <div  class="form-group" >
                                <label >Materia:</label>
                                <input  class="form-control form-control-success" id="materia2" value="">
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
        <script src="js/app/verMateria.js"></script>
    </body>
</html>