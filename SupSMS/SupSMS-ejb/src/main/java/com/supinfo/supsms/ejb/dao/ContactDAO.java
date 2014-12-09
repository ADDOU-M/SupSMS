/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.dao;

import com.supinfo.supsms.dao.IContactDAO;
import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.generiques.implementation.DAOGenerique;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class ContactDAO extends DAOGenerique<Contact, Integer> implements IContactDAO {

    public ContactDAO() {
        super(Contact.class);
    }    

    @Override
    public List<Contact> listerParCarnet(Integer idCarnet) {
        Query q = em.createQuery("SELECT c FROM Contact c WHERE c.carnet.id =:idCarnet");
        q.setParameter("idCarnet", idCarnet);
        return q.getResultList();
    }

}
