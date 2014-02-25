package com.webshop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Oleg on 25.02.14.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if(login.contains("<") || login.contains(">") || login.contains("\"") || login.contains("'") ||
                pass.contains("<") || pass.contains(">") || pass.contains("\"") || pass.contains("'")) {
            out.print("<html><head><title>Error</title><body>");
            out.print("<h2><font color=red>Error!</font><h2></br>Login and password cannot contain \",<,>,' symbols.");
            out.print("</body></html>");
        } else {
            out.print("<html><head><title>Login</title><body>Login good</body></html>");
        }
    }
}
