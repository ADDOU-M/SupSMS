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
import java.util.List;
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
@WebServlet(name = "ListContactsServlet", urlPatterns = {"/contacts"})
public class ListContactsServlet extends HttpServlet {

    @EJB
    IContactService contactService;
    @EJB
    IUtilisateurService utilisateurService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur currentUser = this.utilisateurService.getByLogin(req.getAttribute("user").toString());
        List<Contact> contacts = this.contactService.listerParCarnet(currentUser.getCarnet().getId());
        req.setAttribute("contacts", contacts);
        req.setAttribute("nombreContacts", contacts.size());
        req.getRequestDispatcher("/jsp/listContacts.jsp").forward(req, resp);
    }

}
