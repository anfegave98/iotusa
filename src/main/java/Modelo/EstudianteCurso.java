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
public class EstudianteCurso {
    private int idEstCur;
    private String idEstudiante;
    private int idCurso;
    private String fechaInicio;
    private String fechaFinal;

    public EstudianteCurso() {
    }

    public EstudianteCurso(int idEstCur, String idEstudiante, int idCurso, String fechaInicio, String fechaFinal) {
        this.idEstCur = idEstCur;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public int getIdEstCur() {
        return idEstCur;
    }

    public void setIdEstCur(int idEstCur) {
        this.idEstCur = idEstCur;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
}
