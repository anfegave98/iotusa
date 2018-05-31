/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author anfeg
 */
public class ProfesorMateria {
     private String curso;
     private String Materia;

    public ProfesorMateria(String curso, String Materia) {
        this.curso = curso;
        this.Materia = Materia;
    }

    public ProfesorMateria() {
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String Materia) {
        this.Materia = Materia;
    }
     
}
