package com.webshop;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
        pageContent.append("Hello, <b>"+u.getLogin()+"</b>! ");
        pageContent.append("<form action=\"/index.jsp\"><input type=\"submit\" value=\"Exit\"/></form><br/>");

        if (request.getParameter("itemname")!=null && request.getParameter("itemprice")!=null) {
            u.addOrder(new Item(request.getParameter("itemname"),
                    Integer.parseInt(request.getParameter("itemprice"))));
            request.getSession().setAttribute("user",u);
        }

        pageContent.append("Your orders list:<br/>");
        if(u.getNumberOfOrders()>0) {
            pageContent.append("<ul>");
            for(Item o:u.getOrders()) {
                pageContent.append("<li>"+o.getItemName()+", "+o.getItemPrice()+"$</li>");
            }
            pageContent.append("</ul><br/>");
        } else {
            pageContent.append("You have no orders yet.<br/>");
        }

        try {
            Connection con= DriverManager.getConnection("jdbc:derby:D:\\Dropbox\\Java\\JavaWebShop\\db");
            pageContent.append("<br/>Our products:<br/><table border=\"1\">");
            GoodsDBAO gdbao=new GoodsDBAO(con);
            List<Item> itemList=gdbao.getAllGoods();
            for(Item item:itemList) {
                pageContent.append("<tr>"+item.prepareDataForWebTable());
                pageContent.append("<td><form action=\"/shop?itemname="+item.getItemName()+
                        "&itemprice="+item.getItemPrice()+"\" method=\"GET\">"+
                        "<input type=\"submit\" value=\"Buy\"/></form></td></tr>");
            }
            pageContent.append("</table>");

        } catch (SQLException e) {
            pageContent.append("<h2><font color=red>Error</h2></font><br/>" + e.toString() + "<br/>");
        }
        out.print(PagesGenerator.getPage("JavaWebShop",pageContent.toString()));
    }
}
