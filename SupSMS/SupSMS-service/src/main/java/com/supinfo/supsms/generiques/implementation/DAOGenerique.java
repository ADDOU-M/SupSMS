/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.generiques.implementation;

import com.supinfo.supsms.generiques.interfaces.IDAOGenerique;
import com.supinfo.supsms.generiques.interfaces.IFiltreForm;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author martin
 * @param <T>
 * @param <PK>
 */
public class DAOGenerique<T, PK extends java.io.Serializable> implements IDAOGenerique<T, PK> {

    @PersistenceContext(unitName = "SupSMS-PU")
    protected EntityManager em;
    protected Class<T> type;
    protected CriteriaBuilder cb;

    public DAOGenerique() {

    }

    public DAOGenerique(Class<T> type) {
        this.type = type;
    }

    protected CriteriaBuilder getCb() {
        if (this.cb != null) {
            return this.cb;
        }
        this.cb = em.getCriteriaBuilder();
        return this.cb;
    }

    @Override
    public Class<T> getType() {
        return type;
    }

    @Override
    public T ajouter(T t) {
        em.persist(t);
        return t;
    }

    @Override
    public T modifier(T t) {
        return (T) em.merge(t);
    }

    @Override
    public void supprimer(PK k) {
        T t = em.find(type, k);
        em.remove(t);
    }

    @Override
    public void supprimer(T t) {
        em.remove(t);
    }

    @Override
    public void supprimer() {
        String jpql = "DELETE FROM " + type.getSimpleName();
        Query q = em.createQuery(jpql);

    }

    @Override
    public List<T> lister() {
        String jpql = "SELECT t FROM " + type.getSimpleName() + " t";
        Query q = em.createQuery(jpql);
        return q.getResultList();
    }

    @Override
    public List<T> listerCriteria() {
        CriteriaQuery<T> c = getCb().createQuery(type);
        Root<T> t = c.from(type);
        c.select(t);
        TypedQuery<T> q = em.createQuery(c);
        return (List<T>) q.getResultList();
    }

    @Override
    public List<T> lister(int debut, int nombre, String tri, boolean asc) {
        return (List<T>) em.createQuery("SELECT t FROM " + type.getSimpleName()
                + " t ORDER BY t." + tri
                + ((asc) ? " ASC" : " DESC")).setFirstResult(debut).setMaxResults(nombre).getResultList();
    }

    @Override
    public List<T> lister(int debut, int nombre, String tri, boolean asc, IFiltreForm filtre) {
        Query q = filtre.query(em, tri, ((asc) ? "ASC" : "DESC"));
        q.setFirstResult(debut);
        q.setMaxResults(nombre);
        return (List<T>) q.getResultList();
    }

    @Override
    public T recuperer(PK k) {
        return (T) em.find(type, k);
    }

    @Override
    public List<T> executerRequete(String requete, String sortAttrib, String sortDir) {
        return (List<T>) this.executerRequete(em.createQuery(requete));
    }

    @Override
    public List<T> executerRequete(Query requete) {
        return (List<T>) requete.getResultList();
    }

    @Override
    public List<T> executerRequete(IFiltreForm filtreForm, String sortAttrib, String sortDir) {
        return executerRequete(filtreForm.query(em, sortAttrib, sortDir));
    }

}
