/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.dao;

import com.supinfo.supsms.entites.Message;
import com.supinfo.supsms.generiques.interfaces.IDAOGenerique;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ekue_Weledji
 */
@Remote
public interface IMessageDAO extends IDAOGenerique<Message, Integer> {

    public List<Message> listerParUtilisateur(Integer idUtilisateur);
    public List<Message> conversation(String numeroUtilisateur, String numeroContact);

}
