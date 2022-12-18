
package com.bvs.portfolioap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String startEd;
    @NotBlank
    private String endEd;
    @NotBlank
    private String descripcionEd;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEd, String startEd, String endEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.startEd = startEd;
        this.endEd = endEd;
        this.descripcionEd = descripcionEd;
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
