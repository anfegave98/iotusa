/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author FiJus
 */
public class consultaCM {
    private String curso;
    private String materia;
    private String profesor;
    private String fecha;

    public consultaCM() {
    }

    public consultaCM(String curso, String materia, String profesor, String fecha) {
        this.curso = curso;
        this.materia = materia;
        this.profesor = profesor;
        this.fecha = fecha;
    }

    public consultaCM(String curso, String materia, String profesor) {
        this.curso = curso;
        this.materia = materia;
        this.profesor = profesor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public consultaCM(String fecha) {
        this.fecha = fecha;
    }
    
}
