package com.webshop.webapp;

import com.webshop.User;
import com.webshop.db.UserDAOdb;

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
    String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter out=response.getWriter();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if(login.contains("<") || login.contains(">") || login.contains("\"") || login.contains("'") ||
                pass.contains("<") || pass.contains(">") || pass.contains("\"") || pass.contains("'")) {
            out.print("<html><head><title>Error</title><body>");
            out.print("<h2><font color=red>Error!</font><h2></br>Login and password cannot contain \",<,>,' symbols.");
            out.print("</body></html>");
        } else {
            //String workingDir = "D:\\Dropbox\\Java\\JavaWebShop\\db";
            String workingDir = "D:/Dropbox/Java/JavaWebShop/db";
            Connection con= null;
            try {
                con = DriverManager.getConnection("jdbc:derby:D:\\Dropbox\\Java\\JavaWebShop\\db");
            } catch (SQLException e) {
                out.print(PagesGenerator.getErrorPage(e.toString()));
            }
            if (con!=null) {
                UserDAOdb uDao=new UserDAOdb(con);
                User u=uDao.getUser(login);
                if (u==null) {
                    if (pass.length()>=3) {
                        uDao.addUser(new User(login, pass));
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
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
