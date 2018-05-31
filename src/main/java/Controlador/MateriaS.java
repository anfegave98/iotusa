/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Curso;
import Dao.CursoDAO;
import Dao.MateriaDAO;
import Modelo.Materia;
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
public class MateriaS extends HttpServlet {

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
            
            int opc = Integer.parseInt(request.getParameter("opcion"));
            if (opc == 0) {
            MateriaDAO dao = new MateriaDAO();
            ArrayList<Materia> materias = dao.getAllMaterias();
            Gson g = new Gson();
            String pasareEsto = g.toJson(materias);
            out.print(pasareEsto);
            }
            if(opc==1){
                int id = Integer.parseInt(request.getParameter("id"));
                MateriaDAO obs = new MateriaDAO();
                Materia e = obs.getMateriaById(id);
                Gson g = new Gson();
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
                
            }
            if(opc==2){
                Materia e = new Materia();
                e.setNombre(request.getParameter("materia"));
                e.setIdMateria(Integer.parseInt(request.getParameter("id")));
                MateriaDAO o = new MateriaDAO();
                o.updateMateria(e);
                
            }
             if (opc == 3) {
                int id = Integer.parseInt(request.getParameter("id"));
                MateriaDAO o = new MateriaDAO();
                o.eliminarMateria(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MateriaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MateriaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MateriaS.class.getName()).log(Level.SEVERE, null, ex);
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
            String nombreMateria = request.getParameter("nombreMateria");

            MateriaDAO dao = new MateriaDAO();
            dao.addMateria(nombreMateria);

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
