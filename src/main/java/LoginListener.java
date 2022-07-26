import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginListener implements ActionListener {
    private LoginWindow loginWindow;
    private User user;

    public LoginListener(LoginWindow lf){
        this.loginWindow = lf;
    }

    public void updateUserTable(String username){
         user = new User(username);

        JDBC con = new JDBC();
        try {
            con.createStatement();
            con.executeUpdate("INSERT INTO user (UserName) " + "VALUES ('"+ username +"')");
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        loginWindow.setVisible(false);
        String username = loginWindow.getTextField1();
        updateUserTable(username);

        MainWindow uf = new MainWindow(this.user);

    }

}
