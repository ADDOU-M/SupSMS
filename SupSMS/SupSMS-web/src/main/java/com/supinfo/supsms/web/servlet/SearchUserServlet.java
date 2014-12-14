/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.filtres.UtilisateurFiltreForm;
import com.supinfo.supsms.service.IUtilisateurService;
import java.io.IOException;
import javax.ejb.EJB;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ekue_Weledji
 */
@WebServlet(name = "SearchUserServlet", urlPatterns = {"/search-user"})
public class SearchUserServlet extends HttpServlet {

    @EJB
    IUtilisateurService utilisateurService;

    private UtilisateurFiltreForm filtre = new UtilisateurFiltreForm();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/searchUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getValuesFromForm(filtre, req);
        ListUsersServlet redirectPage = new ListUsersServlet();
        redirectPage.setUtilisateurService(utilisateurService);
        redirectPage.setFiltre(filtre);
        redirectPage.doGet(req, resp);
//        req.setAttribute("filtre", filtre);
//        resp.sendRedirect(req.getContextPath() + "/users");
    }

    private void getValuesFromForm(UtilisateurFiltreForm u, HttpServletRequest req) {
        if(!req.getParameter("nom").isEmpty()){
            u.getUtilisateur().setNom(req.getParameter("nom"));
        }
        if(!req.getParameter("prenom").isEmpty()){
            u.getUtilisateur().setPrenom(req.getParameter("prenom"));
        }
        if(!req.getParameter("carteCredit").isEmpty()){
            u.getUtilisateur().setNumeroCarteCredit(req.getParameter("carteCredit"));
        }
        if(!req.getParameter("telephone").isEmpty()){
            u.getUtilisateur().setNumeroTelephone(req.getParameter("telephone"));
        }
        if(!req.getParameter("email").isEmpty()){
            u.getUtilisateur().seteMail(req.getParameter("email"));
        }       

    }

}
