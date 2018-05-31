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
public class RetroalimentacionNota {
    private String materia;
    private int idcm;
    private String tema;
    private float promedio;

    public RetroalimentacionNota(String materia, int idcm, String tema, float promedio) {
        this.materia = materia;
        this.idcm = idcm;
        this.tema = tema;
        this.promedio = promedio;
    }

    public RetroalimentacionNota() {
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getIdcm() {
        return idcm;
    }

    public void setIdcm(int idcm) {
        this.idcm = idcm;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
    
    
}
