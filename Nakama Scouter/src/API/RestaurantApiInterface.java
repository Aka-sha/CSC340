package API;

import java.util.List;

/**
 * This interface will define methods that are needed for the Restaurant API Translator
 * Last Updated 03/25/2021
 * @author Andy Cruse
 */
public interface RestaurantApiInterface {

    public Object loadRestaurantItemBySearch(String _latitude, String _longitude, String _distance, String _cuisine, String _loadItem);
    public List<Object> loadRestaurantItemBySearch(List<String> _searchQuery, List<String> _loadItems);
    public Object loadRestaurantItemByID(String _id, String _loadItem);

}
