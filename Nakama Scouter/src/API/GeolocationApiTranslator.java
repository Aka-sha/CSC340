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
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address="; //1600%20Amphitheatre%20Parkway,%20Mountain%20View,%20CA&key=AIzaSyA8z0J4NUg9XsR3l5z3VlIeOEr9ido8fqo"
    private static final String API_KEY = "AIzaSyA8z0J4NUg9XsR3l5z3VlIeOEr9ido8fqo";
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
            URL url = new URL(GeolocationApiTranslator.BASE_URL + _address.replace(" ", "%20") + "&key=" + GeolocationApiTranslator.API_KEY);
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
            ArrayList<Object> arrayList = new ArrayList<Object>();
            // Extract JSON object. The format of this API is god awful
            JSONObject obj = new JSONObject(content.toString());
            JSONArray results = (JSONArray)obj.get("results");
            //There is only 1 index so never change the 0 unless the documentation is screwed
            //geoObject contains all the data needed
            JSONObject geoObject = results.getJSONObject(0);
            //pieces of the address like names and zip
            /**
             * 0: Number
             * 1: Street
             * 2: region? (not 100% sure needs more testing)
             * 3: city
             * 4: state
             * 5: country
             * 6: zipcode
             */
            //If we need to load it in _loadItems, this will cycle through each piece of the address
            //components JSON Array and find what we want to load
            JSONArray addressComponents = (JSONArray)geoObject.get("address_components");
            for(int i = 0; i < addressComponents.length(); i++) {
                JSONObject examineObj = addressComponents.getJSONObject(i);
                JSONArray typeArr = (JSONArray)examineObj.get("types");
                String type = typeArr.getString(0);
                if (_loadItem.contains(type)){
                    arrayList.add(examineObj.get("long_name"));
                }
            }
            JSONObject geometry = geoObject.getJSONObject("geometry");
            JSONObject location = geometry.getJSONObject("location");
            //adds latitude and longitude as the last 2 pieces to the _loadItem
            for(int i = _loadItem.size()-2; i < _loadItem.size(); i++) {
                arrayList.add(location.getString(_loadItem.get(i)));
            }
            return arrayList;
        } catch (Exception ex) {
            return null;
        }
    }
}
