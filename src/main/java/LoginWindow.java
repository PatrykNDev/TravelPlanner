import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginWindow extends JFrame{

    private JButton button1;
    private JPanel contentPanel;
    private JTextField textField1;

    public LoginWindow(){
        super("user login");
        loadComponents();
    }

    public void loadComponents(){
        this.setSize(400,200);
        this.add(contentPanel);
        LoginListener sl = new LoginListener(this);
        button1.addActionListener(sl);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        setDefaultOptions();
        this.setVisible(true);
    }

    public void setDefaultOptions(){
        FileReader reader = null;
        try {
            reader = new FileReader("config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties p = new Properties();
        try {
            p.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // zmi.lPasazerow=Integer.parseInt(p.getProperty("lPasazerow"));

        this.textField1.setText(p.getProperty("username"));
    }

    public String getTextField1(){
        return textField1.getText();
    }

}
