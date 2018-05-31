/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.AsistenciaDAO;
import Dao.CursoDAO;
import Dao.EstudianteDAO;
import Dao.FechaDAO;
import Dao.DirectorCursoDAO;
import Dao.EstudianteCursoDAO;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Fecha;
import Modelo.Profesor;
import Modelo.Asistencia;
import Modelo.DirectorCurso;
import Modelo.EstudianteCurso;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gibran
 */
public class AsistenciaS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            Profesor p = (Profesor) request.getSession().getAttribute("profesor");

            int op = Integer.parseInt(request.getParameter("op"));
            if (op == 0) {
                String pi = p.getIdProfesor();

                DirectorCursoDAO pc = new DirectorCursoDAO();
                ArrayList<DirectorCurso> pcm = pc.getAllProCur(pi);
                ArrayList<Curso> cursos = new ArrayList<>();
                CursoDAO c = new CursoDAO();
                for (DirectorCurso profesorcurso : pcm) {
                    cursos.add(c.getCursoById(profesorcurso.getIdCurso()));
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }
            if (op == 1) {
                FechaDAO dao = new FechaDAO();
                ArrayList<Fecha> fechas = dao.allFechas();
                Gson g = new Gson();
                String pasareEsto = g.toJson(fechas);
                out.print(pasareEsto);
            }

            if (op == 2) {
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                EstudianteDAO dao = new EstudianteDAO();
                ArrayList<Estudiante> estudiantes = dao.getEstudiantesByIDCurso(idCurso);

                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
            if (op == 3) {
                String idEst = request.getParameter("idEst");
                EstudianteCursoDAO ec = new EstudianteCursoDAO();
                int estCur = ec.getEstCur(idEst);
                AsistenciaDAO a = new AsistenciaDAO();
                ArrayList<Asistencia> asiste = a.getAsistenciaByEst(estCur);
                Gson g = new Gson();
                String pasareEsto = g.toJson(asiste);
                out.print(pasareEsto);
            }
            if (op == 4) {
                String idEst = request.getParameter("idEst");
                EstudianteCursoDAO ec = new EstudianteCursoDAO();
                int estCur = ec.getEstCur(idEst);
                AsistenciaDAO a = new AsistenciaDAO();
                ArrayList<Asistencia> asiste = a.getAsistenciaByEst(estCur);
                int total = 0, vino = 0;
                for (Asistencia asistencia : asiste) {
                    total++;
                    if (asistencia.getVino().equalsIgnoreCase("presente")) {
                        vino++;
                    }
                }
                String pasareEsto = "De " + total + " veces que se ha tomado asistencia el estudiante ha venido " + vino + ".<br>";
                float valor = ((float)vino / (float)total) * 100;
                valor = (float) (Math.floor(valor * 100) / 100);
                pasareEsto += "Ha venido un " + valor + " del total de clases donde se ha tomado asistencia.<br> Dado este porcentaje el sistema recomienda: <br>";
                if (valor > 90) {
                    pasareEsto +="Felicitar al estudiante pues sus asistencias superan el 90% y así motivarlo para que continue con este desempeño.";
                } else {
                    if (valor > 70) {
                        pasareEsto +="Recordarle al estudiante que es importante que venga a las clases para que pueda aprender mucho mas.";
                    } else {
                        if (valor >= 50) {
                            pasareEsto +="El estudiante se encuentra en un punto critico en cuanto a las asistencias, su desempeño se puede ver afectado por haber faltado a tantas clases";
                        } else {
                            pasareEsto +="Hablar con los padres del estudiante para encontrar el problema de la falla a mas de la mitad de las clases";
                        }
                    }
                }
                Gson g = new Gson();
                out.print(g.toJson(pasareEsto));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String[] idEstudiante = request.getParameterValues("idEstudiante[]");
            //String fecha = request.getParameter("fecha");
            String[] vino = request.getParameterValues("vino[]");

            Date d = new Date(System.currentTimeMillis());
            String je = d + "";
            String[] aux3 = je.split("-");
            String fecha = aux3[1] + "/" + aux3[2] + "/" + aux3[0];

            ArrayList<Integer> idEstudianteCurso = new ArrayList<>();

            for (int i = 0; i < idEstudiante.length; i++) {
                EstudianteCursoDAO dao = new EstudianteCursoDAO();
                int idEC = dao.getEstCur(idEstudiante[i]);
                idEstudianteCurso.add(idEC);
            }

            AsistenciaDAO dao = new AsistenciaDAO();

            boolean aux = dao.comprobarAsistencia(idEstudianteCurso.get(0), fecha);

            if (aux == false) {
                for (int i = 0; i < idEstudiante.length; i++) {
                    Asistencia asistencia = new Asistencia(idEstudianteCurso.get(i), fecha, vino[i]);
                    dao.addAsistencia(asistencia);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
