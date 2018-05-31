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
public class Estudiante {
    private String idEstudiante;
    private String nombre;
    private String celularContacto;
    private String direccion;
    private String fechaNacimiento;
    private String tipoSangre;
    private int idCurso;
    

    public Estudiante() {
    }

    public Estudiante(String idEstudiante, String nombre, String celularContacto, String direccion, String fechaNacimiento, String tipoSangre, int idCurso) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.celularContacto = celularContacto;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.idCurso = idCurso;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelularContacto() {
        return celularContacto;
    }

    public void setCelularContacto(String celularContacto) {
        this.celularContacto = celularContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "idEstudiante=" + idEstudiante + ", nombre=" + nombre + ", celularContacto=" + celularContacto + ", direccion=" + direccion + ", fechaNacimiento=" + fechaNacimiento +  ", tipoSangre=" + tipoSangre + ", idCurso=" + idCurso + '}';
    }
    
    
    
    

  
}
