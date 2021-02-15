package API;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * The class is used to translate the information retrieved from the Food API.
 * The contents from connecting to the API URL produces a readable JSON file.
 * Last Updated 02/14/2021
 * @author Andy Cruse, modified by Edward Hicks
 */
public class FoodApiTranslator implements FoodApiInterface{
    private static final String baseURL = "https://api.spoonacular.com";
    private static final String apiKey = "2608aa6998b6435aafe55ed681664869";

    /**
     * This method is used to connect to the Food API via a URL and add the contents to a JSON file.
     * Then, the file is read to a String.
     */
    @Override
    public Object loadRecipeItem(int _id, String _loadItem) {
        // Builds base url string
        String searchString = "/recipes/" + _id + "/information?apiKey=" + FoodApiTranslator.apiKey;
        try{
            URL url = new URL(FoodApiTranslator.baseURL + searchString);
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