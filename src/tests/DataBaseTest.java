import java.sql.*;

/**
 * Created by Oleg on 27.02.14.
 */
public class DataBaseTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        Connection con=DriverManager.getConnection("jdbc:derby:D:\\Dropbox\\Java\\JavaWebShop\\db");
        //Connection con=DriverManager.getConnection("jdbc:derby:/home/oleg/Dropbox/Java/JavaWebShop/db");
        PreparedStatement stmt=con.prepareStatement("SELECT login,password FROM users");
        ResultSet rs=stmt.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("login")+", "+rs.getString("password"));
        }
        stmt.close();
        con.close();
    }
}
