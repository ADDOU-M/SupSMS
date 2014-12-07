/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.generiques.interfaces;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Ekue_Weledji
 * @param <T>
 * @param <PK>
 */
public interface IServiceGenerique<T, PK extends java.io.Serializable> {

    public T ajouter(T t);

    public T modifier(T t);

    public boolean supprimer(PK k);

    public boolean supprimer(T t);

    public void supprimer();

    public List<T> lister();

    public List<T> lister(int debut, int nombre, String tri, boolean asc);

    List<T> lister(int debut, int nombre, String tri, boolean asc, IFiltreForm filtre);

    public T recuperer(PK k);

    public List<T> lister(IFiltreForm q);

    public List<T> listerCriteria();

    public void supprimer(Collection<T> ts);

    public void supprimer(Iterator<T> ts);

}
