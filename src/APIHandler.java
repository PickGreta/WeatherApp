import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class APIHandler {

    void callAPI() {
        //String apiKey = "8044c498e29af2db48f9a3e41021aa7d";
        //String apiURL = "http://api.weatherstack.com/current?access_key=8044c498e29af2db48f9a3e41021aa7d&query=Budapest";

        try {
            URL url = new URL("http://api.weatherstack.com/current?access_key=8044c498e29af2db48f9a3e41021aa7d&query=Budapest");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            System.out.println(response.toString());

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
