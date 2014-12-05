/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.supsms.generiques.interfaces;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Ekue_Weledji
 */
public interface IFiltreForm extends Serializable{
    Query query(EntityManager em, String sortAttrib, String sortDir);
}