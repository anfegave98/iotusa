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
public class ConsultaCMS {
    private int idcm;
    private String nombre;

    public ConsultaCMS() {
    }

    public ConsultaCMS(int idcm, String nombre) {
        this.idcm = idcm;
        this.nombre = nombre;
    }

    public int getIdcm() {
        return idcm;
    }

    public void setIdcm(int idcm) {
        this.idcm = idcm;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
