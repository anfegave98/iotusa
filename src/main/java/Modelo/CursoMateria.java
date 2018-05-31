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
public class CursoMateria {
    private int idCM;
    private int idCurso;
    private int idMateria;
    private String idProfesor;
    private String fechaInicio;
    private String fechaFinal;

    public CursoMateria() {
    }

    public CursoMateria(int idCM, int idCurso, int idMateria, String idProfesor,String fechaInicio,String fechaFinal) {
        this.idCM = idCM;
        this.idCurso = idCurso;
        this.idMateria = idMateria;
        this.idProfesor = idProfesor;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicial(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    

    public int getIdCM() {
        return idCM;
    }

    public void setIdCM(int idCM) {
        this.idCM = idCM;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    
    
}
