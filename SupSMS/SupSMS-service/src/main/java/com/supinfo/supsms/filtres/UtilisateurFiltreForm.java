/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.filtres;

import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.generiques.interfaces.IFiltreForm;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ekue_Weledji
 */
public class UtilisateurFiltreForm implements IFiltreForm {

    private Utilisateur utilisateur;

    public UtilisateurFiltreForm() {
        this.utilisateur = new Utilisateur();
    }

    public UtilisateurFiltreForm(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Query query(EntityManager em, String sortAttrib, String sortDir) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Utilisateur> c = cb.createQuery(Utilisateur.class);
        Root<Utilisateur> t = c.from(Utilisateur.class);
        List<Predicate> criteria = new LinkedList<Predicate>();
        if (this.utilisateur != null) {
            //controle sur le nom de l'utilisateur
            if (this.utilisateur.getNom() != null) {
                ParameterExpression<String> p1 = cb.parameter(String.class, "nom");
                criteria.add(cb.like(cb.lower(t.get("nom").as(String.class)), cb.lower(p1)));
            }
            //controle sur le prénom de l'utilisateur
            if (this.utilisateur.getPrenom() != null) {
                ParameterExpression<String> p2 = cb.parameter(String.class, "prenom");
                criteria.add(cb.like(cb.lower(t.get("prenom").as(String.class)), cb.lower(p2)));
            }
            //controle sur le numéro de téléphone de l'utilisateur
            if (this.utilisateur.getNumeroTelephone() != null) {
                ParameterExpression<String> p3 = cb.parameter(String.class, "numeroTelephone");
                criteria.add(cb.like(cb.lower(t.get("numeroTelephone").as(String.class)), cb.lower(p3)));
            }
            //controle sur le numéro de la carte de crédit de l'utilisateur
            if (this.utilisateur.getNumeroCarteCredit() != null) {
                ParameterExpression<String> p4 = cb.parameter(String.class, "numeroCarteCredit");
                criteria.add(cb.like(cb.lower(t.get("numeroCarteCredit").as(String.class)), cb.lower(p4)));
            }
            //controle sur le login de l'utilisateur
            if (this.utilisateur.getNumeroCarteCredit() != null) {
                ParameterExpression<String> p5 = cb.parameter(String.class, "login");
                criteria.add(cb.like(cb.lower(t.get("login").as(String.class)), cb.lower(p5)));
            }

        }

        if (criteria.size() == 1) {
            c.where(criteria.get(0));
        } else {
            c.where(cb.and(criteria.toArray(new Predicate[0])));
        }

        if (sortAttrib != null && sortDir != null) {
            if ("DESC".equals(sortDir)) {
                c.orderBy(cb.desc(t.get(sortAttrib)));
            } else {
                c.orderBy(cb.asc(t.get(sortAttrib)));
            }
        } else {
            c.orderBy(cb.asc(t.get("nom")));
        }

        TypedQuery<Utilisateur> q = em.createQuery(c);

        if (this.utilisateur != null) {
            if (this.utilisateur.getNom() != null) {
                q.setParameter("nom", "%" + this.utilisateur.getNom() + "%");
            }
            if (this.utilisateur.getNom() != null) {
                q.setParameter("prenom", "%" + this.utilisateur.getPrenom() + "%");
            }
            if (this.utilisateur.getNom() != null) {
                q.setParameter("numeroTelephone", "%" + this.utilisateur.getNumeroTelephone() + "%");
            }
            if (this.utilisateur.getNom() != null) {
                q.setParameter("numeroCarteCredit", "%" + this.utilisateur.getNumeroCarteCredit() + "%");
            }
            if (this.utilisateur.getNom() != null) {
                q.setParameter("login", "%" + this.utilisateur.getLogin() + "%");
            }
        }
        return q;
    }

}
