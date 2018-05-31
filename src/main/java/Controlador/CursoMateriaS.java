/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.CursoMateriaDAO;
import Dao.DirectorCursoDAO;
import Dao.MateriaDAO;
import Dao.ProfesorDAO;
import Modelo.Curso;
import Modelo.CursoMateria;
import Modelo.Materia;
import Modelo.Profesor;
import Util.ConsultaCMS;
import Util.ConsultaEspecial;
import Util.consultaCM;
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
public class CursoMateriaS extends HttpServlet {

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
                CursoMateriaDAO cmd = new CursoMateriaDAO();
                ArrayList<CursoMateria> cumas = cmd.getAllCM();
                ArrayList<consultaCM> consulta = new ArrayList();
                for (CursoMateria cm : cumas) {
                    CursoDAO c = new CursoDAO();
                    Curso curso = c.getCursoById(cm.getIdCurso());
                    MateriaDAO m = new MateriaDAO();
                    Materia materia = m.getMateriaById(cm.getIdMateria());
                    ProfesorDAO p = new ProfesorDAO();
                    Profesor profesor = p.getProfesorById(cm.getIdProfesor());
                    consultaCM c1 = new consultaCM(curso.getNombre(), materia.getNombre(), profesor.getNombre());
                    consulta.add(c1);
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(consulta);
                out.print(pasareEsto);
            }
            if (opc == 1) {
                int var = Integer.parseInt(request.getParameter("var"));
                //curso
                if (var == 0) {
                    CursoDAO c = new CursoDAO();
                    ArrayList<Curso> cursos = c.getAllCursos();
                    Gson g = new Gson();
                    String pasareEsto = g.toJson(cursos);
                    out.print(pasareEsto);
                }
                //materia}
                if (var == 1) {
                    MateriaDAO m = new MateriaDAO();
                    ArrayList<Materia> materias = m.getAllMaterias();
                    Gson g = new Gson();
                    String pasareEsto = g.toJson(materias);
                    out.print(pasareEsto);
                }
                //profesor
                if (var == 2) {
                    ProfesorDAO p = new ProfesorDAO();
                    ArrayList<Profesor> profesores = p.getallProfesores();
                    Gson g = new Gson();
                    String pasareEsto = g.toJson(profesores);
                    out.print(pasareEsto);
                }
            }
            if (opc == 2) {
                CursoMateriaDAO cmd = new CursoMateriaDAO();
                ArrayList<CursoMateria> cumas = cmd.getAllCM();
                ArrayList<ConsultaEspecial> consulta = new ArrayList();
                for (CursoMateria cm : cumas) {
                    CursoDAO c = new CursoDAO();
                    Curso curso = c.getCursoById(cm.getIdCurso());
                    MateriaDAO m = new MateriaDAO();
                    Materia materia = m.getMateriaById(cm.getIdMateria());
                    ProfesorDAO p = new ProfesorDAO();
                    Profesor profesor = p.getProfesorById(cm.getIdProfesor());
                    String completo = curso.getNombre() + ": " + materia.getNombre();
                    ConsultaEspecial c1 = new ConsultaEspecial(cm.getIdCM(), completo, profesor.getNombre());
                    consulta.add(c1);
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(consulta);
                out.print(pasareEsto);
            }
            if(opc==3){
                CursoMateriaDAO cmd=new CursoMateriaDAO();
                int idP=Integer.parseInt(request.getParameter("idcm"));
                String nombre=cmd.getProfesorById(idP);
                Gson g = new Gson();
                String pasareEsto = g.toJson(nombre);
                out.print(pasareEsto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoMateriaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CursoMateriaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoMateriaS.class.getName()).log(Level.SEVERE, null, ex);
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
            if (opcion.equals("crear")) {
                int idC = Integer.parseInt(request.getParameter("curso"));
                int idM = Integer.parseInt(request.getParameter("materia"));
                String idP = request.getParameter("profesor");
                String fechaInicio = request.getParameter("fechainicio");
                String[] fechaaux = fechaInicio.split(" ");
                CursoMateriaDAO cmd = new CursoMateriaDAO();
                cmd.addCM(idC, idM, idP, fechaaux[0], null);
            } else {
                int id = Integer.parseInt(request.getParameter("curso"));
                CursoMateriaDAO c = new CursoMateriaDAO();
                if (opcion.equals("editar")) {
                    String documento=request.getParameter("documento");
                    c.updateCursoMateria(documento, id);
                }
                if (opcion.equals("eliminar")) {
                    c.eliminarCursoMateria(id);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CursoMateriaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CursoMateriaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CursoMateriaS.class.getName()).log(Level.SEVERE, null, ex);
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
