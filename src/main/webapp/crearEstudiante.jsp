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
        <script>
            function lettersOnly(input) {
                var regex = /[^a-z- ]/gi;
                input.value = input.value.replace(regex, "");
            }
        </script>
        <script>
            function NumbersOnly(input) {
                var regex = /[^0-9]/gi;
                input.value = input.value.replace(regex, "");
            }
        </script>
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
                    <div class="container">

                    </div>
                    <br>

                    <form id="CrearE" >
                        <div class="form-group">
                            <label >Documento:</label>
                            <input placeholder="Solo numeros" onkeyup="NumbersOnly(this)" class="form-control form-control-success" id="documento" required>
                        </div>
                        <div class="form-group">
                            <label  >Nombre:</label>
                            <input placeholder="Solo Letra"   onkeyup="lettersOnly(this)" class="form-control form-control-success" id="nombre" required  >
                        </div>
                        <div class="form-group">
                            <label >Direccion:</label>
                            <input  class="form-control form-control-success" id="direccion" required  >
                        </div> 
                        <div class="form-group">
                            <label >Celular:</label>
                            <input placeholder="Solo numeros" onkeyup="NumbersOnly(this)" class="form-control form-control-success" id="celularcontacto" required >
                        </div>
                        <label >Fecha de Nacimiento:</label>
                        <div class="row">
                            <div class='col-sm-6'>
                                <div class="form-group">
                                    <div class='input-group date'  id='datetimepicker' >

                                        <input required id="fechanacimiento" name="fecha" type='text' class="form-control datetimepicker" placeholder="MM/DD/AAAA" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"><i class="fa fa-calendar" aria-hidden="true"></i></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-sm-4">
                            <label >Tipo de sangre:</label>
                            <select required class="form-control" id="tiposangre" required>
                                <option selected  value="" disabled>Seleccione un tipo de sangre</option>
                                <option>A+</option>
                                <option>B+</option>
                                <option>O+</option>
                                <option>AB+</option>
                                <option>A-</option>
                                <option>B-</option>
                                <option>O-</option>
                                <option>AB-</option>
                            </select>
                        </div> 
                        <h6>Seleccione un curso si quiere asignar al estudiante</h6>
                        <div class="form-group">
                            <label >Curso: </label>
                            <select class="form-control" name="curso" id="curso">
                                <option value="0" selected disabled>Seleccione un curso</option>
                            </select> 
                        </div>

                        <button type="submit" class="btn btn-default">Enviar</button>
                    </form>





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

