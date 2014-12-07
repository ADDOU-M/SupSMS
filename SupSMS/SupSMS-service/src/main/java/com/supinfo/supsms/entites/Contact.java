/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.entites;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ekue_Weledji
 */
@Entity
@DiscriminatorValue(value = "CONTACT")
public class Contact extends Personne {

    @Column(name = "BOITE_POSTALE")
    private Integer boitePostale;

    @ManyToOne
    @JoinColumn(name = "ID_CARNET")
    private Carnet carnet;

    public Integer getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(Integer boitePostale) {
        this.boitePostale = boitePostale;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

}
