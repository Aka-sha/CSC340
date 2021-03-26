package API;

/**
 * This interface will define methods that are needed for the Restaurant API Translator
 * Last Updated 03/25/2021
 * @author Andy Cruse
 */
public interface RestaurantApiInterface {

    public Object loadRestaurantItemBySearch(double _latitude, double longitude, int _distance, String _cuisine, String _loadItem);
    public Object loadRestaurantItemByID(String _id, String _loadItem);

}
