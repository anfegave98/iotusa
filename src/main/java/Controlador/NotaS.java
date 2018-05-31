/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.ActividadDAO;
import Dao.CursoDAO;
import Dao.NotaDAO;
import Dao.DirectorCursoDAO;
import Dao.EstudianteDAO;
import Dao.CursoMateriaDAO;
import Dao.EstudianteCursoDAO;
import Dao.MateriaDAO;
import Dao.ObservadorDAO;
import Dao.TemaDAO;
import Modelo.Actividad;
import Modelo.CursoMateria;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Nota;
import Modelo.Profesor;
import Modelo.DirectorCurso;
import Modelo.Materia;
import Modelo.Tema;
import Util.RetroalimentacionNota;
import Util.BoletinEstudiante;
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
 * @author JulDa
 */
public class NotaS extends HttpServlet {

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
            out.println("<title>Servlet NotaS</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotaS at " + request.getContextPath() + "</h1>");
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
            int opcion = Integer.parseInt(request.getParameter("opcion"));
            //lista los cursos y materias del profesor en sesion
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
            //lista los temas de las materias 
            if (opcion == 1) {
                int idCM=Integer.parseInt(request.getParameter("idcm"));
                TemaDAO t = new TemaDAO();
                ArrayList<Tema> temas = t.getAllTemas(idCM);
                Gson g = new Gson();
                String pasareEsto = g.toJson(temas);
                out.print(pasareEsto);
            }
            //lista las actividades de la materia
            if (opcion == 2) {
               int idT=Integer.parseInt(request.getParameter("tema"));
                ActividadDAO a=new ActividadDAO();
                ArrayList<Actividad> actividades=a.getAllActividades(idT);
                Gson g = new Gson();
                String pasareEsto = g.toJson(actividades);
                out.print(pasareEsto);
            }
            //lista estudiantes del curso
            if (opcion == 3){
                int idCurso = Integer.parseInt(request.getParameter("curso"));
                Profesor profe=(Profesor) request.getSession().getAttribute("profesor");
                DirectorCursoDAO directorDao = new DirectorCursoDAO();
                DirectorCurso director = directorDao.getDirector(profe.getIdProfesor());
                
                
                    EstudianteDAO dao = new EstudianteDAO();
                    
                    ArrayList<Estudiante> estudiantes = dao.getEstudiantesByIDCurso(director.getIdCurso());

                    Gson g = new Gson();
                    String pasareEsto = g.toJson(estudiantes);
                    out.print(pasareEsto);
            }
            //lista solo las notas
            if (opcion == 4){
                NotaDAO n = new NotaDAO();
                ArrayList<Nota> notas = n.getAllNotas();
                Gson g = new Gson();
                String pasareEsto = g.toJson(notas);
                out.print(pasareEsto);
            }
            //lista notas por actividad
            if (opcion==5){
                int idActividad = Integer.parseInt(request.getParameter("idActividad"));
                System.out.println("idActividad");
                NotaDAO n = new NotaDAO();
                ArrayList<Nota> notas = n.getNotaByIdActividad(idActividad);
                Gson g = new Gson();
                String pasareEsto = g.toJson(notas);
                out.print(pasareEsto);
            }
            
            //lista notas por estudiante para boletin
            if(opcion==6){
                String estBoletin=request.getParameter("estBoletin");
                NotaDAO n = new NotaDAO();
                ArrayList<BoletinEstudiante> notasBoletin= n.getNotasBoletin(estBoletin);
                Gson g = new Gson();
                String pasareEsto = g.toJson(notasBoletin);
                out.print(pasareEsto);
            }
            //metodo para ver temas para boletin
            if(opcion== 7){
                String idEst=request.getParameter("idEst");
                NotaDAO tema=new NotaDAO();
                ArrayList<BoletinEstudiante> Notas=tema.getTemasBoletin(idEst);
                Nota n=new Nota();
                Gson g = new Gson();
                out.print(g.toJson(n.getTemasBoletin(Notas)));        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaS.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
         try { 
         String[] nota = request.getParameterValues("nota[]");
         String[] idEstudiante =  request.getParameterValues("idEstudiante[]");
         int idActividad =  Integer.parseInt(request.getParameter("idActividad"));
         String[] DetallesExtra = request.getParameterValues("detallesextra[]");
        
         //System.out.println("nota"+ idEstudiante[0]+ "LLEGUE");
         
         ArrayList<Integer> idEstudianteCurso = new ArrayList<>();
         
         for(int i=1; i < idEstudiante.length;i++){
             EstudianteCursoDAO dao = new EstudianteCursoDAO();
             int idEC = dao.getEstCur(idEstudiante[i]);
             idEstudianteCurso.add(idEC);
         }
             
        
         for(int i=1; i<idEstudiante.length; i++){
             
             //Nota notita = new Nota(Integer.parseInt(nota[i]), , idActividad, "uyguggv");
            
             NotaDAO dao = new NotaDAO();
             System.out.println(idEstudianteCurso);
             dao.addNota(Integer.parseInt(nota[i]), idEstudianteCurso.get(i-1), idActividad, DetallesExtra[i]);
             
         }
         
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