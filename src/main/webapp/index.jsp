<%@page import="Modelo.Profesor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        Profesor p = (Profesor) request.getSession().getAttribute("profesor");
        if (p != null) {
            if (p.getTipoU() == 0) {
                response.sendRedirect("menuAdmin.jsp");
            } else {
                response.sendRedirect("menuProfesor.jsp");
            }
        }
    %>
    <head>
        <meta charset="utf-8" />
        <link rel="icon" type="image/png" href="assets/img/colegio.ico">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

        <title>Bienvenido</title>

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
        <div class="page-header section-dark" style="background-image: url('assets/img/colegio2.jpg')">
            <div class="filter"></div>
            <div class="content-center">
                <div class="container">
                    <div class="title-brand">
                        &nbsp;
                        <h1 class="presentation-title">Jardines</h1>

                        <%-- <div class="fog-low right">
                             <img src="assets/img/fog-low.png" alt="">
                         </div>
                        --%>
                    </div>

                    <h2 class="presentation-subtitle text-center">Kids are the future </h2>
                </div>
            </div>
            <div class="moving-clouds" style="background-image: url('assets/img/clouds.png'); ">

            </div>
            <h6 class="category category-absolute">Designed and coded by AUND
                <a href="" target="_blank">
                    <img src="">
                </a>
            </h6>


            <div class="container" >
                <div class="row" >
                    <div class="col-md-4 ml-auto mr-auto">
                        <div class="card card-register" style="background-color:#FB404B">
                            <h3 class="title">Bienvenido</h3>

                            <form class="register-form" id="ingreso">
                                <label>Usuario:</label>
                                <div class="input-group form-group-no-border">
                                    <span class="input-group-addon">
                                        <i class="nc-icon nc-single-02"></i>
                                    </span>
                                    <input type="text" class="form-control" placeholder="Usuario" id="usuario">
                                </div>

                                <label>Contraseña:</label>
                                <div class="input-group form-group-no-border">
                                    <span class="input-group-addon">
                                        <i class="nc-icon nc-key-25"></i>
                                    </span>
                                    <input type="password" class="form-control" placeholder="Contraseña" id="contra">
                                </div>
                                <button class="btn btn-warning btn-block btn-round" >Iniciar Sesion</button>
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
    <script src="js/app/login.js"></script>
</html>

