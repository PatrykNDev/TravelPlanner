import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SearchListener implements ActionListener {
    private JFrame jf;
    private MainWindow mw;
    public SearchListener(MainWindow mw){
        this.mw = mw;
    }

    public void decodeResponse(String response){
        Object obj= JSONValue.parse(response);
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray arr=(JSONArray)jsonObject.get("units");
       // String name = (String) jsonObject.get("results");
        mw.setTextArea1((String) arr.get(1));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String[] params = mw.getParams();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String response;
                Request r = new Request();
                try {
                    response = r.getRequest(params);
                    System.out.println(response);
                    //decodeResponse(response);
                     mw.setTextArea1(response);
                    //System.out.println(response);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }


            }
        });

    }
}
