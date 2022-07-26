
import java.awt.*;
import java.sql.SQLException;

public class main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginWindow sw = new LoginWindow();
            }
        });



        JDBC.forName("");
        JDBC.getConnection("");
        JDBC con = new JDBC();
        con.createStatement();

    }
}
