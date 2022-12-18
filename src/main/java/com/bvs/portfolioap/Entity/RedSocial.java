
package com.bvs.portfolioap.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RedSocial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreR;
    private String linkR;

    public RedSocial() {
    }

    public RedSocial(String nombreR, String linkR) {
        this.nombreR = nombreR;
        this.linkR = linkR;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
