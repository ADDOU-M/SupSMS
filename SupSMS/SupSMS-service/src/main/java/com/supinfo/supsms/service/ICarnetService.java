/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.supsms.service;

import com.supinfo.supsms.entites.Carnet;
import com.supinfo.supsms.generiques.interfaces.IServiceGenerique;
import javax.ejb.Remote;

/**
 *
 * @author Ekue_Weledji
 */
@Remote
public interface ICarnetService extends IServiceGenerique<Carnet,Integer>  {
    
}
