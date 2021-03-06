package com.webshop.servlet;

import com.webshop.entity.Client;
import com.webshop.dao.ClientDAO;
import com.webshop.dao.DAOFactory;
import com.webshop.webcode.PagesGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Oleg on 25.02.14.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    ClientDAO clientDAO;// = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE).getClientDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if(login.contains("<") || login.contains(">") || login.contains("\"") || login.contains("'") ||
                pass.contains("<") || pass.contains(">") || pass.contains("\"") || pass.contains("'")) {
            out.print(PagesGenerator.getErrorPage("Login and password cannot contain \",<,>,' symbols."));
        } else {
            Client client=clientDAO.getClient(login);
            if (client==null) {
                if (pass.length()>=3) {
                    client=new Client(login,pass);
                    client.setClientStatus(Client.STATUS_USER);
                    clientDAO.addClient(client);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("client",client);
                    response.sendRedirect("/shop");
                } else {
                    out.print(PagesGenerator.getErrorPage("Password length cannot be less then 3 symbols!"));
                }
            } else {
                if (client.checkPass(pass)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("client",client);
                    response.sendRedirect("/shop");
                } else {
                    out.print(PagesGenerator.getErrorPage("Wrong password!"));
                }
            }
        }
    }
}
