/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Ekue_Weledji
 */
@Entity
@Table(name = "ADRESSE")
@SequenceGenerator(name = "ADRESSE_GEN", sequenceName = "ADRESSE_SEQ")
public class Adresse extends BaseEntite {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ADRESSE_GEN")
    private Integer idAdresse;

    @Column(name = "NUMERO_TELEPHONE")
    private String numeroTelephone;

    @Column(name = "E_MAIL")
    private String eMail;

    @Column(name = "BOITE_POSTALE")
    private Integer boitePostale;

    @Column(name = "VILLE")
    private String ville;

    @Column(name = "PAYS")
    private String pays;

    @Column(name = "COMPLEMENT_ADRESSE")
    private String complementAdresse;

    @Transient
    private String fullAdress;

    public Adresse() {

    }

    public Integer getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Integer idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Integer getBoitePostale() {
        return boitePostale;
    }

    public void setBoitePostale(Integer boitePostale) {
        this.boitePostale = boitePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getFullAdress() {
        return this.idAdresse + " " + this.boitePostale + " " + this.ville + ", " + this.pays + " " + this.complementAdresse;
    }

    public void setFullAdress(String fullAdress) {
        this.fullAdress = fullAdress;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.idAdresse != null ? this.idAdresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Adresse other = (Adresse) obj;
        if (this.idAdresse != other.idAdresse && (this.idAdresse == null || !this.idAdresse.equals(other.idAdresse))) {
            return false;
        }
        return true;
    }
    
    

}
