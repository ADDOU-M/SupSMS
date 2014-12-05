/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.service;

import com.supinfo.supsms.dao.IAdresseDAO;
import com.supinfo.supsms.entites.Adresse;
import com.supinfo.supsms.generiques.implementation.ServiceGenerique;
import com.supinfo.supsms.service.IAdresseService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class AdresseService extends ServiceGenerique<Adresse, Integer> implements IAdresseService {

    @EJB
    private IAdresseDAO adresseDAO;

    public AdresseService() {
    }

    public AdresseService(IAdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    @Override
    public IAdresseDAO getDAO() {
        return this.adresseDAO;
    }

}
