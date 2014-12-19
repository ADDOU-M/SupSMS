/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.service;

import com.supinfo.supsms.entites.SMS;
import com.supinfo.supsms.generiques.interfaces.IServiceGenerique;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ekue_Weledji
 */
@Remote
public interface IMessageService extends IServiceGenerique<SMS, Integer> {

    public List<SMS> listerParUtilisateur(String numeroUtilisateur);

    public List<SMS> conversation(String numeroUtilisateur, String numeroContact);

}
