/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.IContactService;
import com.supinfo.supsms.service.IUtilisateurService;
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
@WebServlet(name = "AddContactServlet", urlPatterns = {"/new-contact"})
public class AddContactServlet extends HttpServlet {

    @EJB
    private IContactService contactService;
    @EJB
    private IUtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addContact.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contact c = new Contact();
        c.setNom(req.getParameter("nom"));
        c.setPrenom(req.getParameter("prenom"));
        c.setNumeroTelephone(req.getParameter("telephone"));
        c.seteMail(req.getParameter("email"));
        c.setBoitePostale(Integer.valueOf(req.getParameter("boitePostale")));
        String login = req.getSession().getAttribute("user").toString();
        Utilisateur u = this.utilisateurService.getByLogin(login);
        c.setCarnet(u.getCarnet());
        if (!this.contactService.alreadyExistsInAdressBook(c.getNumeroTelephone(), u.getCarnet())) {
            this.contactService.ajouter(c);
        }
        resp.sendRedirect(req.getContextPath() + "/new-contact");

    }

}
