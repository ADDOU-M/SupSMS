/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.generiques.interfaces;

import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Ekue_Weledji
 * @param <T>
 * @param <PK>
 */
public interface IDAOGenerique<T, PK extends java.io.Serializable> {

    Class<T> getType();

    public T ajouter(T t);

    public T modifier(T t);

    public void supprimer(PK k);

    public void supprimer(T t);

    public void supprimer();

    public List<T> lister();

    public List<T> lister(int debut, int nombre, String tri, boolean asc);

    List<T> lister(int debut, int nombre, String tri, boolean asc, IFiltreForm filtre);

    public T recuperer(PK k);

    public List<T> executerRequete(String requete, String sortAttrib, String sortDir);

    List<T> executerRequete(IFiltreForm filtreForm, String sortAttrib, String sortDir);

    public List<T> executerRequete(Query requete);

    public List<T> listerCriteria();

}
