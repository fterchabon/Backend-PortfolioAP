
package com.bvs.portfolioap.Dto;

import javax.validation.constraints.NotBlank;


public class dtoRedSocial {
    
    @NotBlank
    private String nombreR;
    @NotBlank
    private String linkR;

    public dtoRedSocial() {
    }

    public dtoRedSocial(String nombreR, String linkR) {
        this.nombreR = nombreR;
        this.linkR = linkR;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public String getLinkR() {
        return linkR;
    }

    public void setLinkR(String linkR) {
        this.linkR = linkR;
    }
    
    
    
}
