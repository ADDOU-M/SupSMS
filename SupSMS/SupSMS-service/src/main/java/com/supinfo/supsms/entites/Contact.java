/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Ekue_Weledji
 */
@Entity
@DiscriminatorValue(value = "CONTACT")
public class Contact extends Personne {

    @Column(name = "BOITE_POSTALE")
    private Integer boitePostale;

    public Integer getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(Integer boitePostale) {
        this.boitePostale = boitePostale;
    }   

}
