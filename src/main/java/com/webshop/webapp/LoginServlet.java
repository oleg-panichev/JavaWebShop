package com.webshop.webapp;

import com.webshop.User;
import com.webshop.db.DAOFactory;
import com.webshop.db.UserDAO;
import com.webshop.db.UserDAOql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Oleg on 25.02.14.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    UserDAO udao = DAOFactory.getDAOFactory(DAOFactory.QL).getUserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if(login.contains("<") || login.contains(">") || login.contains("\"") || login.contains("'") ||
                pass.contains("<") || pass.contains(">") || pass.contains("\"") || pass.contains("'")) {
            out.print(PagesGenerator.getErrorPage("Login and password cannot contain \",<,>,' symbols."));
        } else {
            User u=udao.getUser(login);
            if (u==null) {
                if (pass.length()>=3) {
                    udao.addUser(new User(login, pass));
                    u=new User(login, pass);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user",u);
                    response.sendRedirect("/shop");
                } else {
                    out.print(PagesGenerator.getErrorPage("Password length cannot be less then 3 symbols!"));
                }
            } else {
                if (u.checkPass(pass)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("user",u);
                    response.sendRedirect("/shop");
                } else {
                    out.print(PagesGenerator.getErrorPage("Wrong password!"));
                }
            }
        }
    }
}
