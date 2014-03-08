package com.webshop.webcode;

/**
 * Created by Oleg on 28.02.14.
 */
public class PagesGenerator {
    public static String getPage(String pageTitle, String content) {
        StringBuilder page = new StringBuilder();
        page.append("<html><head><title>"+pageTitle+"</title>" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/mainStyle.css\"></head>");
        page.append("<body>"+content+"</body></html>");
        return page.toString();
    }

    public static String getErrorPage(String content) {
        StringBuilder page = new StringBuilder();
        page.append("<html><head><title>Error</title>" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/mainStyle.css\"></head>");
        page.append("<body><h2><font color=red>Error!</font></h2><br/>"+content+"</body></html>");
        return page.toString();
    }

    public static String getComplexPage(String pageTitle, String content) {
        StringBuilder page = new StringBuilder();
        page.append("<html><head><title>"+pageTitle+"</title>" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/mainStyle.css\"></head>");
        page.append("<div id=\"bg\">"+
                "<div id=\"outer\">\n"+
                "<div id=\"header\">\n"+
                "<a href=\"http://www.javawebshop.com/\"><span class=\"header_text\">JavaWebShop</span></a>\n"+
                "<div id=\"search\">\n"+
                "<form action=\"http://google.com/search\">\n"+
                "<input class=\"text\" name=\"q\" size=\"32\" maxlength=\"64\" /><input class=\"button\" type=\"submit\" value=\"Search\" />\n"+
                "<input type=\"hidden\" name=\"sitesearch\" value=\"javawebshop.com\">\n"+
                "</form>\n"+
                "</div>\n"+
                "</div>\n"+
                "<div id=\"data\"><span class=\"text_style\">"+content+
                "</span></div>\n"+
                "</div>\t\n"+
                "<div id=\"copyright\">\n"+
                "&copy; <a href=\"http://vk.com/asinkingshipfullofoptimists\">Oleg Panichev</a>\n"+
                "</div>\t\n"+
                "</div></body></html>");
        return page.toString();
    }


}
