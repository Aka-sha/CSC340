package API;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AnimeApiTranslator implements AnimeApiInterface {

    private static final String ANIME_BASED_URL = "https://api.jikan.moe/v3";

    @Override
    public Object loadAnimeMangaItemByID(String _id, String _loadItem) {
        // Builds base url string
        String searchString = "/anime/" + _id;
        try {
            URL url = new URL(AnimeApiTranslator.ANIME_BASED_URL + searchString);
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

    @Override
    public Object loadAnimeMangaItemSearch(String _type, String _genre1, String _genre2, String _genre3, String _orderBy, String _sort, String _loadItem) {
        // Builds base url string
        String searchString = "/search/" + _type + "?q=&genre=" + _genre1 + "," + _genre2 + "," + _genre3 + "&order_by=" + _orderBy + "&sort=" + _sort;
        try {
            URL url = new URL(AnimeApiTranslator.ANIME_BASED_URL + searchString);
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
