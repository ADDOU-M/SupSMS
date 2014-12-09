/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.dao;

import com.supinfo.supsms.dao.IMessageDAO;
import com.supinfo.supsms.entites.Message;
import com.supinfo.supsms.generiques.implementation.DAOGenerique;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class MessageDAO extends DAOGenerique<Message, Integer> implements IMessageDAO {

    public MessageDAO() {
        super(Message.class);
    }

    @Override
    public List<Message> listerParUtilisateur(Integer idUtilisateur) {
        Query q = em.createQuery("SELECT m FROM Message m WHERE m.emetteur.id =:idUtilisateur");
        q.setParameter("idUtilisateur", idUtilisateur);
        return q.getResultList();
    }

    @Override
    public List<Message> conversation(Integer idUtilisateur, Integer idContact) {
        Query q = em.createQuery("SELECT m FROM Message m WHERE m.emetteur.id =:idUtilisateur AND m.recepteur.id =:idContact");
        q.setParameter("idUtilisateur", idUtilisateur);
        q.setParameter("idContact", idContact);
        return q.getResultList();
    }

}
