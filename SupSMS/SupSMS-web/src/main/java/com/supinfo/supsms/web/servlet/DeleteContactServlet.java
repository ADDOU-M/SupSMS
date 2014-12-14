/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.service.IContactService;
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
@WebServlet(name = "DeleteContactServlet", urlPatterns = {"/deleteContact"})
public class DeleteContactServlet extends HttpServlet {

    @EJB
    private IContactService contactService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Contact c = this.contactService.recuperer(id);
        this.contactService.supprimer(c.getId());
        resp.sendRedirect(getServletContext().getContextPath() + "/contacts");

    }

}
