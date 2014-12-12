/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.service;

import com.supinfo.supsms.dao.IContactDAO;
import com.supinfo.supsms.entites.Carnet;
import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.generiques.implementation.ServiceGenerique;
import com.supinfo.supsms.service.IContactService;
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
public class ContactService extends ServiceGenerique<Contact, Integer> implements IContactService {

    @EJB
    private IContactDAO contactDAO;

    public ContactService() {
    }

    public ContactService(IContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Override
    public IContactDAO getDAO() {
        return this.contactDAO;
    }

    @Override
    public List<Contact> listerParCarnet(Carnet c) {
        return this.listerParCarnet(c.getId());
    }

    @Override
    public List<Contact> listerParCarnet(Integer idCarnet) {
        try {
            return this.contactDAO.listerParCarnet(idCarnet);
        } catch (Exception ex) {
            Logger.getLogger(Contact.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public boolean alreadyExistsInAdressBook(String numeroTelephone, Carnet carnet) {
        return this.contactDAO.alreadyExistsInAdressBook(numeroTelephone, carnet);
    }

}
