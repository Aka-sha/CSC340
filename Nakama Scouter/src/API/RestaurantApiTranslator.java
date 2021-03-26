package API;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The class is used to translate the information retrieved from the Food API.
 * The contents from connecting to the API URL produces a readable JSON file.
 *
 * TRANSLATOR NEEDS ADJUSTMENT (won't go deeper into the JSON files, for example try loading Restaurant Name)
 *
 * Last Updated 03/25/2021
 * @author Andy Cruse
 */
public class RestaurantApiTranslator implements RestaurantApiInterface {

    private static final String RESTAURANT_BASE_URL = "https://api.documenu.com/v2/restaurants/search/geo?";
    private static final String RESTAURANT_API_KEY = "6144484d3b41cf035960ad4820487068";

    /**
     * This method is used to connect to the Restaurant API, Documenu, via a URL and add the contents to a JSON file.
     * Then, the file is read to a String.
     */
    @Override
    public Object loadRestaurantItem(double _latitude, double _longitude, int _distance, String _cuisine, String _loadItem) {
        String searchString = "key=" + RestaurantApiTranslator.RESTAURANT_API_KEY + "&lat=" + _latitude + "&lon=" + _longitude + "&distance=" + _distance + "&cuisine=" + _cuisine;
        try {
            URL url = new URL(RestaurantApiTranslator.RESTAURANT_BASE_URL + searchString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            // Build the content from the buffered input
            StringBuffer content = new StringBuffer();
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
