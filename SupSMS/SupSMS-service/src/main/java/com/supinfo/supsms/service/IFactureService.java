/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.service;

import com.supinfo.supsms.entites.Facture;
import com.supinfo.supsms.entites.Offre;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.interfaces.IServiceGenerique;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ekue_Weledji
 */
@Remote
public interface IFactureService extends IServiceGenerique<Facture, Integer> {

    public List<Facture> listerParOffre(Integer idOffre);

    public List<Facture> listerParOffre(Offre o);

    public List<Facture> listerParUtilisateur(Integer idUtilisateur);

    public List<Facture> listerParUtilisateur(Utilisateur u);

}
