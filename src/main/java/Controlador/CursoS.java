/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Curso;
import Dao.CursoDAO;
import Dao.EstudianteDAO;
import Modelo.Estudiante;
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
public class CursoS extends HttpServlet {

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int op = Integer.parseInt(request.getParameter("op"));

            if (op == 0) {
                CursoDAO dao = new CursoDAO();
                ArrayList<Curso> cursos = dao.getAllCursos();
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }

            if (op == 1) {
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                EstudianteDAO dao = new EstudianteDAO();
                ArrayList<Estudiante> estudiantes = dao.getEstudiantesByIDCurso(idCurso);
                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
            if (op == 2) {
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                CursoDAO dao = new CursoDAO();
                dao.deleteCurso(idCurso);

            }
            if (op == 3) {
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                CursoDAO dao = new CursoDAO();
                Curso curso = dao.getCursoById(idCurso);
                Gson g = new Gson();
                String pasareEsto = g.toJson(curso);
                out.print(pasareEsto);

            }
            if (op == 4) {
                Curso e = new Curso();
                e.setIdCurso(Integer.parseInt(request.getParameter("idCurso")));
                e.setNombre(request.getParameter("nombre"));
                CursoDAO o = new CursoDAO();
                o.updateCurso(e);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CursoS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoS.class.getName()).log(Level.SEVERE, null, ex);
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombreCurso = request.getParameter("nombreCurso");
            Curso curso = new Curso(0, nombreCurso, 0);
            CursoDAO dao = new CursoDAO();
            dao.addCurso(curso);

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
