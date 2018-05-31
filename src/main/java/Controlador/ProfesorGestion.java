/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ActividadDAO;
import Dao.AsistenciaDAO;
import Dao.CursoDAO;
import Dao.CursoMateriaDAO;
import Dao.EstudianteDAO;
import Dao.DirectorCursoDAO;
import Dao.ObservadorDAO;
import Dao.ProfesorDAO;
import Modelo.Actividad;
import Modelo.Curso;
import Modelo.CursoMateria;
import Modelo.Estudiante;
import Modelo.Profesor;
import Modelo.DirectorCurso;
import Modelo.Nota;
import Util.ProfesorMateria;
import Util.RetroalimentacionNota;
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
 * @author anfeg
 */
public class ProfesorGestion extends HttpServlet {

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
            out.println("<title>Servlet ProfesorGestion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfesorGestion at " + request.getContextPath() + "</h1>");
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
                String cedula = request.getParameter("cedula");
                System.out.println(cedula + "cedula");
                ProfesorDAO o = new ProfesorDAO();
                o.eliminarProfesor(cedula);
            }
            if (opc == 1) {
                String estId = request.getParameter("cedula");
                ProfesorDAO obs = new ProfesorDAO();
                Profesor e = obs.getProfesorById(estId);
                Gson g = new Gson();
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            if (opc == 2) {
                String cedula = request.getParameter("cedula");
                String nombre = request.getParameter("nombre");
                String correo = request.getParameter("correo");
                String celular = request.getParameter("celular");
                String direccion = request.getParameter("direccion");
                String experiencia = request.getParameter("experiencia");
                String fechaNacimiento = request.getParameter("fechanacimiento");
                String tipoSangre = request.getParameter("tiposangre");
                String usuario = request.getParameter("usuario");
                ProfesorDAO p = new ProfesorDAO();
                Profesor profe = new Profesor(cedula, nombre, correo, celular, direccion, experiencia, fechaNacimiento, tipoSangre, usuario);
                System.out.println(profe);
                p.updateProfesor(profe);
            }
            if (opc == 3) {
                Profesor p = (Profesor) request.getSession().getAttribute("profesor");
                Date d = new Date(System.currentTimeMillis());
                String je = d + "";
                String[] aux3 = je.split("-");
                String fecha = aux3[1] + "/" + aux3[2] + "/" + aux3[0];
                AsistenciaDAO a = new AsistenciaDAO();
                ArrayList<Estudiante> c = a.getAsistenciaTomada(p.getIdProfesor(), fecha);
                String pasareEsto = ".";
                if (c.isEmpty()) {
                    pasareEsto += "No ha realizado la asistencia hoy";
                } else {
                    pasareEsto += "Ya realizo la asistencia";
                }
                Gson g = new Gson();
                out.print(g.toJson(pasareEsto));
            }
            if (opc == 4) {
                Profesor p = (Profesor) request.getSession().getAttribute("profesor");
                CursoMateriaDAO o = new CursoMateriaDAO();
                ArrayList<ProfesorMateria> cursos = o.getAllDicto(p.getIdProfesor());
                Gson g = new Gson();
                String pasareEsto = g.toJson(cursos);
                out.print(pasareEsto);
            }
            if (opc == 5) {
                Profesor p = (Profesor) request.getSession().getAttribute("profesor");
                ActividadDAO o = new ActividadDAO();
                ArrayList<Actividad> con = o.getAllActividadesConNota(p.getIdProfesor());
                ArrayList<Actividad> todo = o.getAllActividadesProfesor(p.getIdProfesor());
                ArrayList<Actividad> fin = new ArrayList();
                if (con.isEmpty()) {
                    for (int i = 0; i < todo.size(); i++) {
                        fin.add(todo.get(i));
                    }
                } else {
                    for (int i = 0; i < todo.size(); i++) {
                        for (int j = 0; j < con.size(); j++) {
                            if (todo.get(i).getId() == con.get(j).getId()) {
                                todo.remove(i);

                            }
                        }

                    }
                    for (int i = 0; i < todo.size(); i++) {
                        fin.add(todo.get(i));

                    }

                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(fin);
                out.print(pasareEsto);
            }
            if (opc == 6) {
                EstudianteDAO o = new EstudianteDAO();
                ArrayList<Estudiante> e = o.getEstudiantesNoAsignados();
                Gson g = new Gson();
                String pasareEsto = g.toJson(e);
                out.print(pasareEsto);
            }
            if (opc == 7) {
           
                ProfesorDAO o = new ProfesorDAO();
                ArrayList<Profesor> con = o.getallProfesoresConMateria();
                ArrayList<Profesor> todo = o.getallProfesoresTodos();
                ArrayList<Profesor> fin = new ArrayList();
                if (con.isEmpty()) {
                    for (int i = 0; i < todo.size(); i++) {
                        fin.add(todo.get(i));
                    }
                } else {
                    for (int i = 0; i < todo.size(); i++) {
                        long aux = Long.parseLong(todo.get(i).getIdProfesor());
                        int cont=0;
                        for (int j = 0; j < con.size(); j++) {
                            long aux2 = Long.parseLong(con.get(j).getIdProfesor());
                            if (aux== aux2) {
                                cont++;

                            }
                        }
                        if(cont==0){
                            fin.add(todo.get(i));
                        }

                    }

                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(fin);
                out.print(pasareEsto);
            }
            if (opc == 8) {                
                CursoMateriaDAO o = new CursoMateriaDAO();
                ArrayList<CursoMateria> con = o.getAllConTema();
                ArrayList<CursoMateria> todo = o.getAllTodos();
                ArrayList<CursoMateria> fin = new ArrayList();
                if (con.isEmpty()) {
                    for (int i = 0; i < todo.size(); i++) {
                        fin.add(todo.get(i));
                    }
                } else {
                    for (int i = 0; i < todo.size(); i++) {
                        for (int j = 0; j < con.size(); j++) {
                            if (todo.get(i).getIdCM()== con.get(j).getIdCM()) {
                                todo.remove(i);

                            }
                        }

                    }
                    for (int i = 0; i < todo.size(); i++) {
                        fin.add(todo.get(i));

                    }

                }
                Gson g = new Gson();
                String pasareEsto = g.toJson(fin);
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
        processRequest(request, response);
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
