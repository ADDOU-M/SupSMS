/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.service;

import com.supinfo.supsms.dao.IMessageDAO;
import com.supinfo.supsms.entites.Message;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.implementation.ServiceGenerique;
import com.supinfo.supsms.service.IMessageService;
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
public class MessageService extends ServiceGenerique<Message, Integer> implements IMessageService {

    @EJB
    private IMessageDAO messageDAO;

    public MessageService() {
    }

    public MessageService(IMessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public IMessageDAO getDAO() {
        return this.messageDAO;
    }

    @Override
    public List<Message> listerParUtilisateur(Integer idUtilisateur) {
        try {
            return this.messageDAO.listerParUtilisateur(idUtilisateur);
        } catch (Exception ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<Message> listerParUtilisateur(Utilisateur u) {
        return this.listerParUtilisateur(u.getId());
    }

    @Override
    public List<Message> conversation(String numeroUtilisateur, String numeroContact) {
        try {
            return this.messageDAO.conversation(numeroUtilisateur, numeroContact);
        } catch (Exception ex) {
            Logger.getLogger(Message.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

}
