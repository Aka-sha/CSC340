package API;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The class is used to translate the information retrieved from the Geolocation API.
 * The contents from connecting to the API URL produces a readable JSON file.
 * Last Updated 04/25/2021
 * @author Andy Cruse
 */

public class GeolocationApiTranslator implements GeolocationApiInterface{
    private static final String BASE_URL = "http://api.positionstack.com/v1/forward?access_key="; //780b46c13583c487962bb1a0b511dbe7&query=
    private static final String API_KEY = "780b46c13583c487962bb1a0b511dbe7";
    /**
     * This method is used to connect to the Location API via a URL and add the contents to a JSON file.
     * Then, the file is read to a String.
     * @param _address, _loadItem
     * @return _loadItem
     */
    @Override
    public List<Object> loadLocation(String _address, List<String> _loadItem){
        try{
            //_loadItem will for this is almost always going to be an address
            //Address will be in normal format (1600 Penn Lane etc). Use replace on string to fit API call format
            URL url = new URL(GeolocationApiTranslator.BASE_URL + API_KEY + "&query=" + _address.replace(" ", "%20"));
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
            JSONArray data = (JSONArray)obj.get("data");
            //"data" returns a JSON Array even though the results are the same. Index 0 is all we need
            JSONObject item = data.getJSONObject(0);
            ArrayList<Object> arrayList = new ArrayList<Object>();
            //adds every _loadItem to an arrayList
            for(int i = 0; i < _loadItem.size(); i++) {
                arrayList.add(item.getString(_loadItem.get(i)));
            }
            return arrayList;
        } catch (Exception ex) {
            return null;
        }
    }
}
