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
public class Tema {
    private int idTema;
    private String nombre;
    private int idCM;

    public Tema() {
    }

    public Tema(int idTema, String nombre, int idCM) {
        this.idTema = idTema;
        this.nombre = nombre;
        this.idCM = idCM;
    }

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCM() {
        return idCM;
    }

    public void setIdCM(int idCM) {
        this.idCM = idCM;
    }
    
    
}
