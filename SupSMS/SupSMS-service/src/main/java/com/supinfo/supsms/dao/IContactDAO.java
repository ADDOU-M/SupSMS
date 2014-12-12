/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.dao;

import com.supinfo.supsms.entites.Carnet;
import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.generiques.interfaces.IDAOGenerique;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ekue_Weledji
 */
@Remote
public interface IContactDAO extends IDAOGenerique<Contact, Integer> {

    public List<Contact> listerParCarnet(Integer idCarnet);

    public boolean alreadyExistsInAdressBook(String numeroTelephone, Carnet carnet);

}
