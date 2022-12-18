package com.bvs.portfolioap.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String lugarE;
    @NotBlank
    private String startE;
    @NotBlank
    private String endE;
    @NotBlank
    private String descripcionE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String lugarE, String startE, String endE, String descripcionE) {
        this.nombreE = nombreE;
        this.lugarE = lugarE;
        this.startE = startE;
        this.endE = endE;
        this.descripcionE = descripcionE;
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
