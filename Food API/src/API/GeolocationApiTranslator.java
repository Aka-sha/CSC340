package API;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The class is used to translate the information retrieved from the Geolocation API.
 * The contents from connecting to the API URL produces a readable JSON file.
 * Last Updated 03/23/2021
 * @author Andy Cruse
 */

public class GeolocationApiTranslator implements GeolocationApiInterface{
    private static final String baseURL = "http://ip-api.com/json/";

    /**
     * This method is used to connect to the Location API via a URL and add the contents to a JSON file.
     * Then, the file is read to a String.
     * @param _ipAddress, _loadItem
     * @return _loadItem
     */
    @Override
    public Object loadLocation(String _ipAddress, String _loadItem){
        try{
            URL url = new URL(GeolocationApiTranslator.baseURL + _ipAddress + "?fields=status,city,query");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            // Build the content from the buffered input
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close connections
            in.close();
            connection.disconnect();
            // Extract JSON object
            JSONObject obj = new JSONObject(content.toString());
            return obj.getString(_loadItem);
        } catch (Exception ex) {
            return null;
        }
    }
}
