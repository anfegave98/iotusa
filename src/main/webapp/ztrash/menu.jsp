<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Menu Principal</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->

    </head>
    <body background="fondo.jpg">

        <div class="container">
            <h1 class="col-md-4">Menu Principal</h1>
            <div class="span12">&nbsp;</div>
            <div class="span12">&nbsp;</div>
            <div class="span12">&nbsp;</div>
        

            <div class="col-md-4">
                <a class href="BuscarProfesor">
                    <button type="button" class="btn tm-bordered-btn pull-xs-center"> Ver Perfil</button>
                </a>
                <br>
                <br>
                <a  href="ListaAsistencia">
                    <button type="button" class="btn tm-bordered-btn pull-xs-center">Asistencia Curso</button>
                </a>
                <br>
                <br>
                <a  href="notas.jsp">
                    <button   type="button" class="btn tm-bordered-btn pull-xs-center">Notas Curso</button>  
                </a>
                <br>
                <br> 
                <a  href="Obs">
                    <button   type="button" class="btn tm-bordered-btn pull-xs-center">Observador</button>  
                </a>
                
            </div>
        </div>
    </body>
</html>