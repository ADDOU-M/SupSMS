/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.service;

import com.supinfo.supsms.dao.IUtilistateurDAO;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.implementation.ServiceGenerique;
import com.supinfo.supsms.service.IUtilisateurService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class UtilisateurService extends ServiceGenerique<Utilisateur, Integer> implements IUtilisateurService {

    @EJB
    private IUtilistateurDAO utilistateurDAO;

    public UtilisateurService() {
    }

    public UtilisateurService(IUtilistateurDAO utilistateurDAO) {
        this.utilistateurDAO = utilistateurDAO;
    }

    @Override
    public IUtilistateurDAO getDAO() {
        return this.utilistateurDAO;
    }

    @Override
    public Utilisateur getByLogin(String login) {
        try {
            return (Utilisateur) this.getDAO().getByLogin(login);
        } catch (Exception ex) {
            Logger.getLogger(UtilisateurService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
