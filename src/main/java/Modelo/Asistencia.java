/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author FiJus
 */
public class Asistencia {
    private int idEstudianteCurso;
    private String Fecha;
    private String vino;

    public Asistencia() {
    }

    
    
    public Asistencia(int idEstudianteCurso, String Fecha, String vino) {
        this.idEstudianteCurso = idEstudianteCurso;
        this.Fecha = Fecha;
        this.vino = vino;
    }

    public int getIdEstudianteCurso() {
        return idEstudianteCurso;
    }

    public void setIdEstudianteCurso(int idEstudianteCurso) {
        this.idEstudianteCurso = idEstudianteCurso;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getVino() {
        return vino;
    }

    public void setVino(String vino) {
        this.vino = vino;
    }

   
    
    
}
