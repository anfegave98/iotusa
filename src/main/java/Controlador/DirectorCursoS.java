/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.DirectorCursoDAO;
import Dao.ProfesorDAO;
import Modelo.Curso;
import Modelo.DirectorCurso;
import Modelo.Profesor;
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
public class DirectorCursoS extends HttpServlet {

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
            int opc = Integer.parseInt(request.getParameter("opc"));
            if (opc == 0) {
                ProfesorDAO p = new ProfesorDAO();
                ArrayList<Profesor> profesores = p.getallProfesores();
                ArrayList<Profesor> profesoresapasar = new ArrayList<>();
                DirectorCursoDAO c = new DirectorCursoDAO();
                for (Profesor profe : profesores) {
                    if (c.knowCedula(profe.getIdProfesor())) {
                        profesoresapasar.add(profe);
                    }
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(profesoresapasar);
                out.print(pasareEsto);
            }
            if (opc == 1) {
                CursoDAO c = new CursoDAO();
                ArrayList<Curso> cursos = c.getAllCursos();
                ArrayList<Curso> cursosapasar = new ArrayList<>();
                DirectorCursoDAO d = new DirectorCursoDAO();
                for (Curso cur : cursos) {
                    if (d.knowCurso(cur.getIdCurso())) {
                        cursosapasar.add(cur);
                    }
                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursosapasar);
                out.print(pasareEsto);
            }
            if (opc == 3) {
                DirectorCursoDAO d = new DirectorCursoDAO();
                ArrayList<DirectorCurso> directores = d.getAllDirectoresCur();
                Gson g = new Gson();
                String pasareEsto = g.toJson(directores);
                out.print(pasareEsto);

            }
            if (opc == 4) {
                String cedula = request.getParameter("cedula");
                System.out.println(cedula + "   sdfsdfsdfsdfsd   ");
                DirectorCursoDAO dao = new DirectorCursoDAO();
                DirectorCurso d = dao.getDirector(cedula);
                System.out.println(d.getCedula() + " " + d.getNombre());
                Gson g = new Gson();
                String pasareEsto = g.toJson(d);
                out.print(pasareEsto);

            }

            if (opc == 5) {
                CursoDAO dao = new CursoDAO();
                ArrayList<Curso> cursos = dao.getAllCursos();
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }

        } catch (SQLException | URISyntaxException | ClassNotFoundException ex) {
            Logger.getLogger(DirectorCursoS.class.getName()).log(Level.SEVERE, null, ex);
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
            Profesor p = (Profesor) request.getSession().getAttribute("profesor");
            int opc = Integer.parseInt(request.getParameter("opc"));
            if (opc == 1) {
                String cedula = request.getParameter("cedula");
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                String fechaInicio = request.getParameter("fechaInicio");
                DirectorCursoDAO d = new DirectorCursoDAO();
                String[] aux = fechaInicio.split(" ");
                if (d.knowCedula(cedula) && d.knowCurso(idCurso)) {
                    d.addDirectorCurso(cedula, idCurso, aux[0], "");
                }
            }
            if(opc==2){
                String cedula = request.getParameter("cedula");
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                DirectorCursoDAO dao = new DirectorCursoDAO();
                dao.updateCursoDelDirector(cedula, idCurso);
                       
            }
            if(opc==3){
                String cedula = request.getParameter("cedula");
                DirectorCursoDAO dao = new DirectorCursoDAO();
                DirectorCurso directorCurso = dao.getDirector(cedula);
                dao.deleteDirectorCurso(directorCurso.getCedula());
            }

        } catch (SQLException ex) {
            Logger.getLogger(DirectorCursoS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(DirectorCursoS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DirectorCursoS.class.getName()).log(Level.SEVERE, null, ex);
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
