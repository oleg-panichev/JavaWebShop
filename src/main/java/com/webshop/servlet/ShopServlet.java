package com.webshop.servlet;

import com.webshop.entity.Item;
import com.webshop.entity.Client;
import com.webshop.dao.DAOFactory;
import com.webshop.dao.ItemDAO;
import com.webshop.webcode.PagesGenerator;

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
    ItemDAO itemDAO = DAOFactory.getDAOFactory(DAOFactory.HIBERNATE).getItemDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        StringBuilder pageContent=new StringBuilder();
        Client client=(Client)request.getSession().getAttribute("client");

        if (client!=null) {
            pageContent.append("<font size=\"15\">Hello, <b>"+client.getLogin()+"</b>!</font> " +
                    "<a href=\"/logout\"><img src=\"btnExit.png\"></a><br><br>");

            if (request.getParameter("do")!=null) {
                switch(request.getParameter("do")) {
                    case ("buy"):
                        if( request.getParameter("itemid")!=null) {
                            Item item=itemDAO.getItem(Integer.parseInt(request.getParameter("itemid")));
                            client.addOrder(item);
                            item.setClient(client);
                            itemDAO.updateItem(item);
                            request.getSession().setAttribute("client",client);
                        }
                        break;
                    case ("sell"):
                        if( request.getParameter("itemid")!=null) {
                            Item item=itemDAO.getItem(Integer.parseInt(request.getParameter("itemid")));
                            client.removeOrder(item);
                            item.removeClient();
                            itemDAO.updateItem(item);
                            request.getSession().setAttribute("client",client);
                        }
                }
            }

            if(client.getNumberOfOrders()>0) {
                pageContent.append("<b>Your orders list:</b><br/>");
                pageContent.append("<ul>");
                for(Item i:client.getOrders()) {
                    pageContent.append("<li>"+i.getItemName()+", "+i.getItemPrice()+"$, " +
                            "<a href=\"/shop?do=sell&itemid="+i.getItemId()+"\">Sell</a></li>");
                }
                pageContent.append("</ul><br>");
            } else {
                pageContent.append("You have no orders yet.<br/>");
            }


            List<Item> itemList= itemDAO.getAvailableItems();
            if (itemList.size()>0) {
                pageContent.append("<br/>Our products:<br/><table border=\"1\">");
                for(Item item:itemList) {
                    pageContent.append("<tr>"+item.prepareDataForWebTable());
                    pageContent.append("<td><a href=\"/shop?do=buy&itemid="+item.getItemId()+
                            "\"><img src=\"btnBuy.png\"></td></tr>");
                }
                pageContent.append("</table>");
            } else {
                pageContent.append("Sorry! No items available for sale now. Come back later.<br>");
            }
            out.print(PagesGenerator.getPage("JavaWebShop", pageContent.toString()));
        } else {
            response.sendRedirect("/index.jsp");
        }
    }
}
