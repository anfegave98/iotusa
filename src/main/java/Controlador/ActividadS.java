/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ActividadDAO;
import Dao.CursoDAO;
import Dao.CursoMateriaDAO;
import Dao.MateriaDAO;
import Dao.TemaDAO;
import Modelo.Actividad;
import Modelo.Curso;
import Modelo.CursoMateria;
import Modelo.Materia;
import Modelo.Profesor;
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
public class ActividadS extends HttpServlet {



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
                Profesor profe=(Profesor) request.getSession().getAttribute("profesor");
                ArrayList<CursoMateria> cms = t.getAllCMProfesor(profe.getIdProfesor());
                ArrayList<ConsultaCMS> cmsCompleto=new ArrayList<>();
                for(CursoMateria cm:cms){
                    CursoDAO c=new CursoDAO();
                    Curso curso=c.getCursoById(cm.getIdCurso());
                    MateriaDAO m=new MateriaDAO();
                    Materia materia=m.getMateriaById(cm.getIdMateria());
                    String curmat=curso.getNombre()+": "+materia.getNombre();
                    ConsultaCMS c1=new ConsultaCMS(cm.getIdCM(), curmat);
                    cmsCompleto.add(c1);
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cmsCompleto);
                out.print(pasareEsto);
            }
            if(opcion==1){
                int idCM=Integer.parseInt(request.getParameter("idcm"));
                TemaDAO t = new TemaDAO();
                ArrayList<Tema> temas = t.getAllTemas(idCM);
                Gson g = new Gson();
                String pasareEsto = g.toJson(temas);
                out.print(pasareEsto);
            }
            if(opcion==2){
                int idT=Integer.parseInt(request.getParameter("tema"));
                ActividadDAO a=new ActividadDAO();
                ArrayList<Actividad> actividades=a.getAllActividades(idT);
                Gson g = new Gson();
                String pasareEsto = g.toJson(actividades);
                out.print(pasareEsto);
            }
            if(opcion==3){
                Actividad e = new Actividad();
                e.setNombre(request.getParameter("nombre"));
                e.setId(Integer.parseInt(request.getParameter("id")));
                e.setIdTema(Integer.parseInt(request.getParameter("tema2")));
                ActividadDAO o = new ActividadDAO();
                o.updateActividad(e);
                
            }
            if(opcion==4){
                int id = Integer.parseInt(request.getParameter("id"));
                ActividadDAO obs = new ActividadDAO();
                Actividad e = obs.getActividadByID(id);
                Gson g = new Gson();
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
                
            } if (opcion == 5) {
                int id = Integer.parseInt(request.getParameter("id"));
                ActividadDAO o = new ActividadDAO();
                o.deleteActividad(id);
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
            String nombre=request.getParameter("nombre");
            int idTema=Integer.parseInt(request.getParameter("tema"));
            ActividadDAO a=new ActividadDAO();
            a.addActividad(nombre, idTema);
            
        } catch (SQLException ex) {
            Logger.getLogger(ActividadS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ActividadS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActividadS.class.getName()).log(Level.SEVERE, null, ex);
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
