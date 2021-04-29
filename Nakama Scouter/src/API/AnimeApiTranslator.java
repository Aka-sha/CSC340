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
 * The class is used to translate the information retrieved from the Anime API.
 * The contents from connecting to the API URL produces a readable JSON file.
 *
 * Last Updated 04/16/2021
 * @author Andy Cruse
 */
public class AnimeApiTranslator implements AnimeApiInterface {

    private static final String ANIME_BASED_URL = "https://api.jikan.moe/v3";

    /**
     * This method is used to connect to the Anime/Manga API via a URL and add the contents to a JSON file.
     * Then, the file is read to a String
     */
    @Override
    public Object loadAnimeMangaItemByID(String _id, String _loadItem) {
        List<String> oneItem = new ArrayList<String>();
        oneItem.add(_loadItem);
        return this.loadSeveralAnimeMangaItemByID(_id, oneItem).get(0);
    }

    /**
     * This method is used to connect to the Anime/Manga API via a URL and add the contents to a JSON file.
     * This version of the method loads several elements at once without disconnecting the API.
     * @param _id
     * @param _loadItem
     * @return
     */
    @Override
    public List<Object> loadSeveralAnimeMangaItemByID(String _id, List<String> _loadItem) {
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
            List<Object> elements = new ArrayList<Object>();
            for (int i = 0; i < _loadItem.size(); i++)
                elements.add(obj.get(_loadItem.get(i)));
            return elements;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * This method is used to connect to the Anime/Manga API via a URL and add the contents to a JSON file.
     * This version of the method loads several elements at once without disconnecting the API.
     * This version of the method loads by user input/search rather than ID
     * @param
     * @param _searchQuery, _loadItem
     * @return elements
     */
    @Override
    public List<Object> loadSeveralAnimeMangaItemBySearch(List<String> _searchQuery, List<String> _loadItem) {
        // Builds base url string
        // searchQuery at 0 = type (anime or manga)
        // The last 2 in the Query should be Order By and Sort
        String searchString = "/search/" + _searchQuery.get(0) + "?q=&genre="; // + _searchQuery.get(1) + "," + _searchQuery.get(2) + "," + _searchQuery.get(3) + "&order_by=" + _searchQuery.get(4) + "&sort=" + _searchQuery.get(5);
        for (int i = 1; i < _searchQuery.size()-2; i++) {
            searchString = searchString + _searchQuery.get(i);
            // the search string needs a comma to seperate for each genre, but cannot have one before the order_by specification
            if (i != _searchQuery.size() - 3) {
                searchString = searchString + ",";
            }
        }
        searchString = searchString + "&order_by=" + _searchQuery.get(4) + "&sort=" + _searchQuery.get(5);
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
            JSONArray results = (JSONArray)obj.get("results");
            List<Object> elements = new ArrayList<Object>();
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                //elements.add(item.getString(_loadItem.get(i)));
                for (int j = 0; j < _loadItem.size(); j++) {
                    elements.add(item.getString(_loadItem.get(j)));
                }
            }
            return elements;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * This method is used to connect to the Anime/Manga API via a URL and add the contents to a JSON file.
     * Then, the file is read to an arrayList for the loaditem
     */
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
            JSONArray results = (JSONArray)obj.get("results");
            ArrayList<Object> arrayList = new ArrayList<Object>();
            //adds loaditem to arrayList
            for(int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                arrayList.add(item.getString(_loadItem));
            }
            return arrayList;
        } catch (Exception ex) {
            return null;
        }
    }
}
