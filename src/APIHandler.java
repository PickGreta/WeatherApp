import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIHandler {
    void callAPI(String cityName) {
        String apiKey = "8044c498e29af2db48f9a3e41021aa7d";
        String apiURL = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + cityName;

        try {
            URL url = new URL(apiURL);
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

            JsonParser jsonParser = new JsonParser();
            JsonObject jsonResponse = (JsonObject) jsonParser.parse(response.toString());

            if (jsonResponse.has("current")) {
                JsonObject currentData = jsonResponse.getAsJsonObject("current");
                if (currentData.has("temperature")) {
                    double temperature = currentData.get("temperature").getAsDouble();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
