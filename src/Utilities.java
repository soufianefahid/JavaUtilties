/**
 * Created by FAHID Soufiane on 25/02/2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public final class Utilities {

    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String tiff = "tiff";
    public final static String tif = "tif";
    public final static String png = "png";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

    /*
            Tout ce qui a rapport avec la base de donnée depuis la création de la connection jusqu'à
            sa fermeture
     */

    public static Connection Connect(String tablename){
        Connection conn = null ;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+tablename+"","root", "");
        }

        catch(Exception E){
            E.printStackTrace();
        }
        return conn;

    }
    public static void closeConnection(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStatement(PreparedStatement ps) {
        if(ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
