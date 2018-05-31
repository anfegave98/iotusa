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
public class Curso {
    private int idCurso;
    private String nombre;
    private int numeroEstudiantes;

    public Curso() {
    }

    public Curso(int idCurso, String nombre, int numeroEstudiantes) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.numeroEstudiantes = numeroEstudiantes;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    public void setNumeroEstudiantes(int numeroEstudiantes) {
        this.numeroEstudiantes = numeroEstudiantes;
    }
    
    
    
}
