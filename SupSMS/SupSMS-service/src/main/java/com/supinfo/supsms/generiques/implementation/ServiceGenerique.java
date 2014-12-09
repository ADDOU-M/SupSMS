/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.supinfo.supsms.generiques.implementation;

import com.supinfo.supsms.generiques.interfaces.IDAOGenerique;
import com.supinfo.supsms.generiques.interfaces.IFiltreForm;
import com.supinfo.supsms.generiques.interfaces.IServiceGenerique;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;

/**
 *
 * @author Ekue_Weledji
 * @param <T>
 * @param <PK>
 */
public abstract class ServiceGenerique<T, PK extends java.io.Serializable> implements IServiceGenerique<T, PK> {
    public abstract IDAOGenerique<T, PK> getDAO();

    @Override
    public synchronized T ajouter(T t) {
        return this.getDAO().ajouter(t);
    }

    @Override
    public synchronized T modifier(T t) {
        return this.getDAO().modifier(t);
    }

    @Override
    public synchronized boolean supprimer(PK k) {
        try {
            this.getDAO().supprimer(k);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean supprimer(T t) {
        try {
            this.getDAO().supprimer(t);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void supprimer() {
        try {
            this.getDAO().supprimer();
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<T> lister() {
        try {
            return this.getDAO().lister();
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<T> listerCriteria() {
        try {
            return this.getDAO().listerCriteria();
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<T> lister(int debut, int nombre, String tri, boolean asc) {
        try {
            return this.getDAO().lister(debut, nombre, tri, asc);
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public List<T> lister(int debut, int nombre, String tri, boolean asc, IFiltreForm filtre) {
        try {
            return this.getDAO().lister(debut, nombre, tri, asc, filtre);
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public T recuperer(PK k) {
        try {
            return (T) this.getDAO().recuperer(k);
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<T> lister(IFiltreForm q) {
        try {
            return this.getDAO().executerRequete(q, null, null);
        } catch (Exception ex) {
            Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public void supprimer(Collection<T> ts) {
        this.supprimer(ts.iterator());
    }

    @Override
    public void supprimer(Iterator<T> ts) {
        while (ts.hasNext()) {
            try {
                this.getDAO().supprimer(ts.next());
            } catch (Exception ex) {
                Logger.getLogger(ServiceGenerique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
