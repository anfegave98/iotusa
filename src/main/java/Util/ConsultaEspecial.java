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
public class ConsultaEspecial {
    private int idcm;
    private String nombre1;
    private String nombre2;

    public ConsultaEspecial() {
    }

    public ConsultaEspecial(int idcm, String nombre1, String nombre2) {
        this.idcm = idcm;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
    }

    public int getIdcm() {
        return idcm;
    }

    public void setIdcm(int idcm) {
        this.idcm = idcm;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }
    
    
}
