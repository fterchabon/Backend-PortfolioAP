
package com.bvs.portfolioap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String lugarE;
    private String startE;
    private String endE;
    private String descripcionE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String lugarE, String startE, String endE, String descripcionE) {
        this.nombreE = nombreE;
        this.lugarE = lugarE;
        this.startE = startE;
        this.endE = endE;
        this.descripcionE = descripcionE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getLugarE() {
        return lugarE;
    }

    public void setLugarE(String lugarE) {
        this.lugarE = lugarE;
    }

    public String getStartE() {
        return startE;
    }

    public void setStartE(String startE) {
        this.startE = startE;
    }

    public String getEndE() {
        return endE;
    }

    public void setEndE(String endE) {
        this.endE = endE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}



