package com.webshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleg on 28.02.14.
 */
public class ShopServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        StringBuilder pageContent=new StringBuilder();
        User u=(User)request.getSession().getAttribute("user");
        pageContent.append("Hello, "+u.getLogin()+"!<br/>");

        try {
            Connection con= DriverManager.getConnection("jdbc:derby:D:\\Dropbox\\Java\\JavaWebShop\\db");
            pageContent.append("Our products:<br/><table border=\"1\">");
            GoodsDBAO gdbao=new GoodsDBAO(con);
            List<Item> itemList=gdbao.getAllGoods();
            pageContent.append(itemList.size()+"");
            for(Item item:itemList) {
                pageContent.append(item.prepareDataForWebTable());
                pageContent.append("<td><form action=\"/shop\" method=\"GET\">"+
                        "<input type=\"submit\" value=\"Buy\"/></form></td>");
            }
            pageContent.append("</table>");

        } catch (SQLException e) {
            pageContent.append("<h2><font color=red>Error</h2></font><br/>" + e.toString() + "<br/>");
        }
        out.print(PagesGenerator.getPage("Shop",pageContent.toString()));
    }
}
