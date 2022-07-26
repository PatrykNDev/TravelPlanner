import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainWindow extends JFrame{
    private JTextField textField1;
    private JButton searchButton;
    private JPanel contentPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextArea textArea1;
    private JLabel LabelUser;
    private JLabel labelUser2;
    private User user;

    public MainWindow(User user) {
        super("Travel Planner");
        this.user=user;

        loadComponents();
    }

    public void loadComponents(){
        textArea1.setLineWrap(true);
        this.labelUser2.setText(user.getUserName());

        SearchListener sl = new SearchListener(this);
        searchButton.addActionListener(sl);
        this.add(contentPanel);
        this.setSize(800,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultParameters();

        this.setVisible(true);
    }

    public void setDefaultParameters(){

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

        this.textField1.setText(p.getProperty("name"));
        this.textField2.setText(p.getProperty("housenumber"));
        this.textField3.setText(p.getProperty("street"));
        this.textField4.setText(p.getProperty("postcode"));
        this.textField5.setText(p.getProperty("city"));
        this.textField6.setText(p.getProperty("country"));
    }

    public String[] getParams(){
        String[] params = new String[6];
        params[0]=this.textField1.getText();
        params[1]=this.textField2.getText();
        params[2]=this.textField3.getText();
        params[3]=this.textField4.getText();
        params[4]=this.textField5.getText();
        params[5]=this.textField6.getText();
        return params;
    }

    public void setTextArea1(String text){
        this.textArea1.setText(text);
    }

}
