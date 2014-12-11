/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Utilisateur;
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
@WebServlet(name = "LoggerServlet", urlPatterns = {"/logger"})
public class LoggerServlet extends HttpServlet {

    @EJB
    private IUtilisateurService utilisateurService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/logger.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Utilisateur u = this.utilisateurService.getByLogin(login);
        if (u != null) {
            //vérification du mot de passe
            if (u.getPassword().equals(password)) {
                req.getSession().setAttribute("user", login);
                req.getSession().setAttribute("fullName", u.getFullName());
                resp.sendRedirect(getServletContext().getContextPath());
            } else {
                doGet(req, resp);
            }
        } else {
            doGet(req, resp);
        }

    }

}
