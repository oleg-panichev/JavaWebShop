package com.webshop.webcode;

import com.webshop.Item;
import com.webshop.Client;
import com.webshop.db.DAOFactory;
import com.webshop.db.ItemDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Oleg on 28.02.14.
 */
public class ShopServlet extends javax.servlet.http.HttpServlet {
    ItemDAO itemDAO = DAOFactory.getDAOFactory(DAOFactory.QL).getItemDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        StringBuilder pageContent=new StringBuilder();
        Client u=(Client)request.getSession().getAttribute("user");

        pageContent.append("<font size=\"15\">Hello, <b>"+u.getLogin()+"</b>!</font> <a href=\"/logout\"><img src=\"btnExit.png\"></a><br><br>");
//        pageContent.append("<form action=\"/logout\"><input type=\"submit\" value=\"Exit\"/></form><br/>");

        if (request.getParameter("itemname")!=null && request.getParameter("itemprice")!=null) {
            u.addOrder(new Item(request.getParameter("itemname"),
                    Integer.parseInt(request.getParameter("itemprice"))));
            request.getSession().setAttribute("user",u);
        }

        if(u.getNumberOfOrders()>0) {
            pageContent.append("<b>Your orders list:</b><br/>");
            pageContent.append("<ul>");
            for(Item i:u.getOrders()) {
                pageContent.append("<li>"+i.getItemName()+", "+i.getItemPrice()+"$</li>");
            }
            pageContent.append("</ul><br>");
        } else {
            pageContent.append("You have no orders yet.<br/>");
        }

        pageContent.append("<br/>Our products:<br/><table border=\"1\">");
        List<Item> itemList= itemDAO.getAllItems();
        for(Item item:itemList) {
            pageContent.append("<tr>"+item.prepareDataForWebTable());
            pageContent.append("<td><a href=\"/shop?itemname="+item.getItemName()+
                    "&itemprice="+item.getItemPrice()+"\">"+
                    "<img src=\"btnBuy3.png\"></td></tr>");
        }
        pageContent.append("</table>");
        out.print(PagesGenerator.getComplexPage("JavaWebShop",pageContent.toString()));
    }
}