/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.ejb.service;

import com.supinfo.supsms.dao.IOffreDAO;
import com.supinfo.supsms.entites.Offre;
import com.supinfo.supsms.generiques.implementation.ServiceGenerique;
import com.supinfo.supsms.service.IOffreService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class OffreService extends ServiceGenerique<Offre, Integer> implements IOffreService {

    @EJB
    private IOffreDAO offreDAO;

    public OffreService() {
    }

    public OffreService(IOffreDAO offreDAO) {
        this.offreDAO = offreDAO;
    }

    @Override
    public IOffreDAO getDAO() {
        return this.offreDAO;
    }

}
