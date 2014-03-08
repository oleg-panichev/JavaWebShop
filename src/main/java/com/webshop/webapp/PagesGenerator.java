package com.webshop.webapp;

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
}
