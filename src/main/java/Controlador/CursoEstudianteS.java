/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.EstudianteCursoDAO;
import Dao.EstudianteDAO;
import Modelo.Estudiante;
import Modelo.EstudianteCurso;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.sql.SQLException;
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
public class CursoEstudianteS extends HttpServlet {

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
            String opcion = request.getParameter("opcion");
            if (opcion.equals("crear")) {
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                String idEstudiante = request.getParameter("estudiante");
                String fecha = request.getParameter("fecha");
                String[] fechaAux = fecha.split(" ");
                EstudianteDAO dao = new EstudianteDAO();
                if (dao.estGotCur(idEstudiante)) {
                    CursoDAO daoC = new CursoDAO();
                    daoC.updateNumeroEstudiantesCurso(idCurso);
                    dao.updateCursoEstudiante(idEstudiante, idCurso);
                    EstudianteCursoDAO e = new EstudianteCursoDAO();
                    EstudianteCurso st = new EstudianteCurso(0, idEstudiante, idCurso, fechaAux[0], "");
                    e.addEstCur(st);
                }
            } else {
                String documento = request.getParameter("documento");
                int curso = Integer.parseInt(request.getParameter("curso"));
                EstudianteCursoDAO ec = new EstudianteCursoDAO();
                EstudianteDAO e=new EstudianteDAO();
                if (opcion.equals("editar")) {
                    ec.updateEstCur(curso,documento);
                    e.updateCursoEstudiante(documento,curso);
                }
                if (opcion.equals("eliminar")) {
                    ec.deleteEstCur(documento);
                    curso=3;
                    e.updateCursoEstudiante(documento,curso);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoEstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CursoEstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoEstudianteS.class.getName()).log(Level.SEVERE, null, ex);
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
