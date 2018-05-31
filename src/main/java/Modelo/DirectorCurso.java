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
public class DirectorCurso {
    private String idDirector;
    private int id;
    private int idCurso;
    private String cedula;
    private String fechainicio;
    private String fechafinal;
    private String nombre;
    private String nombreCurso;

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public DirectorCurso() {
    }

    public DirectorCurso(String idProfesor, int idCurso, String cedula, String fechainicio, String fechafinal) {
        this.idDirector = idProfesor;
        this.idCurso = idCurso;
        this.cedula = cedula;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
    }
    
    public DirectorCurso(String nombre, int idCurso, String fechaInicio, String cedula ) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.idCurso = idCurso;
        this.fechainicio= fechaInicio;
        this.idDirector = idDirector;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(String fechafinal) {
        this.fechafinal = fechafinal;
    }

   

    public String getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(String idDirector) {
        this.idDirector = idDirector;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
}
