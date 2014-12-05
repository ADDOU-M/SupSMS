/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.supsms.ejb.dao;

import com.supinfo.supsms.dao.IAdresseDAO;
import com.supinfo.supsms.entites.Adresse;
import com.supinfo.supsms.generiques.implementation.DAOGenerique;
import javax.ejb.Stateless;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class AdresseDAO extends DAOGenerique<Adresse, Integer> implements IAdresseDAO {
    
}
