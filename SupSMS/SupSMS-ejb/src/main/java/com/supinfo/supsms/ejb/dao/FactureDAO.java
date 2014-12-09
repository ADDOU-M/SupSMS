/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.dao;

import com.supinfo.supsms.dao.IFactureDAO;
import com.supinfo.supsms.entites.Facture;
import com.supinfo.supsms.generiques.implementation.DAOGenerique;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class FactureDAO extends DAOGenerique<Facture, Integer> implements IFactureDAO {

    public FactureDAO() {
        super(Facture.class);
    }

    @Override
    public List<Facture> listerParOffre(Integer idOffre) {
        Query q = em.createQuery("SELECT f FROM Facture f WHERE f.offre.id =:idOffre");
        q.setParameter("idOffre", idOffre);
        return q.getResultList();
    }

    @Override
    public List<Facture> listerParUtilisateur(Integer idUtilisateur) {
        Query q = em.createQuery("SELECT f FROM Facture f WHERE f.utilisateur.id =:idUtilisateur");
        q.setParameter("idUtilisateur", idUtilisateur);
        return q.getResultList();
    }

}
