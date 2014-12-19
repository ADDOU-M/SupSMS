/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Facture;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.IFactureService;
import com.supinfo.supsms.service.IUtilisateurService;
import com.supinfo.supsms.web.utils.SupSMSConstantes;
import java.io.IOException;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ekue_Weledji
 */
@WebServlet(name = "RenewOfferServlet", urlPatterns = {"/renew-offer"})
public class RenewOfferServlet extends HttpServlet {

    @EJB
    private IFactureService factureService;
    @EJB
    private IUtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u1 = this.utilisateurService.getByLogin(req.getSession().getAttribute("user").toString());
        Facture f = this.genererFacture(u1);
        this.factureService.ajouter(f);
        resp.sendRedirect(getServletContext().getContextPath());
    }

    private Facture genererFacture(Utilisateur u) {
        Facture f = new Facture();
        f.setUtilisateur(u);
        f.setMontant(SupSMSConstantes.OFFER_AMOUNT);
        f.setIsPaid(Boolean.TRUE);
        f.setDatePaiement(Calendar.getInstance().getTime());
        return f;
    }

}
