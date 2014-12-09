/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.service;

import com.supinfo.supsms.dao.IFactureDAO;
import com.supinfo.supsms.entites.Facture;
import com.supinfo.supsms.entites.Offre;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.implementation.ServiceGenerique;
import com.supinfo.supsms.service.IFactureService;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class FactureService extends ServiceGenerique<Facture, Integer> implements IFactureService {

    @EJB
    private IFactureDAO factureDAO;

    public FactureService() {
    }

    public FactureService(IFactureDAO factureDAO) {
        this.factureDAO = factureDAO;
    }

    @Override
    public IFactureDAO getDAO() {
        return this.factureDAO;
    }

    @Override
    public List<Facture> listerParOffre(Integer idOffre) {
        try {
            return this.factureDAO.listerParOffre(idOffre);
        } catch (Exception ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<Facture> listerParOffre(Offre o) {
        return this.listerParOffre(o.getId());
    }

    @Override
    public List<Facture> listerParUtilisateur(Integer idUtilisateur) {
        try {
            return this.factureDAO.listerParUtilisateur(idUtilisateur);
        } catch (Exception ex) {
            Logger.getLogger(Facture.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<Facture> listerParUtilisateur(Utilisateur u) {
        return this.factureDAO.listerParUtilisateur(u.getId());
    }

}
