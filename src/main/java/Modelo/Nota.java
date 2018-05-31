/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Util.BoletinEstudiante;
import Util.RetroalimentacionNota;
import java.util.ArrayList;

/**
 *
 * @author FiJus
 */
public class Nota {

    private float nota;
    private int idEstudianteCurso;
    private int idActividad;
    private String nombre;
    private String detallesExtra;

    public Nota() {
    }

    public Nota(float nota, int idEstudianteCurso, int idActividad, String detallesExtra) {
        this.nota = nota;
        this.idEstudianteCurso = idEstudianteCurso;
        this.idActividad = idActividad;
        this.detallesExtra = detallesExtra;
    }

    public Nota(float nota, String nombre) {
        this.nota = nota;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(int idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDetallesExtra() {
        return detallesExtra;
    }

    public void setDetallesExtra(String detallesExtra) {
        this.detallesExtra = detallesExtra;
    }

    public String getInfo(ArrayList<RetroalimentacionNota> notas,ArrayList<RetroalimentacionNota> notaMateria) {
        String pasareEsto = "";
        int cont;
        ArrayList<RetroalimentacionNota> malas = new ArrayList<>();
        for (RetroalimentacionNota n : notas) {
                if (n.getPromedio() < 3) {
                    malas.add(n);
                }
        }
        if (!malas.isEmpty()) {
            cont=1;
            pasareEsto+="<br>Estas son los temas en que el estudiante ha sacado menos de 3: <br>";
            for (RetroalimentacionNota m : malas) {
                pasareEsto+=cont+". "+m.getTema()+"<br>";
                cont++;
                notas.remove(m);
            }
        }
        if(!notas.isEmpty()){
            cont=1;
            pasareEsto+="<br>Estas son los temas en que el estudiante ha pasado: <br>";
            for (RetroalimentacionNota m : notas) {
                pasareEsto+=cont+". "+m.getTema()+"<br>";
                cont++;
            }
        }
        pasareEsto+="<br>A continuación se encuentran las materias ordenadas por nota promedio<br>";
        ArrayList<String> bajas=new ArrayList<>();
        cont=1;
        for (RetroalimentacionNota n : notaMateria) {
            if(n.getPromedio()<3){
                bajas.add(n.getMateria());
            }
            pasareEsto+=cont+". "+n.getMateria()+": "+n.getPromedio()+"<br>";
            cont++;
        }
        if(!bajas.isEmpty()){
            pasareEsto+="<br>El sistema recomienda mirar estas materias ya que son las que se van perdiendo y hablar con el estudiante: <br>";
            for(String s:bajas){
                pasareEsto+=s+"<br>";
            }
            pasareEsto+="De igual forma se le recomienda mirar el observador pues allí puede haber información de mayor utilidad.";
        }
        return pasareEsto;
    }

    
    public String getTemasBoletin(ArrayList<BoletinEstudiante> notas) {
        String pasareEsto = "";
        int cont;
        cont=1;
            pasareEsto+="<br> <br>";
            for (BoletinEstudiante t : notas) {
                pasareEsto+=cont+". "+t.getTema()+": "+t.getNota()+"<br>";
                cont++;
            }
        
       
        return pasareEsto;
    }
}
