<nav class="navbar navbar-expand-md fixed-top" color-on-scroll="500" style="background-color: white">
    <div class="container">
        <div class="navbar-translate">
            <button class="navbar-toggler navbar-toggler-right navbar-burger" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-bar"></span>
                <span class="navbar-toggler-bar"></span>
                <span class="navbar-toggler-bar"></span>
            </button>
            <a class="navbar-brand" href="menuProfesor.jsp">Jardin Infantil</a>
        </div>
        <div class="collapse navbar-collapse" id="navbarToggler">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item" >
                    <a href="perfilProfesor.jsp"  class="nav-link"  ><i class=" nc-icon nc-badge"></i>Ver Perfil</a>
                </li>
                <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle " data-toggle="dropdown" id="dropdownMenuButton" href="" role="button" aria-haspopup="true" aria-expanded="false"><i class="nc-icon nc-single-02"></i>Asistencia</a>
                            <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="listaAsistencia.jsp">Tomar Asistencia</a>
                                <a class="dropdown-item" href="verAsistencia.jsp">Ver Asistencia</a>
                               
                            </ul>
                        </div> 
                <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle " data-toggle="dropdown" id="dropdownMenuButton" href="" role="button" aria-haspopup="true" aria-expanded="false"><i class="nc-icon nc-single-02"></i>Notas</a>
                            <ul class="dropdown-menu dropdown-info" aria-labelledby="dropdownMenuButton">
                                <a class="dropdown-item" href="crearNotas.jsp">Crear Nota</a>
                                <a class="dropdown-item" href="verNotaCurso.jsp">Ver Notas Curso</a>
                                <a class="dropdown-item" href="verNotaMateria.jsp">Ver Notas Materia</a>
                                <a class="dropdown-item" href="verNotaActividad.jsp">Ver Notas Actividad</a>
                                <a class="dropdown-item" href="boletinEstudiante.jsp">Ver Boletin</a>
                                
                            </ul>
                </div>
                <li class="nav-item">
                    <a href="observador.jsp"  class="nav-link"><i class="nc-icon nc-paper"></i> Observador</a>
                </li>  
                <li class="nav-item">
                    <a href="actividad.jsp"  class="nav-link"><i class="nc-icon nc-bullet-list-67"></i> Gestion Actividad</a>
                </li> 
                <li class="nav-item">
                    <a href="retroalimentacionEstudiante.jsp"  class="nav-link"><i class="nc-icon nc-chart-bar-32"></i> Retroalimentacion</a>
                </li>
                <li class="nav-item">
                    <a href="Login?action=salir" class="nav-link"><i class="nc-icon nc-button-power"></i> Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
