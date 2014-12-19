/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.SMS;
import com.supinfo.supsms.service.IMessageService;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ConversationServlet", urlPatterns = {"/conversation"})
public class ConversationServlet extends HttpServlet {

    @EJB
    private IMessageService messageService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SMS> messages = this.messageService.conversation(req.getSession().getAttribute("user").toString(), null);

    }

}
