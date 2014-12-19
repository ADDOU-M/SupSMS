/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.entites.Facture;
import com.supinfo.supsms.entites.SMS;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.IContactService;
import com.supinfo.supsms.service.IFactureService;
import com.supinfo.supsms.service.IMessageService;
import com.supinfo.supsms.service.IUtilisateurService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Ekue_Weledji
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/deleteUser"})
public class DeleteUserServlet extends HttpServlet {

    @EJB
    private IContactService contactService;
    @EJB
    private IMessageService messageService;
    @EJB
    private IUtilisateurService utilisateurService;
    @EJB
    private IFactureService factureService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Utilisateur u = this.utilisateurService.recuperer(id);
        //supression de ses contacts
        List<Contact> contacts = this.contactService.listerParCarnet(u.getCarnet());
        if (!contacts.isEmpty()) {
            this.contactService.supprimer(contacts);
        }
        //supression de ses factures
        List<Facture> factures = this.factureService.listerParUtilisateur(u);
        if (!factures.isEmpty()) {
            this.factureService.supprimer(factures);
        }
        //supression de ses messages
        List<SMS> messages = this.messageService.listerParUtilisateur(u.getNumeroTelephone());
        if (!messages.isEmpty()) {
            this.messageService.supprimer(messages);
        }
        //suppression de l'utilisateur lui même
        this.utilisateurService.supprimer(u.getId());
        resp.sendRedirect(getServletContext().getContextPath() + "/users");

    }

}
