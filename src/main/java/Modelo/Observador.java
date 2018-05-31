/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Dao.ProfesorDAO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author LabingXEON
 */
public class Observador {

    private int idObs;
    private int calificacion;
    private String detalles;
    private int idEstudianteCurso;
    private String idProfesor;
    private String fecha;

    public Observador() {
    }

    public Observador(int idObs, int calificacion, String detalles, int idEstudianteCurso, String idProfesor, String fecha) {
        this.idObs = idObs;
        this.calificacion = calificacion;
        this.detalles = detalles;
        this.idEstudianteCurso = idEstudianteCurso;
        this.idProfesor = idProfesor;
        this.fecha = fecha;
    }

    public Observador(int idObs, int calificacion, String detalles, int idEstudianteCurso, String idProfesor) {
        this.idObs = idObs;
        this.calificacion = calificacion;
        this.detalles = detalles;
        this.idEstudianteCurso = idEstudianteCurso;
        this.idProfesor = idProfesor;
    }

    public int getIdObs() {
        return idObs;
    }

    public void setIdObs(int idObs) {
        this.idObs = idObs;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(int idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    static String mayorProfe(TreeMap<String, Integer> map, ArrayList<Observador> observadores) {
        String mayorProfe = "";
        int mayorVeces = 0;
        for (Observador ob : observadores) {
            if (mayorProfe.equals("")) {
                mayorProfe = ob.getIdProfesor();
                mayorVeces = map.get(ob.getIdProfesor());
            } else {
                if (mayorVeces < map.get(ob.getIdProfesor())) {
                    mayorProfe = ob.getIdProfesor();
                    mayorVeces = map.get(ob.getIdProfesor());
                }
            }
        }
        return mayorProfe;
    }
    
    static int mayorCalificaci(TreeMap<Integer, Integer> map, ArrayList<Observador> observadores) {
        int mayorCalificacion = 0;
        int mayorVeces = 0;
        for (Observador ob : observadores) {
            if (mayorCalificacion==0) {
                mayorCalificacion = ob.getCalificacion();
                mayorVeces = map.get(ob.getCalificacion());
            } else {
                if (mayorVeces < map.get(ob.getCalificacion())) {
                    mayorCalificacion = ob.getCalificacion();
                    mayorVeces = map.get(ob.getCalificacion());
                }
            }
        }
        return mayorCalificacion;
    }

    public String getRetroalimentacion(ArrayList<Observador> observadores) throws SQLException, URISyntaxException, ClassNotFoundException, IOException {
        float total = 0, acumulador = 0;
        String d5 = "", d4 = "", d3 = "", d2 = "", d1 = "";
        TreeMap<String, Integer> tm = new TreeMap<>();
        TreeMap<Integer, Integer> tmCalificacion = new TreeMap<>();
        for (Observador ob : observadores) {
            total++;
            acumulador += ob.getCalificacion();
            if (!tm.containsKey(ob.getIdProfesor())) {
                tm.put(ob.getIdProfesor(), 1);
            } else {
                int valor = tm.get(ob.getIdProfesor())+1;
                tm.replace(ob.getIdProfesor(), valor);
            }
            if (!tmCalificacion.containsKey(ob.getCalificacion())) {
                tmCalificacion.put(ob.getCalificacion(), 1);
            } else {
                int valor = tmCalificacion.get(ob.getCalificacion())+1;
                tmCalificacion.replace(ob.getCalificacion(), valor);
            }
            switch (ob.getCalificacion()) {
                case 1:
                    d1 += ob.getDetalles() + "<br>";
                    break;
                case 2:
                    d2 += ob.getDetalles() + "<br>";
                    break;
                case 3:
                    d3 += ob.getDetalles() + "<br>";
                    break;
                case 4:
                    d4 += ob.getDetalles() + "<br>";
                    break;
                case 5:
                    d5 += ob.getDetalles() + "<br>";
                    break;
                default:
                    break;
            }
        }
        String mayorProfe=mayorProfe(tm, observadores);
        ProfesorDAO p=new ProfesorDAO();
        Profesor profe=p.getProfesorById(mayorProfe);
        int mayorCalificacion=mayorCalificaci(tmCalificacion, observadores);
        String pasareEsto="El profesor que mas observaciones ha hecho es "+ profe.getNombre()+"<br>";
        pasareEsto+="La calificación mas recurrente es "+ mayorCalificacion+"<br>";
        if(mayorCalificacion==5){
            pasareEsto+="El sistema recomienda felicitar al estudiante";
        }
        if(mayorCalificacion==4){
            pasareEsto+="El estudiante presenta un buen promedio de calificación en las calificaciones";
        }
        if(mayorCalificacion==3){
            pasareEsto+="Revisar las calificaciones de 1 y 5 dado que estas pueden ser clave para observar y calificar de "
                    + "mejor manera el comportamiento del estudiante";
        }
        if(mayorCalificacion==2){
            pasareEsto+="Hablar con el estudiante y sentarse a leer las observaciones puede ser una buena forma de realizar"
                    + "una correción oportuna sobre algunos comportamientos que el estudiante tiene";
        }
        if(mayorCalificacion==1){
            pasareEsto+="El sistema recomienda observar cual es el profesor que mas observaciones le hace al estudiante y "
                    + "mirar si este tiene relación con la calificación recurrente de 1.";
        }
        
                
                pasareEsto+= "<br>En promedio la calificacion que saca dada por los profesores es :"+acumulador/total+"<br>"
                + "Estos son los detalles de las observaciones hechas<br>";
        if(!d1.equals("")){
            pasareEsto+="De las calificaciones de 1 son:<br>"+d1;
        }
        if(!d2.equals("")){
            pasareEsto+="De las calificaciones de 2 son:<br>"+d2;
        }
        if(!d3.equals("")){
            pasareEsto+="De las calificaciones de 3 son:<br>"+d3;
        }
        if(!d4.equals("")){
            pasareEsto+="De las calificaciones de 4 son:<br>"+d4;
        }
        if(!d5.equals("")){
            pasareEsto+="De las calificaciones de 5 son:<br>"+d5;
        }
        return pasareEsto;
    }

}
