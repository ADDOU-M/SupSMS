/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.supsms.dao;

import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.interfaces.IDAOGenerique;
import javax.ejb.Remote;

/**
 *
 * @author Ekue_Weledji
 */
@Remote
public interface IUtilistateurDAO extends IDAOGenerique<Utilisateur,Integer> {
    
}
