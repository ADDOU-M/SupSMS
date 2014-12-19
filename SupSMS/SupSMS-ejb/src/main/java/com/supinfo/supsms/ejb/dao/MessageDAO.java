/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.dao;

import com.supinfo.supsms.dao.IMessageDAO;
import com.supinfo.supsms.entites.SMS;
import com.supinfo.supsms.generiques.implementation.DAOGenerique;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class MessageDAO extends DAOGenerique<SMS, Integer> implements IMessageDAO {

    public MessageDAO() {
        super(SMS.class);
    }

    @Override
    public List<SMS> listerParUtilisateur(String numeroUtilisateur) {
        Query q = em.createQuery("SELECT m FROM SMS m WHERE m.numeroEmetteur =:numeroUtilisateur");
        q.setParameter("numeroUtilisateur", numeroUtilisateur);
        return q.getResultList();
    }

    @Override
    public List<SMS> conversation(String numeroUtilisateur, String numeroContact) {
        Query q = em.createQuery("SELECT m FROM SMS m WHERE m.numeroEmetteur =:numeroUtilisateur AND m.numeroRecepteur =:numeroContact");
        q.setParameter("numeroUtilisateur", numeroUtilisateur);
        q.setParameter("numeroContact", numeroContact);
        return q.getResultList();
    }

}
