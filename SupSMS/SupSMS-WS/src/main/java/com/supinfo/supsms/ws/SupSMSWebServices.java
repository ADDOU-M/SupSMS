/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ws;

import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.entites.SMS;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.IContactService;
import com.supinfo.supsms.service.IMessageService;
import com.supinfo.supsms.service.IUtilisateurService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Ekue_Weledji
 */
@WebService
public class SupSMSWebServices {

    @EJB
    private IContactService contactService;
    @EJB
    private IUtilisateurService utilisateurService;
    @EJB
    private IMessageService messageService;

    @WebMethod(operationName = "contactList")
    public List<Contact> showContactList(String numeroUtilisateur) {
        Utilisateur u = this.utilisateurService.getByLogin(numeroUtilisateur);
        List<Contact> contactList = this.contactService.listerParCarnet(u.getCarnet());
        return contactList;
    }

    @WebMethod(operationName = "conversation")
    public List<SMS> showConversation(String numeroUtilisateur, String numeroContact) {
        Utilisateur u = this.utilisateurService.getByLogin(numeroUtilisateur);
        Contact c = this.contactService.getFromAdressBookByPhoneNumber(numeroContact, u.getCarnet());
        List<SMS> conversation = this.messageService.conversation(u.getNumeroTelephone(), c.getNumeroTelephone());
        return conversation;
    }

}
