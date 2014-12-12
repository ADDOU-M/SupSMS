/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Carnet;
import com.supinfo.supsms.entites.Utilisateur;
import com.supinfo.supsms.service.ICarnetService;
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
@WebServlet(name = "AddUserServlet", urlPatterns = {"/sign-up"})
public class AddUserServlet extends HttpServlet {

    @EJB
    private IUtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/addUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = new Utilisateur();
        u.setNom(req.getParameter("nom"));
        u.setPrenom(req.getParameter("prenom"));
        u.setNumeroCarteCredit(req.getParameter("carteCredit"));
        u.setNumeroTelephone(req.getParameter("telephone"));
        u.setPassword(req.getParameter("password"));
        u.seteMail(req.getParameter("email"));
        u.setLogin(req.getParameter("telephone"));
        u.setCarnet(new Carnet());
        try {
            this.utilisateurService.ajouter(u);
            req.getSession().setAttribute("user", u.getLogin());
            req.getSession().setAttribute("fullName", u.getFullName());
            resp.sendRedirect(getServletContext().getContextPath());
        } catch (Exception ex) {
            resp.sendRedirect(req.getContextPath() + "/sign-up");
        }

    }

}
