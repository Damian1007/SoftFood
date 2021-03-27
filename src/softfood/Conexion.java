package softfood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Damian
 */
public class Conexion {
    public static final String URL = "jdbc:mysql://localhost:3306/soft_food";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345";
    public Connection conec; 
    

    public Connection getConec() {
        conec = getConection();
        return conec;
    }
    
    public static Connection getConection(){
       Connection con = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa");
            }catch(Exception e){
               System.out.println(e);
            }
        return con;
    }
     
}
