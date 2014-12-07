/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.dao;

import com.supinfo.supsms.dao.IUtilistateurDAO;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.implementation.DAOGenerique;
import javax.ejb.Stateless;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class UtilisateurDAO extends DAOGenerique<Utilisateur, Integer> implements IUtilistateurDAO {

    public UtilisateurDAO() {
        super(Utilisateur.class);
    }

}
