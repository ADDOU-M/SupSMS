/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.supsms.ejb.service;

import com.supinfo.supsms.dao.ICarnetDAO;
import com.supinfo.supsms.entites.Carnet;
import com.supinfo.supsms.generiques.implementation.ServiceGenerique;
import com.supinfo.supsms.service.ICarnetService;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ekue_Weledji
 */
@Stateless
public class CarnetService extends ServiceGenerique<Carnet, Integer> implements ICarnetService {

    @EJB
    private ICarnetDAO carnetDAO;

    public CarnetService() {
    }

    public CarnetService(ICarnetDAO carnetDAO) {
        this.carnetDAO = carnetDAO;
    }

    @Override
    public ICarnetDAO getDAO() {
        return this.carnetDAO;
    }
    
}
