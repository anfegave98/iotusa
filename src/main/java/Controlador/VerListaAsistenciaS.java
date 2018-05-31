/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.AsistenciaDAO;
import Dao.CursoDAO;
import Dao.FechaDAO;
import Dao.ObservadorDAO;
import Dao.DirectorCursoDAO;
import Dao.EstudianteDAO;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Fecha;
import Modelo.Observador;
import Modelo.Profesor;
import Modelo.DirectorCurso;
import Util.ConsultaAsistencia;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
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
public class VerListaAsistenciaS extends HttpServlet {

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
                Profesor p=(Profesor)request.getSession().getAttribute("profesor");
                DirectorCursoDAO pc = new DirectorCursoDAO();
                ArrayList<DirectorCurso> pcm = pc.getAllProCur(p.getIdProfesor());
                ArrayList<Curso> cursos=new ArrayList<>();
                CursoDAO c=new CursoDAO();
                for (DirectorCurso profesorcurso : pcm) {                  
                    cursos.add(c.getCursoById(profesorcurso.getIdCurso()));
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }
            if (opc == 1) {
               
                FechaDAO obs = new FechaDAO();
                ArrayList<Fecha> f = obs.allFechas();
                Gson g = new Gson();
                String pasareEsto = g.toJson(f);
                out.print(pasareEsto);
            }
            if (opc == 2) {
                int curso = Integer.parseInt(request.getParameter("curso"));
                String fecha = request.getParameter("fecha");
                String[] fechaAux = fecha.split(" ");
                AsistenciaDAO obs = new AsistenciaDAO();
                System.out.println(curso+ "   "+ fechaAux[0]);
                ArrayList<ConsultaAsistencia> l = obs.getAsistenciaFecha(curso,fechaAux[0]);
                Gson g = new Gson();
                String pasareEsto = g.toJson(l);
                out.print(pasareEsto);
            }
            if(opc == 3){
                int a = Integer.parseInt(request.getParameter("curso"));
                EstudianteDAO obs = new EstudianteDAO();
                ArrayList<Estudiante> estudiantes = obs.getEstudiantesByIDCurso(a);
                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
            if (opc == 4) {
                int curso = Integer.parseInt(request.getParameter("curso"));
                String nombre = request.getParameter("nombre");
                AsistenciaDAO obs = new AsistenciaDAO();
                ArrayList<ConsultaAsistencia> l = obs.getAsistenciaEstudiante(curso,nombre);
                Gson g = new Gson();
                String pasareEsto = g.toJson(l);
                out.print(pasareEsto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VerListaAsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(VerListaAsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VerListaAsistenciaS.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
    }
}
