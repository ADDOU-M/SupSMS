/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.filtres.UtilisateurFiltreForm;
import com.supinfo.supsms.service.IUtilisateurService;
import java.util.List;
import java.util.LinkedList;
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
@WebServlet(name = "ListUsersServlet", urlPatterns = {"/users"})
public class ListUsersServlet extends HttpServlet {

    @EJB
    IUtilisateurService utilisateurService;
    private UtilisateurFiltreForm filtre;
    private List<Utilisateur> users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (this.filtre != null) {
            this.users = this.utilisateurService.lister(this.filtre);
        } else {
            this.users = this.utilisateurService.lister();
        }
        req.setAttribute("users", users);
        req.getRequestDispatcher("/jsp/listUsers.jsp").forward(req, resp);
    }

    public UtilisateurFiltreForm getFiltre() {
        return filtre;
    }

    public void setFiltre(UtilisateurFiltreForm filtre) {
        this.filtre = filtre;
    }

    public IUtilisateurService getUtilisateurService() {
        return utilisateurService;
    }

    public void setUtilisateurService(IUtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

}
