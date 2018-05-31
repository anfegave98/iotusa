/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.CursoDAO;
import Dao.EstudianteDAO;
import Dao.ObservadorDAO;
import Dao.DirectorCursoDAO;
import Dao.EstudianteCursoDAO;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Observador;
import Modelo.Profesor;
import Modelo.DirectorCurso;
import Modelo.EstudianteCurso;
import com.google.gson.Gson;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
 * @author anfeg
 */
public class EstudianteS extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudianteS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EstudianteS at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            //obtener los estudiantes dado un curso
            if (opc == 1) {
                int a = Integer.parseInt(request.getParameter("curso"));
                EstudianteDAO obs = new EstudianteDAO();
                ArrayList<Estudiante> estudiantes = obs.getEstudiantesByIDCurso(a);
                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
            //buscar info de un estudiante dado un id
            if (opc == 2) {
                String estId = request.getParameter("estudiante");
                EstudianteDAO obs = new EstudianteDAO();
                Estudiante e = obs.getEstudianteByID(estId);
                Gson g = new Gson();
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            //eliminar estudiante dado un documento
            if (opc == 3) {
                String documento = request.getParameter("documento");
                EstudianteDAO o = new EstudianteDAO();
                o.eliminarEstudiante(documento);
            }
            if (opc == 4) {
                String estId = request.getParameter("documento");
                EstudianteDAO obs = new EstudianteDAO();
                Estudiante e = obs.getEstudianteByID(estId);
                Gson g = new Gson();
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            if (opc == 5) {
                Estudiante e = new Estudiante();
                e.setNombre(request.getParameter("nombre"));
                e.setIdEstudiante(request.getParameter("documento"));
                e.setFechaNacimiento(request.getParameter("fechanacimiento"));
                e.setCelularContacto(request.getParameter("celularcontacto"));
                e.setDireccion(request.getParameter("direccion"));
                e.setTipoSangre(request.getParameter("tiposangre"));
                EstudianteDAO o = new EstudianteDAO();
                o.updateEstudiante(e);
            }
            if (opc == 6) {
                EstudianteDAO e = new EstudianteDAO();
                ArrayList<Estudiante> estudiantes = e.getAllEstudiantes();
                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
            if (opc == 7) {
                EstudianteDAO e = new EstudianteDAO();
                ArrayList<Estudiante> estudiantes = e.getAllEstudiantesSinUbicar();
                Gson g = new Gson();
                String pasareEsto = g.toJson(estudiantes);
                out.print(pasareEsto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
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
            Estudiante e = new Estudiante();
            String fecha = request.getParameter("fechanacimiento");
            String[] aux = fecha.split(" ");
            e.setNombre(request.getParameter("nombre"));
            e.setIdEstudiante(request.getParameter("documento"));
            e.setFechaNacimiento(aux[0]);
            e.setCelularContacto(request.getParameter("celularcontacto"));
            e.setDireccion(request.getParameter("direccion"));
            e.setTipoSangre(request.getParameter("tiposangre"));
            EstudianteDAO o = new EstudianteDAO();
            e.setIdCurso(3);
            o.addEstudiante(e);
            if (!request.getParameter("curso").equals("")) {
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                Date d=new Date(System.currentTimeMillis());
                String je=d+"";
                String[] aux2=je.split("-");
                String fechaCurso=aux2[2]+"/"+aux2[1]+"/"+aux2[0];
                CursoDAO daoC = new CursoDAO();
                daoC.updateNumeroEstudiantesCurso(idCurso);
                o.updateCursoEstudiante(e.getIdEstudiante(), idCurso);
                EstudianteCursoDAO ec = new EstudianteCursoDAO();
                EstudianteCurso st = new EstudianteCurso(0, e.getIdEstudiante(), idCurso, fechaCurso, "");
                ec.addEstCur(st);
                
            } 
            

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstudianteS.class.getName()).log(Level.SEVERE, null, ex);
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
