package com.webshop;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
                con = DriverManager.getConnection("jdbc:derby://localhost:1527/"+workingDir);
            } catch (SQLException e) {
                out.print("<html><head><title>Error</title><body>");
                out.print("<h2><font color=red>Error!</font></h2></br>jdbc:derby:"+workingDir+"</br>");
                out.print(e.toString());
                out.print("</body></html>");
                //e.printStackTrace();
            }
            if (con!=null) {
                UsersDAODb uDao=new UsersDAODb(con);
                User u=uDao.findUser(login);
                if (u==null) {
                    if (pass.length()>3) {
                        uDao.addUser(login,pass);
                        out.print("<html><head><title>Login</title><body>Login good</body></html>");
                    } else {

                    }
                } else {
                    if (u.checkPass(pass))
                        out.print("<html><head><title>Login</title><body>Login good</body></html>");
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
