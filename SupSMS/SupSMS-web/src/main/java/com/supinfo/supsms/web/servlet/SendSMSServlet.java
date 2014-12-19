/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entites.Contact;
import com.supinfo.supsms.entites.SMS;
import com.supinfo.supsms.service.IContactService;
import java.io.IOException;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

/**
 *
 * @author Ekue_Weledji
 */
@WebServlet(name = "SendSMSServlet", urlPatterns = {"/send-sms"})
public class SendSMSServlet extends HttpServlet {

    @EJB
    IContactService contactService;
    @Resource(mappedName = "NewMessageFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "NewMessage")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            Contact c = this.contactService.recuperer(id);
            req.setAttribute("contact", c);
        }
        req.getRequestDispatcher("/jsp/sendSMS.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SMS s = new SMS();
        s.setNumeroRecepteur(req.getParameter("numeroRecepteur"));
        s.setContenu(req.getParameter("contenu"));
        s.setNumeroEmetteur(req.getSession().getAttribute("user").toString());
        s.setDateEnvoi(Calendar.getInstance().getTime());
        if (this.sendSMS(s)) {
            resp.sendRedirect(req.getContextPath() + "/send-sms");
        }

    }

    private boolean sendSMS(SMS s) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            ObjectMessage message = session.createObjectMessage();
            message.setObject(s);
            messageProducer.send(message);
            messageProducer.close();
            connection.close();
            return true;

        } catch (JMSException ex) {
            ex.printStackTrace();
            return false;
        }

    }

}
