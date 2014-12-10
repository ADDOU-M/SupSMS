/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.dao;

import com.supinfo.supsms.dao.IUtilistateurDAO;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.implementation.DAOGenerique;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class UtilisateurDAO extends DAOGenerique<Utilisateur, Integer> implements IUtilistateurDAO {

    public UtilisateurDAO() {
        super(Utilisateur.class);
    }

    @Override
    public Utilisateur getByLogin(String login) {
        Query q = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login =:login");
        q.setParameter("login", login);
        return (Utilisateur) q.getSingleResult();
    }

}
