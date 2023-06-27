
package hospitalsystem;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class DBConnect {
    public static void main (String[] args){
    connect();
    }
    public static Connection connect()
    {
        Connection con = null;
        try{
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        
        }catch(ClassNotFoundException | SQLException e){
        JOptionPane.showMessageDialog(null, e);
        }
        
        return con;
}
}
