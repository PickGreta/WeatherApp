import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class APIHandler {
    WeatherInfo callAPI(String cityName) {
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
                double temperature = currentData.get("temperature").getAsDouble();
                JsonArray weatherDescriptions = currentData.getAsJsonArray("weather_descriptions");

                String firstDescription = weatherDescriptions.size() > 0 ? weatherDescriptions.get(0).getAsString() : "N/A";

                WeatherInfo weatherInfo = new WeatherInfo(cityName, temperature, firstDescription);
                return weatherInfo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
