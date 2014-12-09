/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.service;

import com.supinfo.supsms.entites.Message;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.interfaces.IServiceGenerique;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ekue_Weledji
 */
@Remote
public interface IMessageService extends IServiceGenerique<Message, Integer> {

    public List<Message> listerParUtilisateur(Integer idUtilisateur);

    public List<Message> listerParUtilisateur(Utilisateur u);

    public List<Message> conversation(Integer idUtilisateur, Integer idContact);

}
