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
public class ConsultaAsistencia {
    private String nombre;
    private String vino;
    private String fecha;
    public ConsultaAsistencia() {
    }

    public ConsultaAsistencia(String nombre, String vino) {
        this.nombre = nombre;
        this.vino = vino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVino() {
        return vino;
    }

    public void setVino(String vino) {
        this.vino = vino;
    }
    
    
}
