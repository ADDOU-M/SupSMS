/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.ejb.service.MessageService;
import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.entites.SMS;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.IContactService;
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
@WebServlet(name = "DeleteContactServlet", urlPatterns = {"/deleteContact"})
public class DeleteContactServlet extends HttpServlet {

    @EJB
    private IContactService contactService;
    @EJB
    private IMessageService messageService;
    @EJB
    private IUtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //récupération de l'utilisateur en cours
        Utilisateur u = this.utilisateurService.getByLogin(req.getSession().getAttribute("user").toString());
        //récupération du contact à supprimer
        Integer id = Integer.valueOf(req.getParameter("id"));
        Contact c = this.contactService.recuperer(id);
        //récupération et suppression de la conversation avec ce contact
        List<SMS> messages = this.messageService.conversation(u.getLogin(), c.getNumeroTelephone());
        if (!messages.isEmpty()) {
            this.messageService.supprimer(messages);
        }
        //supression du contact
        this.contactService.supprimer(c.getId());
        resp.sendRedirect(getServletContext().getContextPath() + "/contacts");

    }

}
