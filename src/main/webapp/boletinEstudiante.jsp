<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/colegio.ico">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
        <title>Boletin Estudiante</title>
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
        <br>
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
                        <br>
                        <div class="form-group">  
                            <form id="Boletin" style="display: none">                                
                                <div>

                                    <label style="color:black">Curso: </label>
                                    <select required name="curso" id="curso" class="form-control">
                                        <option value="" selected disabled>Seleccione un curso</option>
                                    </select> 
                                    <label style="color:black" >Estudiante:</label>
                                    <select required name="estudiante" id="estudiante" class="form-control">
                                        <option value="" selected  disabled>Seleccione un estudiante</option>
                                    </select>   
                            </form>
                            <input type="button" value="Ver Boletin" class="btn btn-default btn-round"  id="VerBoletin"><br> <br>
                            <br>
                            <table class="table table-striped" id="tabBoletin" style="color: black"  >
                                <thead>
                                    <tr>
                                        <th>Materia</th>
                                        <th>Nota</th>
                                    </tr>
                                    <tr>

                                    </tr>
                                </thead>

                                <tbody>

                                    <tr>

                                        <td id="materia" ></td>
                                        <td id="nota"></td>


                                    </tr>


                                    


                                </tbody>
                            </table>

                            <p id="Nota">

                            </p>
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
    <script src="js/app/boletinEstudiante.js"></script>
</body>
</html>
