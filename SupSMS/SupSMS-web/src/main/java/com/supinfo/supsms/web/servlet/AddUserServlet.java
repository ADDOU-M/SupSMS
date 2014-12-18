/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Carnet;
import com.supinfo.supsms.entites.Facture;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.IFactureService;
import com.supinfo.supsms.service.IUtilisateurService;
import java.util.Calendar;
import java.io.IOException;
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
@WebServlet(name = "AddUserServlet", urlPatterns = {"/sign-up"})
public class AddUserServlet extends HttpServlet {

    @EJB
    private IUtilisateurService utilisateurService;

    @EJB
    private IFactureService factureService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("login") != null) {
            Utilisateur u = this.utilisateurService.getByLogin(req.getParameter("login"));
            req.setAttribute("userToUpdate", u);
        }
        req.getRequestDispatcher("/jsp/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u;
        if (this.isAddingAction(req)) {
            u = new Utilisateur();
            this.getValuesFromForm(u, req);
            u.setCarnet(new Carnet());
            try {
                this.utilisateurService.ajouter(u);
                Utilisateur u1 = this.utilisateurService.getByLogin(u.getLogin());
                Facture f = this.genererFacture(u1);
                this.factureService.ajouter(f);
                this.authenticateUser(u, req);
                resp.sendRedirect(getServletContext().getContextPath());
            } catch (Exception ex) {
                resp.sendRedirect(req.getContextPath() + "/sign-up");
            }
        } else {
            u = this.utilisateurService.getByLogin(req.getParameter("login"));
            this.getValuesFromForm(u, req);
            try {
                this.utilisateurService.modifier(u);
                if (req.getSession().getAttribute("user") != null) {
                    this.authenticateUser(u, req);
                }
                resp.sendRedirect(getServletContext().getContextPath());
            } catch (Exception ex) {
                req.setAttribute("userToUpdate", u);
                resp.sendRedirect(req.getContextPath() + "/sign-up");
            }
        }

    }

    private void getValuesFromForm(Utilisateur u, HttpServletRequest req) {
        u.setNom(req.getParameter("nom"));
        u.setPrenom(req.getParameter("prenom"));
        u.setNumeroCarteCredit(req.getParameter("carteCredit"));
        u.setNumeroTelephone(req.getParameter("telephone"));
        u.setPassword(req.getParameter("password"));
        u.seteMail(req.getParameter("email"));
        u.setLogin(req.getParameter("telephone"));

    }

    private boolean isAddingAction(HttpServletRequest req) {
        if (req.getParameter("login") != null) {
            return false;
        } else {
            return true;
        }
    }

    private void authenticateUser(Utilisateur u, HttpServletRequest req) {
        req.getSession().setAttribute("user", u.getLogin());
        req.getSession().setAttribute("fullName", u.getFullName());
    }

    private Facture genererFacture(Utilisateur u) {
        Facture f = new Facture();
        f.setUtilisateur(u);
        f.setIsPaid(Boolean.TRUE);
        f.setDatePaiement(Calendar.getInstance().getTime());
        return f;
    }

}
