
package com.bvs.portfolioap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkill {
    

    private String nombreS;
    private String imgS;
    private int porcentajeS;
    private String softS;

    public dtoSkill() {
    }

    public dtoSkill(String nombreS, String imgS, int porcentajeS, String softS) {
        this.nombreS = nombreS;
        this.imgS = imgS;
        this.porcentajeS = porcentajeS;
        this.softS = softS;
    }

    public String getSoftS() {
        return softS;
    }

    public void setSoftS(String softS) {
        this.softS = softS;
    }
    

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public String getImgS() {
        return imgS;
    }

    public void setImgS(String imgS) {
        this.imgS = imgS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }
    
    
}
