package API;

import org.json.JSONObject;
import org.json.JSONArray;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is used to translate the information retrieved from the Food API.
 * The contents from connecting to the API URL produces a readable JSON file.
 *
 * Last Updated 04/14/2021
 * @author Andy Cruse
 */
public class RestaurantApiTranslator implements RestaurantApiInterface {
    static config config = new config();
    private static final String RESTAURANT_BASE_URL = "https://api.documenu.com/v2/restaurant";
    private static final String RESTAURANT_API_KEY = config.restAPIKey;


    /**
     * This method is used to connect to the Restaurant API, Documenu, via a URL and add the contents to a JSON file.
     * Then, the file is read to an arrayList to get each loaditem
     */
    @Override
    public Object loadRestaurantItemBySearch(String _latitude, String _longitude, String _distance, String _cuisine, String _loadItem) {
        String searchString = "s/search/geo?" + "key=" + RestaurantApiTranslator.RESTAURANT_API_KEY + "&lat=" + _latitude + "&lon=" + _longitude + "&distance=" + _distance + "&cuisine=" + _cuisine;
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
            JSONArray data = (JSONArray)obj.get("data");
            ArrayList<Object> arrayList = new ArrayList<Object>();
            //adds every _loadItem to an arrayList
            for(int i = 0; i < data.length(); i++) {
                JSONObject item = data.getJSONObject(i);
                arrayList.add(item.getString(_loadItem));
            }
            return arrayList;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Object> loadRestaurantItemBySearch(List<String> _searchQuery, List<String> _loadItems){
        String searchString = "s/search/geo?" + "key=" + RestaurantApiTranslator.RESTAURANT_API_KEY + "&lat=" + _searchQuery.get(0) + "&lon=" + _searchQuery.get(1) + "&distance=" + _searchQuery.get(2) + "&cuisine=" + _searchQuery.get(3);
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
            JSONArray data = (JSONArray)obj.get("data");
            List<Object> dataList = new ArrayList<Object>();
            //adds every _loadItem to an arrayList
            for (int i = 0; i < data.length(); i++) {
                JSONObject item = data.getJSONObject(i);
                for (int j = 0; j < _loadItems.size(); j++) {
                    dataList.add(item.getString(_loadItems.get(j)));
                }
            }
            return dataList;
        }
        catch (Exception ex) {
            return null;
        }
    }
    /**
     * This method is used to connect to the Restaurant API, Documenu, via a URL and add the contents to a JSON file.
     * Then, the file is read to a String.
     * This is for testing purposes. CONSIDER DELETING!
     */
    public Object loadRestaurantItemByID(String _id, String _loadItem) {
        String searchString = "/" +_id + "?key=" + RestaurantApiTranslator.RESTAURANT_API_KEY;
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
