import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
    private String url;

    public Request() {
    }

    public String getRequest(String[] params) throws IOException {
        this.url = "https://api.geoapify.com/v1/geocode/search?name=" + params[0] + "&housenumber=" + params[1] + "&street=" + params[2] + "&postcode=" + params[3] + "&city=" + params[4] + "&country=" + params[5] + "&format=json&apiKey=09f752dbbf5d491fb25927c96e5036b5";
        System.out.println(this.url);
        URL obj = new URL(this.url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        if (con instanceof HttpURLConnection) {
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("'GET' request is sent to URL : " + this.url + "\nResponse Code: " + responseCode);
            if (responseCode == 200) {
                System.out.println("'GET' Request is Succeeded Http Status Code: " + responseCode);
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer response = new StringBuffer();

                String inputLine;
                while((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();
                return response.toString();
            }
        }

        return "Not connected";
    }
}
