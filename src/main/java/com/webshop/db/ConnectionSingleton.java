package com.webshop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Oleg on 08.03.14.
 */
public class ConnectionSingleton {
    private static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_URL="jdbc:derby:D:\\Dropbox\\Java\\JavaWebShop\\db";
    private static Connection con=null;
    private static ConnectionSingleton ourInstance = new ConnectionSingleton();

    public static Connection getConnection() {
        if(con==null) {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                con = DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }

    private ConnectionSingleton() {
    }
}
