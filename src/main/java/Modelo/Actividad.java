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
public class Actividad {
    private int id;
    private String nombre;
    private int idTema;
  

    public Actividad() {
    }

    public Actividad(int id, String nombre, int idTema) {
        this.id = id;
        this.nombre = nombre;
        this.idTema = idTema;
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

    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", nombre=" + nombre + ", idTema=" + idTema + '}';
    }
    
    
}
