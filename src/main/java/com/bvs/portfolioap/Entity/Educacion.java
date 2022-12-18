
package com.bvs.portfolioap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String startEd;
    private String endEd;
    private String descripcionEd;

    public Educacion() {
    }

    public Educacion(String nombreEd, String startEd, String endEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.startEd = startEd;
        this.endEd = endEd;
        this.descripcionEd = descripcionEd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getStartEd() {
        return startEd;
    }

    public void setStartEd(String startEd) {
        this.startEd = startEd;
    }

    public String getEndEd() {
        return endEd;
    }

    public void setEndEd(String endEd) {
        this.endEd = endEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }
    
    
    
    
    
    
}
