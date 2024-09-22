package Banking_management_system;
import java.sql.*;
public class conn {
    //public PreparedStatement s;
   Statement s ;

    public conn() {//will do try catch because sql gives errors
        Connection c;
        //Statement s;

        try {
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankingManagementSystem", "root" , "1234");
            s = c.createStatement();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {

    }
}
