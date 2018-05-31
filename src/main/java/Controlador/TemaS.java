/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.CursoMateriaDAO;
import Dao.MateriaDAO;
import Dao.TemaDAO;
import Modelo.Curso;
import Modelo.CursoMateria;
import Modelo.Materia;
import Modelo.Tema;
import Util.ConsultaCMS;
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
 * @author FiJus
 */
public class TemaS extends HttpServlet {

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
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            if (opcion == 0) {
                CursoMateriaDAO t = new CursoMateriaDAO();
                ArrayList<CursoMateria> cms = t.getAllCM();
                ArrayList<ConsultaCMS> cmsCompleto = new ArrayList<>();
                for (CursoMateria cm : cms) {
                    CursoDAO c = new CursoDAO();
                    Curso curso = c.getCursoById(cm.getIdCurso());
                    MateriaDAO m = new MateriaDAO();
                    Materia materia = m.getMateriaById(cm.getIdMateria());
                    String curmat = curso.getNombre() + ": " + materia.getNombre();
                    ConsultaCMS c1 = new ConsultaCMS(cm.getIdCM(), curmat);
                    cmsCompleto.add(c1);
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cmsCompleto);
                out.print(pasareEsto);
            }
            if (opcion == 2) {
                int idCM = Integer.parseInt(request.getParameter("idcm"));
                TemaDAO t = new TemaDAO();
                ArrayList<Tema> temas = t.getAllTemas(idCM);
                Gson g = new Gson();
                String pasareEsto = g.toJson(temas);
                out.print(pasareEsto);
            }
            if(opcion == 3){
                int idTema=Integer.parseInt(request.getParameter("idTema"));
                TemaDAO t=new TemaDAO();
                Tema tema=t.getTemaById(idTema);
                Gson g = new Gson();
                String pasareEsto = g.toJson(tema);
                out.print(pasareEsto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TemaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(TemaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TemaS.class.getName()).log(Level.SEVERE, null, ex);
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
            String opcion = request.getParameter("opcion");
            System.out.println("holaaaaaaaa ayudaaaa");
            if (opcion.equals("crear")) {
                
                int idCM = Integer.parseInt(request.getParameter("idcm"));
                String nombre = request.getParameter("nombre");
                if (!nombre.equals("")) {
                    TemaDAO t = new TemaDAO();
                    t.addTema(idCM, nombre);
                }
            }
            if (opcion.equals("eliminar")) {
                int idTema = Integer.parseInt(request.getParameter("idTema"));
                TemaDAO t = new TemaDAO();
                t.eliminarTema(idTema);
            }
            if (opcion.equals("editar")){
                int idCM = Integer.parseInt(request.getParameter("idcm"));
                int idTema=Integer.parseInt(request.getParameter("idTema"));
                String nombre = request.getParameter("nombre");
                if (!nombre.equals("")) {
                    TemaDAO t = new TemaDAO();
                    Tema tema=new Tema(idTema, nombre, idCM);
                    t.updateTema(tema);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TemaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(TemaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TemaS.class.getName()).log(Level.SEVERE, null, ex);
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
