
package com.bvs.portfolioap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreS;
    private String imgS;
    private int porcentajeS;
    private String softS;

    public Skill() {
    }

    public Skill(String nombreS, String imgS, int porcentajeS, String softS) {
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

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
