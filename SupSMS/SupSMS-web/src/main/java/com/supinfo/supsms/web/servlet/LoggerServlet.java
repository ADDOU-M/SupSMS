/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.web.servlet;

import java.io.IOException;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/logger.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("login");
        String password = req.getParameter("password");
        
        /* 
            Don't do that on real life :-)
         */
        if("admin".equals(username) && "admin".equals(password)) {
            req.getSession().setAttribute("user", username);
            resp.sendRedirect(getServletContext().getContextPath());
        } else {
            doGet(req, resp);
        }
    }

}
