/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.DirectorCursoDAO;
import Dao.ProfesorDAO;
import Modelo.Profesor;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
public class ProfesorS extends HttpServlet {

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
            out.println("<title>Servlet ProfesorS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfesorS at " + request.getContextPath() + "</h1>");
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
            Profesor p = (Profesor) request.getSession().getAttribute("profesor");
            String cedula = p.getIdProfesor();
            ProfesorDAO pc = new ProfesorDAO();
            Profesor pcm = pc.getProfesorById(cedula);
            Gson g = new Gson();
            String pasareEsto = g.toJson(p);
            out.print(pasareEsto); 

        } catch (SQLException ex) {
            Logger.getLogger(ProfesorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProfesorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorS.class.getName()).log(Level.SEVERE, null, ex);
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
            String cedula = request.getParameter("cedula");
            String nombre = request.getParameter("nombre");
            int tipoU = Integer.parseInt(request.getParameter("tipoU"));
            String correo = request.getParameter("correo");
            String celular = request.getParameter("celular");
            String direccion = request.getParameter("direccion");
            String experiencia = request.getParameter("experiencia");
            String fechaNacimiento = request.getParameter("fechanacimiento");
            String tipoSangre = request.getParameter("tiposangre");
            String usuario = request.getParameter("usuario");
            String contra = request.getParameter("contra");
            String[] aux = fechaNacimiento.split(" ");
            String aux2 = aux[0];
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(contra.getBytes(StandardCharsets.UTF_8));
            String ps2 = bytesToHex(encodedhash);
            ProfesorDAO p = new ProfesorDAO();
            Profesor profe = new Profesor(cedula, nombre, tipoU, correo, celular, direccion, experiencia, aux2, tipoSangre, usuario, ps2);
            p.addProfesor(profe);
            if (!request.getParameter("curso").equals("")) {
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                Date d = new Date(System.currentTimeMillis());
                String je = d + "";
                String[] aux3 = je.split("-");
                String fechaCurso = aux3[2] + "/" + aux3[1] + "/" + aux3[0];
                DirectorCursoDAO dc = new DirectorCursoDAO();
                if (dc.knowCedula(cedula) && dc.knowCurso(idCurso)) {
                    dc.addDirectorCurso(cedula, idCurso, fechaCurso, "");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProfesorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfesorS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ProfesorS.class.getName()).log(Level.SEVERE, null, ex);
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

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
