/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.entites;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ekue_Weledji
 */
@Entity
@Table(name = "MESSAGE")
@SequenceGenerator(name = "MESSAGE_GEN", sequenceName = "MESSAGE_SEQ")
public class SMS extends BaseEntite {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "MESSAGE_GEN")
    private Integer id;

    @Column(name = "CONTENU")
    private String contenu;

    @Column(name = "NUMERO_EMETTEUR")
    private String numeroEmetteur;

    @Column(name = "NUMERO_RECEPTEUR")
    private String numeroRecepteur;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_ENVOI")
    private Date dateEnvoi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getNumeroEmetteur() {
        return numeroEmetteur;
    }

    public void setNumeroEmetteur(String numeroEmetteur) {
        this.numeroEmetteur = numeroEmetteur;
    }

    public String getNumeroRecepteur() {
        return numeroRecepteur;
    }

    public void setNumeroRecepteur(String numeroRecepteur) {
        this.numeroRecepteur = numeroRecepteur;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
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
        final SMS other = (SMS) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public Integer getPrimaryKey() {
        return this.getId();
    }

}
