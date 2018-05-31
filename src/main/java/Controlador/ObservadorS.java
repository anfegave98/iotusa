/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.CursoMateriaDAO;
import Dao.EstudianteDAO;
import Dao.ObservadorDAO;
import Dao.DirectorCursoDAO;
import Dao.EstudianteCursoDAO;
import Dao.ProfesorDAO;
import Modelo.Curso;
import Modelo.CursoMateria;
import Modelo.Estudiante;
import Modelo.Observador;
import Modelo.Profesor;
import Modelo.DirectorCurso;
import Modelo.Nota;
import Util.RetroalimentacionNota;
import Util.consultaCM;
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
 * @author FiJus
 */
public class ObservadorS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int opc = Integer.parseInt(request.getParameter("opcion"));
            if (opc == 0) {
                Profesor p = (Profesor) request.getSession().getAttribute("profesor");
                DirectorCursoDAO pc = new DirectorCursoDAO();
                ArrayList<DirectorCurso> pcm = pc.getAllProCur(p.getIdProfesor());
                ArrayList<Curso> cursos = new ArrayList<>();
                CursoDAO c = new CursoDAO();
                for (DirectorCurso profesorcurso : pcm) {
                    cursos.add(c.getCursoById(profesorcurso.getIdCurso()));
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }
            if (opc == 1) {
                int a = Integer.parseInt(request.getParameter("curso"));
                EstudianteDAO obs = new EstudianteDAO();
                ArrayList<Estudiante> estudiantes = obs.getEstudiantesByIDCurso(a);
                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
            if (opc == 2) {
                String estId = request.getParameter("estudiante");
                EstudianteCursoDAO e = new EstudianteCursoDAO();
                ObservadorDAO obs = new ObservadorDAO();
                ArrayList<Observador> observaciones = obs.getObservadorByID(e.getEstCur(estId));
                ArrayList<consultaCM> consultas = new ArrayList<>();
                for (Observador ob : observaciones) {
                    ProfesorDAO p = new ProfesorDAO();
                    String detalles="Fecha: "+ob.getFecha()+", "+ob.getDetalles();
                    Profesor profe = p.getProfesorById(ob.getIdProfesor());
                    String cal = "" + ob.getCalificacion();
                    consultaCM nuCon = new consultaCM(detalles, cal, profe.getNombre());
                    consultas.add(nuCon);
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(consultas);
                out.print(pasareEsto);
            }
            if (opc == 3) {
                Profesor p = (Profesor) request.getSession().getAttribute("profesor");
                CursoMateriaDAO cm = new CursoMateriaDAO();
                ArrayList<CursoMateria> pcm = cm.getAllCMProfesor(p.getIdProfesor());
                ArrayList<Curso> cursos = new ArrayList<>();
                CursoDAO c = new CursoDAO();
                for (CursoMateria profesorcurso : pcm) {
                    cursos.add(c.getCursoById(profesorcurso.getIdCurso()));
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }
            if(opc== 4){
                String idEst=request.getParameter("idEst");
                ObservadorDAO o=new ObservadorDAO();
                ArrayList<RetroalimentacionNota> Notas=o.getNotasById(idEst);
                ArrayList<RetroalimentacionNota> NotasMateria=o.getNotasMateriaById(idEst);
                Nota n=new Nota();
                Gson g = new Gson();
                out.print(g.toJson(n.getInfo(Notas,NotasMateria)));        
            }
            if(opc==5){
                String idEst=request.getParameter("estudiante");
                EstudianteCursoDAO ec=new EstudianteCursoDAO();
                int estCur= ec.getEstCur(idEst);
                ObservadorDAO o=new ObservadorDAO();
                ArrayList<Observador> observadores=o.getObservadorByID(estCur);
                Observador ob=new Observador();
                Gson g=new Gson();
                out.print(g.toJson(ob.getRetroalimentacion(observadores)));
                
            }
            
        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(ObservadorS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String detalles = request.getParameter("detalles");
            int calificacion = Integer.parseInt(request.getParameter("calificacion"));
            String idEst = request.getParameter("idEstudiante");
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            int idCur = Integer.parseInt(request.getParameter("idCurso"));
            EstudianteCursoDAO estcur = new EstudianteCursoDAO();
            int idEstCur = estcur.getEstCur(idEst);
            String detallesFinal = "";
            Date d = new Date(System.currentTimeMillis());
            String je = d + "";
            String[] aux3 = je.split("-");
            String fechaObservacion =  aux3[1]+ "/" + aux3[2] + "/" + aux3[0];
           
            if (tipo == 0) {
                detallesFinal += "Director: " + detalles;
            } else {
                detallesFinal += "Profesor: " + detalles;
            }
            Profesor p = (Profesor) request.getSession().getAttribute("profesor");
            ObservadorDAO o = new ObservadorDAO();
            o.addObservador(detallesFinal, calificacion, idEstCur, p.getIdProfesor(), fechaObservacion);

        } catch (SQLException ex) {
            Logger.getLogger(ObservadorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ObservadorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObservadorS.class.getName()).log(Level.SEVERE, null, ex);
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
