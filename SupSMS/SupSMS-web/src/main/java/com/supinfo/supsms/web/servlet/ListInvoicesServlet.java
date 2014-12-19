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
import java.io.IOException;
import java.util.Collections;
import java.util.List;
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
@WebServlet(name = "ListInvoicesServlet", urlPatterns = {"/list-invoices"})
public class ListInvoicesServlet extends HttpServlet {

    @EJB
    IUtilisateurService utilisateurService;
    @EJB
    IFactureService factureService;

    List<Facture> factures = Collections.EMPTY_LIST;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            Utilisateur currentUser = this.utilisateurService.getByLogin(req.getSession().getAttribute("user").toString());
            factures = this.factureService.listerParUtilisateur(currentUser);
        }
        if (req.getSession().getAttribute("admin") != null) {
            factures = this.factureService.lister();
        }
        req.setAttribute("factures", factures);
        req.getRequestDispatcher("/jsp/listInvoices.jsp").forward(req, resp);

    }

}
